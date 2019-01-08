package org.lxrookie.start.substance.controller;

import org.lxrookie.start.substance.base.controller.BaseController;
import org.lxrookie.start.substance.entity.SysMenuSystemEntity;
import org.lxrookie.start.substance.services.obj.SysMenuSystemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *------------------------------.
 * @name : TestController
 * @author : 沐惜
 * @createTime : 2018/12/5 15:51
 * @description : 测试专用
 * @Version : 1.0
 *------------------------------
 */
@Controller
@RequestMapping(value = "/center")
public class TestController extends BaseController {

    @Autowired
    private SysMenuSystemServices sysMenuSystemServices;

    @RequestMapping(value = "testMapping.html")
    public ModelAndView test(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("pc/centern/NG_userCentern");
        basicDataLoading(modelAndView);
        return modelAndView;
    }
    @RequestMapping(value = "testRegist.html",method = RequestMethod.GET)
    public ModelAndView testRegist(HttpServletRequest request,String regSuccessAccount){
        ModelAndView modelAndView = new ModelAndView("pc/temporarily/NG_regisSucess");
        modelAndView.addObject("regSuccessAccount",regSuccessAccount);
        basicDataLoading(modelAndView);
        return modelAndView;
    }
    @RequestMapping(value = "testTree.html")
    public ModelAndView testTree(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("pc/common/tree/tree");
        List<SysMenuSystemEntity> sysMenuSystemEntityList = sysMenuSystemServices.selectAllSysMenuSystemSort("CENTERN_MENU");
        for (SysMenuSystemEntity s:
             sysMenuSystemEntityList) {
            System.out.println(s.getSysMenuValue());
        }
        modelAndView.addObject("centerMenus",sysMenuSystemEntityList);
        basicDataLoading(modelAndView);
        return modelAndView;
    }

}
