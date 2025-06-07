
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
 * 党课报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dangkeOrder")
public class DangkeOrderController {
    private static final Logger logger = LoggerFactory.getLogger(DangkeOrderController.class);

    private static final String TABLE_NAME = "dangkeOrder";

    @Autowired
    private DangkeOrderService dangkeOrderService;


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
        CommonUtil.checkMap(params);
        PageUtils page = dangkeOrderService.queryPage(params);

        //字典表数据转换
        List<DangkeOrderView> list =(List<DangkeOrderView>)page.getList();
        for(DangkeOrderView c:list){
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
        DangkeOrderEntity dangkeOrder = dangkeOrderService.selectById(id);
        if(dangkeOrder !=null){
            //entity转view
            DangkeOrderView view = new DangkeOrderView();
            BeanUtils.copyProperties( dangkeOrder , view );//把实体数据重构到view中
            //级联表 党课
            //级联表
            DangkeEntity dangke = dangkeService.selectById(dangkeOrder.getDangkeId());
            if(dangke != null){
            BeanUtils.copyProperties( dangke , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setDangkeId(dangke.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(dangkeOrder.getYonghuId());
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
    public R save(@RequestBody DangkeOrderEntity dangkeOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dangkeOrder:{}",this.getClass().getName(),dangkeOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            dangkeOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        dangkeOrder.setCreateTime(new Date());
        dangkeOrder.setInsertTime(new Date());
        dangkeOrderService.insert(dangkeOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DangkeOrderEntity dangkeOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dangkeOrder:{}",this.getClass().getName(),dangkeOrder.toString());
        DangkeOrderEntity oldDangkeOrderEntity = dangkeOrderService.selectById(dangkeOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            dangkeOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            dangkeOrderService.updateById(dangkeOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DangkeOrderEntity> oldDangkeOrderList =dangkeOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        dangkeOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<DangkeOrderEntity> dangkeOrderList = new ArrayList<>();//上传的东西
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
                            DangkeOrderEntity dangkeOrderEntity = new DangkeOrderEntity();
//                            dangkeOrderEntity.setDangkeOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            dangkeOrderEntity.setDangkeId(Integer.valueOf(data.get(0)));   //党课 要改的
//                            dangkeOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            dangkeOrderEntity.setDangkeOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            dangkeOrderEntity.setInsertTime(date);//时间
//                            dangkeOrderEntity.setCreateTime(date);//时间
                            dangkeOrderList.add(dangkeOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("dangkeOrderUuidNumber")){
                                    List<String> dangkeOrderUuidNumber = seachFields.get("dangkeOrderUuidNumber");
                                    dangkeOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> dangkeOrderUuidNumber = new ArrayList<>();
                                    dangkeOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("dangkeOrderUuidNumber",dangkeOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<DangkeOrderEntity> dangkeOrderEntities_dangkeOrderUuidNumber = dangkeOrderService.selectList(new EntityWrapper<DangkeOrderEntity>().in("dangke_order_uuid_number", seachFields.get("dangkeOrderUuidNumber")));
                        if(dangkeOrderEntities_dangkeOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DangkeOrderEntity s:dangkeOrderEntities_dangkeOrderUuidNumber){
                                repeatFields.add(s.getDangkeOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        dangkeOrderService.insertBatch(dangkeOrderList);
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
        PageUtils page = dangkeOrderService.queryPage(params);

        //字典表数据转换
        List<DangkeOrderView> list =(List<DangkeOrderView>)page.getList();
        for(DangkeOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DangkeOrderEntity dangkeOrder = dangkeOrderService.selectById(id);
            if(dangkeOrder !=null){


                //entity转view
                DangkeOrderView view = new DangkeOrderView();
                BeanUtils.copyProperties( dangkeOrder , view );//把实体数据重构到view中

                //级联表
                    DangkeEntity dangke = dangkeService.selectById(dangkeOrder.getDangkeId());
                if(dangke != null){
                    BeanUtils.copyProperties( dangke , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setDangkeId(dangke.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(dangkeOrder.getYonghuId());
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
    public R add(@RequestBody DangkeOrderEntity dangkeOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dangkeOrder:{}",this.getClass().getName(),dangkeOrder.toString());
            DangkeEntity dangkeEntity = dangkeService.selectById(dangkeOrder.getDangkeId());
            if(dangkeEntity == null){
                return R.error(511,"查不到该党课");
            }
            // Double dangkeNewMoney = dangkeEntity.getDangkeNewMoney();

//            if(false){
//            }
//            else if((dangkeEntity.getDangkeKucunNumber() -dangkeOrder.getBuyNumber())<0){
//                return R.error(511,"购买数量不能大于库存数量");
//            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
//            if(yonghuEntity.getNewMoney() == null)
//                return R.error(511,"用户金额不能为空");
//            double balance = yonghuEntity.getNewMoney() - dangkeEntity.getDangkeNewMoney()*dangkeOrder.getBuyNumber();//余额
//            if(balance<0)
//                return R.error(511,"余额不够支付");
            dangkeOrder.setDangkeOrderTypes(101); //设置订单状态为已报名
//            dangkeOrder.setDangkeOrderTruePrice(0.0); //设置实付价格
            dangkeOrder.setYonghuId(userId); //设置订单支付人id
            dangkeOrder.setDangkeOrderUuidNumber(String.valueOf(new Date().getTime()));
            dangkeOrder.setInsertTime(new Date());
            dangkeOrder.setCreateTime(new Date());
//                dangkeEntity.setDangkeKucunNumber( dangkeEntity.getDangkeKucunNumber() -dangkeOrder.getBuyNumber());
                dangkeService.updateById(dangkeEntity);
                dangkeOrderService.insert(dangkeOrder);//新增订单


            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String dangkeOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");


        String data = String.valueOf(params.get("dangkes"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> dangkes = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<DangkeOrderEntity> dangkeOrderList = new ArrayList<>();
        //商品表
        List<DangkeEntity> dangkeList = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : dangkes) {
           //取值
            Integer dangkeId = Integer.valueOf(String.valueOf(map.get("dangkeId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            DangkeEntity dangkeEntity = dangkeService.selectById(dangkeId);//购买的商品
            String id = String.valueOf(map.get("id"));

            //判断商品的库存是否足够
            if(dangkeEntity.getDangkeKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(dangkeEntity.getDangkeName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                dangkeEntity.setDangkeKucunNumber(dangkeEntity.getDangkeKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            DangkeOrderEntity dangkeOrderEntity = new DangkeOrderEntity<>();

            //赋值订单信息
            dangkeOrderEntity.setDangkeOrderUuidNumber(dangkeOrderUuidNumber);//订单编号
            dangkeOrderEntity.setDangkeId(dangkeId);//党课
                        dangkeOrderEntity.setYonghuId(userId);//用户
            dangkeOrderEntity.setDangkeOrderTypes(101);//订单类型
            dangkeOrderEntity.setInsertTime(new Date());//订单创建时间
            dangkeOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
//            if(dangkeOrderPaymentTypes == 1){//余额支付
//                //计算金额
//                Double money = new BigDecimal(dangkeEntity.getDangkeNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();
//
//                if(yonghuEntity.getNewMoney() - money <0 ){
//                    return R.error("余额不足,请充值！！！");
//                }else{
//                    //计算所获得积分
//                    Double buyJifen =0.0;
//
//
//                    dangkeOrderEntity.setDangkeOrderTruePrice(money);
//
//                }
//            }
            dangkeOrderList.add(dangkeOrderEntity);
            dangkeList.add(dangkeEntity);

        }
        dangkeOrderService.insertBatch(dangkeOrderList);
        dangkeService.updateBatchById(dangkeList);
        yonghuService.updateById(yonghuEntity);

        return R.ok();
    }


    /**
    * 取消报名
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            DangkeOrderEntity dangkeOrder = dangkeOrderService.selectById(id);//当前表service
            Integer dangkeId = dangkeOrder.getDangkeId();
            if(dangkeId == null)
                return R.error(511,"查不到该党课");
            DangkeEntity dangkeEntity = dangkeService.selectById(dangkeId);
            if(dangkeEntity == null)
                return R.error(511,"查不到该党课");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            Double zhekou = 1.0;

                //计算金额
//                Double money = dangkeEntity.getDangkeNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;



//            dangkeEntity.setDangkeKucunNumber(dangkeEntity.getDangkeKucunNumber() + buyNumber);

            dangkeOrder.setDangkeOrderTypes(102);//设置订单状态为已取消报名
            dangkeOrderService.updateAllColumnById(dangkeOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            dangkeService.updateById(dangkeEntity);//更新订单中党课的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer dangkeCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            DangkeOrderEntity dangkeOrder = dangkeOrderService.selectById(id);
        if(dangkeOrder == null)
            return R.error(511,"查不到该订单");
        Integer dangkeId = dangkeOrder.getDangkeId();
        if(dangkeId == null)
            return R.error(511,"查不到该党课");

        DangkeCommentbackEntity dangkeCommentbackEntity = new DangkeCommentbackEntity();
            dangkeCommentbackEntity.setId(id);
            dangkeCommentbackEntity.setDangkeId(dangkeId);
            dangkeCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            dangkeCommentbackEntity.setDangkeCommentbackText(commentbackText);
            dangkeCommentbackEntity.setInsertTime(new Date());
            dangkeCommentbackEntity.setReplyText(null);
            dangkeCommentbackEntity.setUpdateTime(null);
            dangkeCommentbackEntity.setCreateTime(new Date());
            dangkeCommentbackService.insert(dangkeCommentbackEntity);

            dangkeOrder.setDangkeOrderTypes(105);//设置订单状态为已评价
            dangkeOrderService.updateById(dangkeOrder);//根据id更新
            return R.ok();
    }

    /**
     * 同意
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        DangkeOrderEntity  dangkeOrderEntity = dangkeOrderService.selectById(id);
        dangkeOrderEntity.setDangkeOrderTypes(103);//设置订单状态为已同意
        dangkeOrderService.updateById( dangkeOrderEntity);

        return R.ok();
    }


    /**
     * 参加
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        DangkeOrderEntity  dangkeOrderEntity = dangkeOrderService.selectById(id);
        dangkeOrderEntity.setDangkeOrderTypes(104);//设置订单状态为参加
        dangkeOrderService.updateById( dangkeOrderEntity);
        return R.ok();
    }

}

