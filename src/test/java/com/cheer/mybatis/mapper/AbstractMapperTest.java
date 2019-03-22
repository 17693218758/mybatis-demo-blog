package com.cheer.mybatis.mapper;
//导包
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractMapperTest {
    protected SqlSession session;

    // @Before标识的方法在测试方法之前调用
    @Before
    public void init(){
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();  //这个方法最经常用,用来创建SqlSession的对象.
    }

    //@After标识的方法在测试方法之后调用
    @After
    public void destroy(){
        //提交事务 不然结果不会保存到数据库
        session.commit();
        session.close();
    }
}
