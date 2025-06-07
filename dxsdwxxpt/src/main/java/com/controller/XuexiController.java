
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
 * 在线学习
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuexi")
public class XuexiController {
    private static final Logger logger = LoggerFactory.getLogger(XuexiController.class);

    private static final String TABLE_NAME = "xuexi";

    @Autowired
    private XuexiService xuexiService;


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
    private ShenqingYuyueService shenqingYuyueService;//入党申请
    @Autowired
    private TixingService tixingService;//提醒
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
        params.put("xuexiDeleteStart",1);params.put("xuexiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xuexiService.queryPage(params);

        //字典表数据转换
        List<XuexiView> list =(List<XuexiView>)page.getList();
        for(XuexiView c:list){
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
        XuexiEntity xuexi = xuexiService.selectById(id);
        if(xuexi !=null){
            //entity转view
            XuexiView view = new XuexiView();
            BeanUtils.copyProperties( xuexi , view );//把实体数据重构到view中
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
    public R save(@RequestBody XuexiEntity xuexi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuexi:{}",this.getClass().getName(),xuexi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XuexiEntity> queryWrapper = new EntityWrapper<XuexiEntity>()
            .eq("xuexi_name", xuexi.getXuexiName())
            .eq("zan_number", xuexi.getZanNumber())
            .eq("cai_number", xuexi.getCaiNumber())
            .eq("xuexi_video", xuexi.getXuexiVideo())
            .eq("xuexi_types", xuexi.getXuexiTypes())
            .eq("xuexi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuexiEntity xuexiEntity = xuexiService.selectOne(queryWrapper);
        if(xuexiEntity==null){
            xuexi.setZanNumber(1);
            xuexi.setCaiNumber(1);
            xuexi.setXuexiDelete(1);
            xuexi.setInsertTime(new Date());
            xuexi.setCreateTime(new Date());
            xuexiService.insert(xuexi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuexiEntity xuexi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuexi:{}",this.getClass().getName(),xuexi.toString());
        XuexiEntity oldXuexiEntity = xuexiService.selectById(xuexi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xuexi.getXuexiPhoto()) || "null".equals(xuexi.getXuexiPhoto())){
                xuexi.setXuexiPhoto(null);
        }
        if("".equals(xuexi.getXuexiFile()) || "null".equals(xuexi.getXuexiFile())){
                xuexi.setXuexiFile(null);
        }
        if("".equals(xuexi.getXuexiVideo()) || "null".equals(xuexi.getXuexiVideo())){
                xuexi.setXuexiVideo(null);
        }
        if("".equals(xuexi.getXuexiContent()) || "null".equals(xuexi.getXuexiContent())){
                xuexi.setXuexiContent(null);
        }

            xuexiService.updateById(xuexi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuexiEntity> oldXuexiList =xuexiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XuexiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XuexiEntity xuexiEntity = new XuexiEntity();
            xuexiEntity.setId(id);
            xuexiEntity.setXuexiDelete(2);
            list.add(xuexiEntity);
        }
        if(list != null && list.size() >0){
            xuexiService.updateBatchById(list);
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
            List<XuexiEntity> xuexiList = new ArrayList<>();//上传的东西
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
                            XuexiEntity xuexiEntity = new XuexiEntity();
//                            xuexiEntity.setXuexiName(data.get(0));                    //在线学习名称 要改的
//                            xuexiEntity.setXuexiUuidNumber(data.get(0));                    //在线学习编号 要改的
//                            xuexiEntity.setXuexiPhoto("");//详情和图片
//                            xuexiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            xuexiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            xuexiEntity.setXuexiFile(data.get(0));                    //文件 要改的
//                            xuexiEntity.setXuexiVideo(data.get(0));                    //视频 要改的
//                            xuexiEntity.setXuexiTypes(Integer.valueOf(data.get(0)));   //在线学习类型 要改的
//                            xuexiEntity.setXuexiContent("");//详情和图片
//                            xuexiEntity.setXuexiDelete(1);//逻辑删除字段
//                            xuexiEntity.setInsertTime(date);//时间
//                            xuexiEntity.setCreateTime(date);//时间
                            xuexiList.add(xuexiEntity);


                            //把要查询是否重复的字段放入map中
                                //在线学习编号
                                if(seachFields.containsKey("xuexiUuidNumber")){
                                    List<String> xuexiUuidNumber = seachFields.get("xuexiUuidNumber");
                                    xuexiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuexiUuidNumber = new ArrayList<>();
                                    xuexiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuexiUuidNumber",xuexiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //在线学习编号
                        List<XuexiEntity> xuexiEntities_xuexiUuidNumber = xuexiService.selectList(new EntityWrapper<XuexiEntity>().in("xuexi_uuid_number", seachFields.get("xuexiUuidNumber")).eq("xuexi_delete", 1));
                        if(xuexiEntities_xuexiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuexiEntity s:xuexiEntities_xuexiUuidNumber){
                                repeatFields.add(s.getXuexiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [在线学习编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuexiService.insertBatch(xuexiList);
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
        List<XuexiView> returnXuexiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("xuexiYesnoTypes",2);
        PageUtils pageUtils = xuexiCollectionService.queryPage(params1);
        List<XuexiCollectionView> collectionViewsList =(List<XuexiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(XuexiCollectionView collectionView:collectionViewsList){
            Integer xuexiTypes = collectionView.getXuexiTypes();
            if(typeMap.containsKey(xuexiTypes)){
                typeMap.put(xuexiTypes,typeMap.get(xuexiTypes)+1);
            }else{
                typeMap.put(xuexiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("xuexiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("xuexiYesnoTypes",2);
            PageUtils pageUtils1 = xuexiService.queryPage(params2);
            List<XuexiView> xuexiViewList =(List<XuexiView>)pageUtils1.getList();
            returnXuexiViewList.addAll(xuexiViewList);
            if(returnXuexiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("xuexiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = xuexiService.queryPage(params);
        if(returnXuexiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnXuexiViewList.size();//要添加的数量
            List<XuexiView> xuexiViewList =(List<XuexiView>)page.getList();
            for(XuexiView xuexiView:xuexiViewList){
                Boolean addFlag = true;
                for(XuexiView returnXuexiView:returnXuexiViewList){
                    if(returnXuexiView.getId().intValue() ==xuexiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnXuexiViewList.add(xuexiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnXuexiViewList = returnXuexiViewList.subList(0, limit);
        }

        for(XuexiView c:returnXuexiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnXuexiViewList);
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
        PageUtils page = xuexiService.queryPage(params);

        //字典表数据转换
        List<XuexiView> list =(List<XuexiView>)page.getList();
        for(XuexiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuexiEntity xuexi = xuexiService.selectById(id);
            if(xuexi !=null){


                //entity转view
                XuexiView view = new XuexiView();
                BeanUtils.copyProperties( xuexi , view );//把实体数据重构到view中

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
    public R add(@RequestBody XuexiEntity xuexi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuexi:{}",this.getClass().getName(),xuexi.toString());
        Wrapper<XuexiEntity> queryWrapper = new EntityWrapper<XuexiEntity>()
            .eq("xuexi_name", xuexi.getXuexiName())
            .eq("xuexi_uuid_number", xuexi.getXuexiUuidNumber())
            .eq("zan_number", xuexi.getZanNumber())
            .eq("cai_number", xuexi.getCaiNumber())
            .eq("xuexi_video", xuexi.getXuexiVideo())
            .eq("xuexi_types", xuexi.getXuexiTypes())
            .eq("xuexi_delete", xuexi.getXuexiDelete())
//            .notIn("xuexi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuexiEntity xuexiEntity = xuexiService.selectOne(queryWrapper);
        if(xuexiEntity==null){
                xuexi.setZanNumber(1);
                xuexi.setCaiNumber(1);
            xuexi.setXuexiDelete(1);
            xuexi.setInsertTime(new Date());
            xuexi.setCreateTime(new Date());
        xuexiService.insert(xuexi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

