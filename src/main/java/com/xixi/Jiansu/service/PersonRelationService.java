package com.xixi.Jiansu.service;

import com.xixi.Jiansu.pojo.PersonRelation;
import com.xixi.Jiansu.sqlsession.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**人物关系的表
 * Created by xijiaxiang on 2017/11/12.
 */
public class PersonRelationService {
    public void insertPersonReation(PersonRelation personRelation){
        SqlSessionFactory sqlSession= MyBatisHelper.getSqlSessionFactory();
        SqlSession session =sqlSession.openSession();
        try{
            session.insert("insertPersonRelation",personRelation);
            session.commit();
        }catch(Exception e){
            System.out.println("insert error!! "+e.toString());
        }
        finally {
            session.rollback();
            session.close();
        }
    }
}
