
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
 * 党务工作者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongzuo")
public class GongzuoController {
    private static final Logger logger = LoggerFactory.getLogger(GongzuoController.class);

    private static final String TABLE_NAME = "gongzuo";

    @Autowired
    private GongzuoService gongzuoService;


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
        PageUtils page = gongzuoService.queryPage(params);

        //字典表数据转换
        List<GongzuoView> list =(List<GongzuoView>)page.getList();
        for(GongzuoView c:list){
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
        GongzuoEntity gongzuo = gongzuoService.selectById(id);
        if(gongzuo !=null){
            //entity转view
            GongzuoView view = new GongzuoView();
            BeanUtils.copyProperties( gongzuo , view );//把实体数据重构到view中
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
    public R save(@RequestBody GongzuoEntity gongzuo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongzuo:{}",this.getClass().getName(),gongzuo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GongzuoEntity> queryWrapper = new EntityWrapper<GongzuoEntity>()
            .eq("username", gongzuo.getUsername())
            .or()
            .eq("gongzuo_phone", gongzuo.getGongzuoPhone())
            .or()
            .eq("gongzuo_id_number", gongzuo.getGongzuoIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuoEntity gongzuoEntity = gongzuoService.selectOne(queryWrapper);
        if(gongzuoEntity==null){
            gongzuo.setCreateTime(new Date());
            gongzuo.setPassword("123456");
            gongzuoService.insert(gongzuo);
            return R.ok();
        }else {
            return R.error(511,"账户或者党务工作者手机号或者党务工作者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongzuoEntity gongzuo, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gongzuo:{}",this.getClass().getName(),gongzuo.toString());
        GongzuoEntity oldGongzuoEntity = gongzuoService.selectById(gongzuo.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(gongzuo.getGongzuoPhoto()) || "null".equals(gongzuo.getGongzuoPhoto())){
                gongzuo.setGongzuoPhoto(null);
        }

            gongzuoService.updateById(gongzuo);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GongzuoEntity> oldGongzuoList =gongzuoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        gongzuoService.deleteBatchIds(Arrays.asList(ids));

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
            List<GongzuoEntity> gongzuoList = new ArrayList<>();//上传的东西
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
                            GongzuoEntity gongzuoEntity = new GongzuoEntity();
//                            gongzuoEntity.setUsername(data.get(0));                    //账户 要改的
//                            gongzuoEntity.setPassword("123456");//密码
//                            gongzuoEntity.setGongzuoName(data.get(0));                    //党务工作者姓名 要改的
//                            gongzuoEntity.setGongzuoPhone(data.get(0));                    //党务工作者手机号 要改的
//                            gongzuoEntity.setGongzuoIdNumber(data.get(0));                    //党务工作者身份证号 要改的
//                            gongzuoEntity.setGongzuoPhoto("");//详情和图片
//                            gongzuoEntity.setShenqingYuyueTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            gongzuoEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            gongzuoEntity.setGongzuoEmail(data.get(0));                    //电子邮箱 要改的
//                            gongzuoEntity.setCreateTime(date);//时间
                            gongzuoList.add(gongzuoEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //党务工作者手机号
                                if(seachFields.containsKey("gongzuoPhone")){
                                    List<String> gongzuoPhone = seachFields.get("gongzuoPhone");
                                    gongzuoPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> gongzuoPhone = new ArrayList<>();
                                    gongzuoPhone.add(data.get(0));//要改的
                                    seachFields.put("gongzuoPhone",gongzuoPhone);
                                }
                                //党务工作者身份证号
                                if(seachFields.containsKey("gongzuoIdNumber")){
                                    List<String> gongzuoIdNumber = seachFields.get("gongzuoIdNumber");
                                    gongzuoIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gongzuoIdNumber = new ArrayList<>();
                                    gongzuoIdNumber.add(data.get(0));//要改的
                                    seachFields.put("gongzuoIdNumber",gongzuoIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<GongzuoEntity> gongzuoEntities_username = gongzuoService.selectList(new EntityWrapper<GongzuoEntity>().in("username", seachFields.get("username")));
                        if(gongzuoEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongzuoEntity s:gongzuoEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //党务工作者手机号
                        List<GongzuoEntity> gongzuoEntities_gongzuoPhone = gongzuoService.selectList(new EntityWrapper<GongzuoEntity>().in("gongzuo_phone", seachFields.get("gongzuoPhone")));
                        if(gongzuoEntities_gongzuoPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongzuoEntity s:gongzuoEntities_gongzuoPhone){
                                repeatFields.add(s.getGongzuoPhone());
                            }
                            return R.error(511,"数据库的该表中的 [党务工作者手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //党务工作者身份证号
                        List<GongzuoEntity> gongzuoEntities_gongzuoIdNumber = gongzuoService.selectList(new EntityWrapper<GongzuoEntity>().in("gongzuo_id_number", seachFields.get("gongzuoIdNumber")));
                        if(gongzuoEntities_gongzuoIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongzuoEntity s:gongzuoEntities_gongzuoIdNumber){
                                repeatFields.add(s.getGongzuoIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [党务工作者身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongzuoService.insertBatch(gongzuoList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        GongzuoEntity gongzuo = gongzuoService.selectOne(new EntityWrapper<GongzuoEntity>().eq("username", username));
        if(gongzuo==null || !gongzuo.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(gongzuo.getId(),username, "gongzuo", "党务工作者");
        R r = R.ok();
        r.put("token", token);
        r.put("role","党务工作者");
        r.put("username",gongzuo.getGongzuoName());
        r.put("tableName","gongzuo");
        r.put("userId",gongzuo.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody GongzuoEntity gongzuo, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<GongzuoEntity> queryWrapper = new EntityWrapper<GongzuoEntity>()
            .eq("username", gongzuo.getUsername())
            .or()
            .eq("gongzuo_phone", gongzuo.getGongzuoPhone())
            .or()
            .eq("gongzuo_id_number", gongzuo.getGongzuoIdNumber())
            ;
        GongzuoEntity gongzuoEntity = gongzuoService.selectOne(queryWrapper);
        if(gongzuoEntity != null)
            return R.error("账户或者党务工作者手机号或者党务工作者身份证号已经被使用");
        gongzuo.setCreateTime(new Date());
        gongzuoService.insert(gongzuo);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        GongzuoEntity gongzuo = gongzuoService.selectById(id);
        gongzuo.setPassword("123456");
        gongzuoService.updateById(gongzuo);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        GongzuoEntity gongzuo = gongzuoService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(gongzuo.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(gongzuo.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        gongzuo.setPassword(newPassword);
		gongzuoService.updateById(gongzuo);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        GongzuoEntity gongzuo = gongzuoService.selectOne(new EntityWrapper<GongzuoEntity>().eq("username", username));
        if(gongzuo!=null){
            gongzuo.setPassword("123456");
            gongzuoService.updateById(gongzuo);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrGongzuo(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        GongzuoEntity gongzuo = gongzuoService.selectById(id);
        if(gongzuo !=null){
            //entity转view
            GongzuoView view = new GongzuoView();
            BeanUtils.copyProperties( gongzuo , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = gongzuoService.queryPage(params);

        //字典表数据转换
        List<GongzuoView> list =(List<GongzuoView>)page.getList();
        for(GongzuoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongzuoEntity gongzuo = gongzuoService.selectById(id);
            if(gongzuo !=null){


                //entity转view
                GongzuoView view = new GongzuoView();
                BeanUtils.copyProperties( gongzuo , view );//把实体数据重构到view中

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
    public R add(@RequestBody GongzuoEntity gongzuo, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gongzuo:{}",this.getClass().getName(),gongzuo.toString());
        Wrapper<GongzuoEntity> queryWrapper = new EntityWrapper<GongzuoEntity>()
            .eq("username", gongzuo.getUsername())
            .or()
            .eq("gongzuo_phone", gongzuo.getGongzuoPhone())
            .or()
            .eq("gongzuo_id_number", gongzuo.getGongzuoIdNumber())
//            .notIn("gongzuo_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongzuoEntity gongzuoEntity = gongzuoService.selectOne(queryWrapper);
        if(gongzuoEntity==null){
            gongzuo.setCreateTime(new Date());
            gongzuo.setPassword("123456");
        gongzuoService.insert(gongzuo);

            return R.ok();
        }else {
            return R.error(511,"账户或者党务工作者手机号或者党务工作者身份证号已经被使用");
        }
    }

}

