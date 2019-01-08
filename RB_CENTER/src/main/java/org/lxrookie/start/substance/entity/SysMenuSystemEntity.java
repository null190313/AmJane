package org.lxrookie.start.substance.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @name : SysMenuSystemEntity
 * @createTime : 2019/1/7 10:39
 * @description : 菜单实体类
 * @Version : 1.0
 * ------------------------------
 */
@Table(name = "SYS_MENU_SYSTEM")
public class SysMenuSystemEntity {


    @Column(name = "SYS_MENU_ID")
    private String sysMenuId;


    /**
     * 菜单对应key
     */
    @Column(name = "SYS_MENU_KEY")
    private String sysMenuKey;

    /**
     * 菜单对应value
     */
    @Column(name = "SYS_MENU_VALUE")
    private String sysMenuValue;

    /**
     * 菜单对应模块
     */
    @Column(name = "SYS_MENU_MARKING")
    private String sysMenuMarking;

    /**
     * 菜单添加时间
     */
    @Column(name = "SYS_MENU_ADDTIME")
    private Date sysMenuAddtime;

    /**
     * 菜单启用状态
     */
    @Column(name = "SYS_MENU_STATE")
    private Integer sysMenuState;

    /**
     * 菜单图片url
     */
    @Column(name = "SYS_MENU_PIC_URL")
    private String sysMenuPicUrl;

    /**
     * 菜单链接
     */
    @Column(name = "SYS_MENU_URL")
    private String sysMenuUrl;

    /**
     * 菜单排序码
     */
    @Column(name = "SYS_MENU_SORTCODE")
    private Integer sysMenuSortCode;

    public void setSysMenuId(String sysMenuId) {
        this.sysMenuId = sysMenuId;
    }

    public void setSysMenuKey(String sysMenuKey) {
        this.sysMenuKey = sysMenuKey;
    }

    public void setSysMenuValue(String sysMenuValue) {
        this.sysMenuValue = sysMenuValue;
    }

    public void setSysMenuMarking(String sysMenuMarking) {
        this.sysMenuMarking = sysMenuMarking;
    }

    public void setSysMenuAddtime(Date sysMenuAddtime) {
        this.sysMenuAddtime = sysMenuAddtime;
    }

    public void setSysMenuState(Integer sysMenuState) {
        this.sysMenuState = sysMenuState;
    }

    public void setSysMenuPicUrl(String sysMenuPicUrl) {
        this.sysMenuPicUrl = sysMenuPicUrl;
    }

    public void setSysMenuUrl(String sysMenuUrl) {
        this.sysMenuUrl = sysMenuUrl;
    }

    public void setSysMenuSortCode(Integer sysMenuSortCode) {
        this.sysMenuSortCode = sysMenuSortCode;
    }

    public String getSysMenuId() {
        return sysMenuId;
    }

    public String getSysMenuKey() {
        return sysMenuKey;
    }

    public String getSysMenuValue() {
        return sysMenuValue;
    }

    public String getSysMenuMarking() {
        return sysMenuMarking;
    }

    public Date getSysMenuAddtime() {
        return sysMenuAddtime;
    }

    public Integer getSysMenuState() {
        return sysMenuState;
    }

    public String getSysMenuPicUrl() {
        return sysMenuPicUrl;
    }

    public String getSysMenuUrl() {
        return sysMenuUrl;
    }

    public Integer getSysMenuSortCode() {
        return sysMenuSortCode;
    }
}
