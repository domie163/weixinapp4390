
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
 * 党课
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dangke")
public class DangkeController {
    private static final Logger logger = LoggerFactory.getLogger(DangkeController.class);

    private static final String TABLE_NAME = "dangke";

    @Autowired
    private DangkeService dangkeService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DanganService danganService;//档案
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
    private ShenqingYuyueService shenqingYuyueService;//入党申请
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
        params.put("dangkeDeleteStart",1);params.put("dangkeDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = dangkeService.queryPage(params);

        //字典表数据转换
        List<DangkeView> list =(List<DangkeView>)page.getList();
        for(DangkeView c:list){
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
        DangkeEntity dangke = dangkeService.selectById(id);
        if(dangke !=null){
            //entity转view
            DangkeView view = new DangkeView();
            BeanUtils.copyProperties( dangke , view );//把实体数据重构到view中
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
    public R save(@RequestBody DangkeEntity dangke, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dangke:{}",this.getClass().getName(),dangke.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DangkeEntity> queryWrapper = new EntityWrapper<DangkeEntity>()
            .eq("dangke_name", dangke.getDangkeName())
            .eq("dangke_address", dangke.getDangkeAddress())
            .eq("zan_number", dangke.getZanNumber())
            .eq("cai_number", dangke.getCaiNumber())
            .eq("dangke_types", dangke.getDangkeTypes())
            .eq("dangke_kucun_number", dangke.getDangkeKucunNumber())
            .eq("dangke_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DangkeEntity dangkeEntity = dangkeService.selectOne(queryWrapper);
        if(dangkeEntity==null){
            dangke.setZanNumber(1);
            dangke.setCaiNumber(1);
            dangke.setDangkeDelete(1);
            dangke.setInsertTime(new Date());
            dangke.setCreateTime(new Date());
            dangkeService.insert(dangke);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DangkeEntity dangke, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dangke:{}",this.getClass().getName(),dangke.toString());
        DangkeEntity oldDangkeEntity = dangkeService.selectById(dangke.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(dangke.getDangkePhoto()) || "null".equals(dangke.getDangkePhoto())){
                dangke.setDangkePhoto(null);
        }
        if("".equals(dangke.getDangkeContent()) || "null".equals(dangke.getDangkeContent())){
                dangke.setDangkeContent(null);
        }

            dangkeService.updateById(dangke);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DangkeEntity> oldDangkeList =dangkeService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DangkeEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DangkeEntity dangkeEntity = new DangkeEntity();
            dangkeEntity.setId(id);
            dangkeEntity.setDangkeDelete(2);
            list.add(dangkeEntity);
        }
        if(list != null && list.size() >0){
            dangkeService.updateBatchById(list);
        }

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
            List<DangkeEntity> dangkeList = new ArrayList<>();//上传的东西
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
                            DangkeEntity dangkeEntity = new DangkeEntity();
//                            dangkeEntity.setDangkeName(data.get(0));                    //党课名称 要改的
//                            dangkeEntity.setDangkeUuidNumber(data.get(0));                    //党课编号 要改的
//                            dangkeEntity.setDangkePhoto("");//详情和图片
//                            dangkeEntity.setDangkeAddress(data.get(0));                    //党课地点 要改的
//                            dangkeEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            dangkeEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            dangkeEntity.setDangkeTypes(Integer.valueOf(data.get(0)));   //党课类型 要改的
//                            dangkeEntity.setDangkeKucunNumber(Integer.valueOf(data.get(0)));   //参加人员 要改的
//                            dangkeEntity.setDangkeContent("");//详情和图片
//                            dangkeEntity.setDangkeDelete(1);//逻辑删除字段
//                            dangkeEntity.setInsertTime(date);//时间
//                            dangkeEntity.setCreateTime(date);//时间
                            dangkeList.add(dangkeEntity);


                            //把要查询是否重复的字段放入map中
                                //党课编号
                                if(seachFields.containsKey("dangkeUuidNumber")){
                                    List<String> dangkeUuidNumber = seachFields.get("dangkeUuidNumber");
                                    dangkeUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> dangkeUuidNumber = new ArrayList<>();
                                    dangkeUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("dangkeUuidNumber",dangkeUuidNumber);
                                }
                        }

                        //查询是否重复
                         //党课编号
                        List<DangkeEntity> dangkeEntities_dangkeUuidNumber = dangkeService.selectList(new EntityWrapper<DangkeEntity>().in("dangke_uuid_number", seachFields.get("dangkeUuidNumber")).eq("dangke_delete", 1));
                        if(dangkeEntities_dangkeUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DangkeEntity s:dangkeEntities_dangkeUuidNumber){
                                repeatFields.add(s.getDangkeUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [党课编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        dangkeService.insertBatch(dangkeList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<DangkeView> returnDangkeViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("dangkeYesnoTypes",2);
        PageUtils pageUtils = dangkeOrderService.queryPage(params1);
        List<DangkeOrderView> orderViewsList =(List<DangkeOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(DangkeOrderView orderView:orderViewsList){
            Integer dangkeTypes = orderView.getDangkeTypes();
            if(typeMap.containsKey(dangkeTypes)){
                typeMap.put(dangkeTypes,typeMap.get(dangkeTypes)+1);
            }else{
                typeMap.put(dangkeTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("dangkeTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("dangkeYesnoTypes",2);
            PageUtils pageUtils1 = dangkeService.queryPage(params2);
            List<DangkeView> dangkeViewList =(List<DangkeView>)pageUtils1.getList();
            returnDangkeViewList.addAll(dangkeViewList);
            if(returnDangkeViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("dangkeYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = dangkeService.queryPage(params);
        if(returnDangkeViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnDangkeViewList.size();//要添加的数量
            List<DangkeView> dangkeViewList =(List<DangkeView>)page.getList();
            for(DangkeView dangkeView:dangkeViewList){
                Boolean addFlag = true;
                for(DangkeView returnDangkeView:returnDangkeViewList){
                    if(returnDangkeView.getId().intValue() ==dangkeView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnDangkeViewList.add(dangkeView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnDangkeViewList = returnDangkeViewList.subList(0, limit);
        }

        for(DangkeView c:returnDangkeViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnDangkeViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = dangkeService.queryPage(params);

        //字典表数据转换
        List<DangkeView> list =(List<DangkeView>)page.getList();
        for(DangkeView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DangkeEntity dangke = dangkeService.selectById(id);
            if(dangke !=null){


                //entity转view
                DangkeView view = new DangkeView();
                BeanUtils.copyProperties( dangke , view );//把实体数据重构到view中

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
    public R add(@RequestBody DangkeEntity dangke, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dangke:{}",this.getClass().getName(),dangke.toString());
        Wrapper<DangkeEntity> queryWrapper = new EntityWrapper<DangkeEntity>()
            .eq("dangke_name", dangke.getDangkeName())
            .eq("dangke_uuid_number", dangke.getDangkeUuidNumber())
            .eq("dangke_address", dangke.getDangkeAddress())
            .eq("zan_number", dangke.getZanNumber())
            .eq("cai_number", dangke.getCaiNumber())
            .eq("dangke_types", dangke.getDangkeTypes())
            .eq("dangke_kucun_number", dangke.getDangkeKucunNumber())
            .eq("dangke_delete", dangke.getDangkeDelete())
//            .notIn("dangke_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DangkeEntity dangkeEntity = dangkeService.selectOne(queryWrapper);
        if(dangkeEntity==null){
                dangke.setZanNumber(1);
                dangke.setCaiNumber(1);
            dangke.setDangkeDelete(1);
            dangke.setInsertTime(new Date());
            dangke.setCreateTime(new Date());
        dangkeService.insert(dangke);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

