package org.lxrookie.start.substance.base.controller;

import org.lxrookie.start.substance.constant.SysConfigConstant;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.services.obj.UserBaseMessageServices;
import org.lxrookie.start.substance.util.AESUtils;
import org.lxrookie.start.substance.util.CookieUtils;
import org.lxrookie.start.substance.util.JedisUtils;
import org.lxrookie.start.substance.util.TotalUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserBaseMessageServices userBaseMessageServices;

    @ModelAttribute
    public void setBaseDate(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
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
        modelAndView.addObject("basicDataStacksHtml", basicDataStacksHtml());
    }


    public String basicDataStacksHtml() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<input type=\"hidden\"  id='BlogLocation' value=" + SysConfigConstant.BlogLocation + ">");
        stringBuffer.append("<input type=\"hidden\"  id='CenterLocation' value=" + SysConfigConstant.CenterLocation + ">");
        stringBuffer.append("<input type=\"hidden\"  id='CloudLocation' value=" + SysConfigConstant.CloudLocation + ">");
        stringBuffer.append("<input type=\"hidden\"  id='DiaryLocation' value=" + SysConfigConstant.DiaryLocation + ">");
        stringBuffer.append("<input type=\"hidden\"  id='EntryGlobalLocation' value=" + SysConfigConstant.EntryGlobalLocation + ">");
        stringBuffer.append("<input type=\"hidden\"  id='LogsLocation' value=" + SysConfigConstant.LogsLocation + ">");
        stringBuffer.append("<input type=\"hidden\"  id='NovelLocation' value=" + SysConfigConstant.NovelLocation + ">");
        stringBuffer.append("<input type=\"hidden\"  id='SharingLocation' value=" + SysConfigConstant.SharingLocation + ">");
        return stringBuffer.toString();
    }


    public String getCurrentUserId() {
        /**
         * 解密cookieId 获取UserId
         * */
        String userId = AESUtils.dcodes(CookieUtils.getCookieValue(request, SysConfigConstant.COOKIEID), SysConfigConstant.COOKIE_UNIFIED_ENCRYPTION);
        /**
         * 获取未解密的tookieId
         * */
        String tokenId = CookieUtils.getCookieValue(request, SysConfigConstant.TOKENID);
        /**
         * 获取redis存储的tookieId
         * */
        String redisTokenId = JedisUtils.get(SysConfigConstant.TOKENID);
        UserBaseMessageEntity userBaseMessageEntity = userBaseMessageServices.selectUserBaseMessageById(userId);
        String validationToken = AESUtils.ecodes(TotalUtils.createToken(SysConfigConstant.EntryGlobalLocation, userBaseMessageEntity.getUserId()), userBaseMessageEntity.getUserPasword());
        try {
            if (redisTokenId.equals(tokenId)) {
                return userId;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
