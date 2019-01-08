package org.lxrookie.start.substance.controller;

import org.lxrookie.start.substance.base.controller.BaseController;
import org.lxrookie.start.substance.entity.SysMenuSystemEntity;
import org.lxrookie.start.substance.entity.UserBaseDataEntity;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.services.obj.SysMenuSystemServices;
import org.lxrookie.start.substance.services.obj.UserBaseDataServices;
import org.lxrookie.start.substance.services.obj.UserBaseMessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *------------------------------.
 * @name : ThePersonalDataController
 * @author : 沐惜
 * @createTime : 2019/1/7 10:58
 * @description : 个人中心
 * @Version : 1.0
 *------------------------------
 */
@Controller
@RequestMapping(value = "/center")
public class ThePersonalDataController  extends BaseController {

    @Autowired
    private SysMenuSystemServices sysMenuSystemServices;

    @Autowired
    private UserBaseMessageServices userBaseMessageServices;

    @Autowired
    private UserBaseDataServices userBaseDataServices;

    @RequestMapping(value = "/persional.html")
    public ModelAndView getPersionalData(){
        ModelAndView modelAndView = new ModelAndView("pc/centern/NG_userCentern");
        /**
         * 获取个人中心菜单列表
         * */
        List<SysMenuSystemEntity> sysMenuSystemEntityList = sysMenuSystemServices.selectAllSysMenuSystemSort("CENTERN_MENU");
        /**
         * 获取个人基础信息
         * */
        UserBaseMessageEntity userBaseMessageEntity = userBaseMessageServices.selectUserBaseMessageById(getCurrentUserId());
        UserBaseDataEntity userBaseDataEntity = userBaseDataServices.selectUserBaseDataEntityByUserId(userBaseMessageEntity.getUserId());
        modelAndView.addObject("personalData",userBaseDataEntity);
        modelAndView.addObject("personal",userBaseMessageEntity);
        modelAndView.addObject("centerMenus",sysMenuSystemEntityList);
        basicDataLoading(modelAndView);
        return modelAndView;
    }
}
