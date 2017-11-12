package com.xixi.Jiansu.sqlsession;

import com.xixi.Jiansu.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * MyBatis 自建帮助类，获取SqlSession
 * 以后可以和Spring集成，配置就可以
 * Created by xijiaxiang on 2017/11/11.
 */
public class MyBatisHelper {
    private static org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader=Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static org.apache.ibatis.session.SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
    public static void main(String[] args) {
        org.apache.ibatis.session.SqlSession session = sqlSessionFactory.openSession();
        try {
            Person user = (Person) session.selectOne("com.xixi.Jiansu.mapper.Person.selectByName", "xijiaxiang");
            System.out.println(user.toString());
        } finally {
            session.close();
        }
    }


}
