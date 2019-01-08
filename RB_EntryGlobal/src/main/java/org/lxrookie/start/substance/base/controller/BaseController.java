package org.lxrookie.start.substance.base.controller;

import org.apache.shiro.web.session.HttpServletSession;
import org.lxrookie.start.substance.constant.SysConfigConstant;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @name : BaseController
 * @createTime : 2018/12/8 12:36
 * @description : 页面基础数据存放
 * @Version : 1.0
 * ------------------------------
 */
public class BaseController {


    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    @ModelAttribute
    public void setBaseDate(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        this.request = request;
        this.response = response;
        this.session = session;
    }

    public void basicDataLoading(ModelAndView modelAndView) {
        modelAndView.addObject("EntryGlobalLocation", SysConfigConstant.EntryGlobalLocation);
        modelAndView.addObject("CenterLocation", SysConfigConstant.CenterLocation);
        modelAndView.addObject("CloudLocation", SysConfigConstant.CloudLocation);
        modelAndView.addObject("DiaryLocation", SysConfigConstant.DiaryLocation);
        modelAndView.addObject("EntryGlobalLocation", SysConfigConstant.EntryGlobalLocation);
        modelAndView.addObject("LogsLocation", SysConfigConstant.LogsLocation);
        modelAndView.addObject("NovelLocation", SysConfigConstant.NovelLocation);
        modelAndView.addObject("SharingLocation", SysConfigConstant.SharingLocation);
        modelAndView.addObject("basicDataStacksHtml",basicDataStacksHtml());
    }




    public String basicDataStacksHtml(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<input type=\"hidden\"  id='BlogLocation' value="+SysConfigConstant.BlogLocation+">");
        stringBuffer.append("<input type=\"hidden\"  id='CenterLocation' value="+SysConfigConstant.CenterLocation+">");
        stringBuffer.append("<input type=\"hidden\"  id='CloudLocation' value="+SysConfigConstant.CloudLocation+">");
        stringBuffer.append("<input type=\"hidden\"  id='DiaryLocation' value="+SysConfigConstant.DiaryLocation+">");
        stringBuffer.append("<input type=\"hidden\"  id='EntryGlobalLocation' value="+SysConfigConstant.EntryGlobalLocation+">");
        stringBuffer.append("<input type=\"hidden\"  id='LogsLocation' value="+SysConfigConstant.LogsLocation+">");
        stringBuffer.append("<input type=\"hidden\"  id='NovelLocation' value="+SysConfigConstant.NovelLocation+">");
        stringBuffer.append("<input type=\"hidden\"  id='SharingLocation' value="+SysConfigConstant.SharingLocation+">");
        return stringBuffer.toString();
    }

}
