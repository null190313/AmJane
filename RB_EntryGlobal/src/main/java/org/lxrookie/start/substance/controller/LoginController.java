package org.lxrookie.start.substance.controller;


import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.lxrookie.cloud.annotations.ClientAnnotation;
import org.lxrookie.start.substance.base.controller.BaseController;
import org.lxrookie.start.substance.constant.SysConfigConstant;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.services.obj.UserBaseMessageServices;
import org.lxrookie.start.substance.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
  *------------------------------.
  *@ClassName : LoginController
  *@author : 沐惜
  *@createTime : 2018/11/26 11:15
  *@描述 : TODO
  *@Version : 1.0
  *------------------------------
  */
@Controller
@RequestMapping(value = "/entryGlobal")
public class LoginController  extends BaseController {
    private Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserBaseMessageServices userBaseMessageServices;

    @ClientAnnotation(client = "CLIENT.PLA",isLogin = "NOTALLOW.LO")
    @RequestMapping(value = "/login.html")
    public ModelAndView loginUser(){
        ModelAndView modelAndView = new ModelAndView("pc/login/NG_login");
        basicDataLoading(modelAndView);
        return modelAndView;
    }




    @PostMapping(value = "/achieveUnifiedAuthenticationURL.html")
    public String achieveUnifiedAuthenticationURL(String jsonAuthentication){
        JSONObject jsonObject = JSONObject.fromObject(jsonAuthentication);
        String stampState = jsonObject.optString("stampState");
        String redirentId = jsonObject.optString("redirentId");
        if(SysConfigConstant.REDIRECT_CLIENT_ID.equals(redirentId)){
            String state = "success";
            String url = SysConfigConstant.EntryGlobalLocation+"/login.html?stampState="+stampState+"&redirentId"+redirentId;
            Map<String,String> returnMap = new HashMap<String,String>();
            returnMap.put("state",state);
            returnMap.put("url",url);
            return JSONObject.fromObject(returnMap).toString();
        }
        return null;
    }


    @RequestMapping(value = "userLogin.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, String> checkLoginInfoIsSuccess(UserBaseMessageEntity userBaseMessageEntity){
        /**
         * 验证账号密码正确性
         * */
        Map<String,String> map = userBaseMessageServices.checkLoginInfo(userBaseMessageEntity,request,response);
        return map;
    }





}
