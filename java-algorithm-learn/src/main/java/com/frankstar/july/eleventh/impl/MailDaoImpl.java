package com.frankstar.july.eleventh.impl;

import com.frankstar.july.eleventh.dao.MailDao;
import com.frankstar.july.eleventh.entity.MailEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Author :  frankstar
 * Mail  :   frankstar@smail.nju.edu.cn
 * Time  :   2017/7/20
 * Project : java-improve
 */
public class MailDaoImpl implements MailDao {

    private static final String NAME_SPACE = "MailMapper.";

    private static SqlSessionFactory sqlSessionFactory;

    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis/mail-spring.config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long insertMail(MailEntity mailEntity) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            int rows = sqlSession.insert(NAME_SPACE + "insertMail", mailEntity);
            sqlSession.commit();
            if (rows > 0) {
                return mailEntity.getId();
            }
            return 0;
        } catch (Exception e) {
            sqlSession.rollback();
            return 0;
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public int deleteMail(long id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            int rows = sqlSession.delete(NAME_SPACE + "deleteMail", id);
            sqlSession.commit();
            return rows;
        } catch (Exception e) {
            sqlSession.rollback();
            return 0;
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public int updateMail(MailEntity mailEntity) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            int rows = sqlSession.update(NAME_SPACE + "updateMail", mailEntity);
            sqlSession.commit();
            return rows;
        } catch (Exception e) {
            sqlSession.rollback();
            return 0;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<MailEntity> selectMailList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList(NAME_SPACE + "selectMailList");
        }  finally {
            sqlSession.close();
        }

    }

    @Override
    public MailEntity selectMailById(long id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne(NAME_SPACE + "selectMailById", id);
        } finally {
            sqlSession.close();
        }

    }
}
