
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 入党申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shenqingYuyue")
public class ShenqingYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(ShenqingYuyueController.class);

    private static final String TABLE_NAME = "shenqingYuyue";

    @Autowired
    private ShenqingYuyueService shenqingYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DanganService danganService;//档案
    @Autowired
    private DangkeService dangkeService;//党课
    @Autowired
    private DangkeCollectionService dangkeCollectionService;//党课收藏
    @Autowired
    private DangkeCommentbackService dangkeCommentbackService;//党课评价
    @Autowired
    private DangkeOrderService dangkeOrderService;//党课报名
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ExampaperService exampaperService;//试卷
    @Autowired
    private ExampapertopicService exampapertopicService;//试卷选题
    @Autowired
    private ExamquestionService examquestionService;//试题表
    @Autowired
    private ExamrecordService examrecordService;//考试记录表
    @Autowired
    private ExamredetailsService examredetailsService;//答题详情表
    @Autowired
    private ExamrewrongquestionService examrewrongquestionService;//错题表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private GongzuoService gongzuoService;//党务工作者
    @Autowired
    private KaoqinService kaoqinService;//签到信息
    @Autowired
    private LiuyanService liuyanService;//谈心谈话
    @Autowired
    private TixingService tixingService;//提醒
    @Autowired
    private XuexiService xuexiService;//在线学习
    @Autowired
    private XuexiCollectionService xuexiCollectionService;//在线学习收藏
    @Autowired
    private XuexiLiuyanService xuexiLiuyanService;//在线学习留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZuoyeService zuoyeService;//作业
    @Autowired
    private ZuoyeTijiaoService zuoyeTijiaoService;//作业提交
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("党务工作者".equals(role))
            params.put("gongzuoId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shenqingYuyueService.queryPage(params);

        //字典表数据转换
        List<ShenqingYuyueView> list =(List<ShenqingYuyueView>)page.getList();
        for(ShenqingYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShenqingYuyueEntity shenqingYuyue = shenqingYuyueService.selectById(id);
        if(shenqingYuyue !=null){
            //entity转view
            ShenqingYuyueView view = new ShenqingYuyueView();
            BeanUtils.copyProperties( shenqingYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shenqingYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingYuyueEntity shenqingYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shenqingYuyue:{}",this.getClass().getName(),shenqingYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shenqingYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShenqingYuyueEntity> queryWrapper = new EntityWrapper<ShenqingYuyueEntity>()
            .eq("yonghu_id", shenqingYuyue.getYonghuId())
            .in("shenqing_yuyue_yesno_types", new Integer[]{1,2})
            .eq("shenqing_yuyue_types", shenqingYuyue.getShenqingYuyueTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingYuyueEntity shenqingYuyueEntity = shenqingYuyueService.selectOne(queryWrapper);
//        if(shenqingYuyueEntity==null){
            shenqingYuyue.setInsertTime(new Date());
            shenqingYuyue.setShenqingYuyueYesnoTypes(1);
            shenqingYuyue.setCreateTime(new Date());
            shenqingYuyueService.insert(shenqingYuyue);
            return R.ok();
//        }else {
//            if(shenqingYuyueEntity.getShenqingYuyueYesnoTypes()==1)
//                return R.error(511,"有相同的待审核的数据");
//            else if(shenqingYuyueEntity.getShenqingYuyueYesnoTypes()==2)
//                return R.error(511,"有相同的审核通过的数据");
//            else
//                return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShenqingYuyueEntity shenqingYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shenqingYuyue:{}",this.getClass().getName(),shenqingYuyue.toString());
        ShenqingYuyueEntity oldShenqingYuyueEntity = shenqingYuyueService.selectById(shenqingYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shenqingYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(shenqingYuyue.getShenqingYuyueText()) || "null".equals(shenqingYuyue.getShenqingYuyueText())){
                shenqingYuyue.setShenqingYuyueText(null);
        }
        if("".equals(shenqingYuyue.getShenqingYuyueFile()) || "null".equals(shenqingYuyue.getShenqingYuyueFile())){
                shenqingYuyue.setShenqingYuyueFile(null);
        }
        if("".equals(shenqingYuyue.getShenqingYuyueYesnoText()) || "null".equals(shenqingYuyue.getShenqingYuyueYesnoText())){
                shenqingYuyue.setShenqingYuyueYesnoText(null);
        }

            shenqingYuyueService.updateById(shenqingYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShenqingYuyueEntity shenqingYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shenqingYuyueEntity:{}",this.getClass().getName(),shenqingYuyueEntity.toString());

        ShenqingYuyueEntity oldShenqingYuyue = shenqingYuyueService.selectById(shenqingYuyueEntity.getId());//查询原先数据

//        if(shenqingYuyueEntity.getShenqingYuyueYesnoTypes() == 2){//通过
//            shenqingYuyueEntity.setShenqingYuyueTypes();
//        }else if(shenqingYuyueEntity.getShenqingYuyueYesnoTypes() == 3){//拒绝
//            shenqingYuyueEntity.setShenqingYuyueTypes();
//        }
        shenqingYuyueEntity.setShenqingYuyueShenheTime(new Date());//审核时间
        shenqingYuyueService.updateById(shenqingYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShenqingYuyueEntity> oldShenqingYuyueList =shenqingYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shenqingYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ShenqingYuyueEntity> shenqingYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShenqingYuyueEntity shenqingYuyueEntity = new ShenqingYuyueEntity();
//                            shenqingYuyueEntity.setShenqingYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            shenqingYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shenqingYuyueEntity.setShenqingYuyueText(data.get(0));                    //申请理由 要改的
//                            shenqingYuyueEntity.setShenqingYuyueFile(data.get(0));                    //上传图片 要改的
//                            shenqingYuyueEntity.setInsertTime(date);//时间
//                            shenqingYuyueEntity.setShenqingYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            shenqingYuyueEntity.setShenqingYuyueTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            shenqingYuyueEntity.setShenqingYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            shenqingYuyueEntity.setShenqingYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            shenqingYuyueEntity.setShenqingYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            shenqingYuyueEntity.setCreateTime(date);//时间
                            shenqingYuyueList.add(shenqingYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("shenqingYuyueUuidNumber")){
                                    List<String> shenqingYuyueUuidNumber = seachFields.get("shenqingYuyueUuidNumber");
                                    shenqingYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shenqingYuyueUuidNumber = new ArrayList<>();
                                    shenqingYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shenqingYuyueUuidNumber",shenqingYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<ShenqingYuyueEntity> shenqingYuyueEntities_shenqingYuyueUuidNumber = shenqingYuyueService.selectList(new EntityWrapper<ShenqingYuyueEntity>().in("shenqing_yuyue_uuid_number", seachFields.get("shenqingYuyueUuidNumber")));
                        if(shenqingYuyueEntities_shenqingYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShenqingYuyueEntity s:shenqingYuyueEntities_shenqingYuyueUuidNumber){
                                repeatFields.add(s.getShenqingYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shenqingYuyueService.insertBatch(shenqingYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shenqingYuyueService.queryPage(params);

        //字典表数据转换
        List<ShenqingYuyueView> list =(List<ShenqingYuyueView>)page.getList();
        for(ShenqingYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShenqingYuyueEntity shenqingYuyue = shenqingYuyueService.selectById(id);
            if(shenqingYuyue !=null){


                //entity转view
                ShenqingYuyueView view = new ShenqingYuyueView();
                BeanUtils.copyProperties( shenqingYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shenqingYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingYuyueEntity shenqingYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shenqingYuyue:{}",this.getClass().getName(),shenqingYuyue.toString());
        Wrapper<ShenqingYuyueEntity> queryWrapper = new EntityWrapper<ShenqingYuyueEntity>()
            .eq("shenqing_yuyue_uuid_number", shenqingYuyue.getShenqingYuyueUuidNumber())
            .eq("yonghu_id", shenqingYuyue.getYonghuId())
            .eq("shenqing_yuyue_text", shenqingYuyue.getShenqingYuyueText())
            .in("shenqing_yuyue_yesno_types", new Integer[]{1,2})
            .eq("shenqing_yuyue_types", shenqingYuyue.getShenqingYuyueTypes())
            .eq("shenqing_yuyue_yesno_text", shenqingYuyue.getShenqingYuyueYesnoText())
//            .notIn("shenqing_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingYuyueEntity shenqingYuyueEntity = shenqingYuyueService.selectOne(queryWrapper);
        if(shenqingYuyueEntity==null){
            shenqingYuyue.setInsertTime(new Date());
            shenqingYuyue.setShenqingYuyueYesnoTypes(1);
            shenqingYuyue.setCreateTime(new Date());
        shenqingYuyueService.insert(shenqingYuyue);

            return R.ok();
        }else {
            if(shenqingYuyueEntity.getShenqingYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shenqingYuyueEntity.getShenqingYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

