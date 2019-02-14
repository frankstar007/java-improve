package com.frankstar.july.eleventh.dao;

import com.frankstar.july.eleventh.entity.MailEntity;

import java.util.List;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/20
 * Project : java-improve
 */
public interface MailDao {

    /**
     * 插入一条邮箱信息
     */
    public long insertMail(MailEntity mailEntity);
    /**
     * 删除一条邮箱信息
     */
    public int deleteMail(long id);
    /**
     * 更新一条邮箱信息
     */
    public int updateMail(MailEntity mailEntity);
    /**
     *查询邮箱列表
     */
    public List<MailEntity> selectMailList();

    /**
     * 根据主键id查询一条邮箱信息
     */
    public MailEntity selectMailById(long id);

}
