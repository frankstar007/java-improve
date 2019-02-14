package com.frankstar.july.eleventh.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/20
 * Project : java-improve
 */
@ToString
public class MailEntity {
    /**
     * 主键id
     */
    private long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /*
    * 更新时间
    * */
    private Date modifyTime;
    /**
     * 网站ID
     */
    private int webId;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 用途
     */
    private String useFor;

    public MailEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getWebId() {
        return webId;
    }

    public void setWebId(int webId) {
        this.webId = webId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUseFor() {
        return useFor;
    }

    public void setUseFor(String useFor) {
        this.useFor = useFor;
    }

    public MailEntity(int webId, String mail, String useFor) {
        this.webId = webId;
        this.mail = mail;
        this.useFor = useFor;
    }

}
