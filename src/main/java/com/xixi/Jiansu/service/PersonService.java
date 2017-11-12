package com.xixi.Jiansu.service;

import com.xixi.Jiansu.pojo.Person;
import com.xixi.Jiansu.sqlsession.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 个人服务类
 * 目前只有插入一个人的服务
 * Created by xijiaxiang on 2017/11/11.
 */
public class PersonService {
    public void insertPerson(Person person){
        SqlSessionFactory sqlSession= MyBatisHelper.getSqlSessionFactory();
        SqlSession session =sqlSession.openSession();
        try{
            session.insert("insertPerson",person);
            session.commit();
        }catch(Exception e){
            System.out.println("insert error!!! "+e.toString());
        }
        finally {
            session.rollback();
            session.close();
        }
    }

}
