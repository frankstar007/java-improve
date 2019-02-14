package com.frankstar.july.eleventh.controller;

import com.frankstar.july.eleventh.dao.MailDao;
import com.frankstar.july.eleventh.entity.MailEntity;
import com.frankstar.july.eleventh.impl.MailDaoImpl;
import org.junit.Test;

import java.util.List;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/20
 * Project : java-improve
 */
public class TestMailBatis {

    private static MailDao mailDao;

    static {
        mailDao = new MailDaoImpl();
    }

    @Test
    public void testInsert() {
        MailEntity mailEntity1 = new MailEntity(1, "123@sina.com", "个人使用");
        MailEntity mailEntity2 = new MailEntity(2, "123@qq.com", "企业使用");
        MailEntity mailEntity3 = new MailEntity(3, "123@souhu.com", "注册帐号使用");
        MailEntity mailEntity4 = new MailEntity(4, "123@huohu.com", "游戏使用");

        System.out.println(mailDao.insertMail(mailEntity1));
        System.out.println(mailDao.insertMail(mailEntity2));
        System.out.println(mailDao.insertMail(mailEntity3));
        System.out.println(mailDao.insertMail(mailEntity4));
    }

    @Test
    public void testDelete() {
        System.out.println(mailDao.deleteMail(1));
    }

    @Test
    public void testUpdate() {
        MailEntity mailEntity = new MailEntity(2, "123@qqq.com", "相亲使用");
        mailEntity.setId(2);
        System.out.println(mailDao.updateMail(mailEntity));
        System.out.println(mailDao.selectMailById(2));
    }

    @Test
    public void testSelectOne() {
        System.out.println(mailDao.selectMailById(2));
    }

    @Test
    public void testSelectList() {
        List<MailEntity> mailEntities = mailDao.selectMailList();

        if (mailEntities != null && mailEntities.size() != 0) {
            for (MailEntity mailEntity : mailEntities) {
                System.out.println(mailEntity);
            }
        }
    }

}
