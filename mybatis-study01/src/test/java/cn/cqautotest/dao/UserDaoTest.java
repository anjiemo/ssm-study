package cn.cqautotest.dao;

import cn.cqautotest.entity.User;
import cn.cqautotest.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDaoTest {

    private final Logger mLogger = LoggerFactory.getLogger(getClass());
    private SqlSession mSession = null;
    private UserMapper mMapper = null;

    @Before
    public void before() {
        // 构建一个session工厂
        InputStream resource = getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
        // 获取session
        mSession = sqlSessionFactory.openSession();
        // 获取代理对象
        mMapper = mSession.getMapper(UserMapper.class);
    }

    @After
    public void after() {
        mSession.commit();
    }

    @Test
    public void selectUserByIdTest() {

        mLogger.debug("=======> 代理对象获取完毕  <=======");
        // 执行方法
        User user = mMapper.selectUserById(2);
        System.out.println(user);
    }

    @Test
    public void findAllUsers() {
        // 执行方法
        List<User> allUsers = mMapper.findAllUsers();
        System.out.println(allUsers);
    }

    @Test
    public void queryUserByIds() {
        // 执行方法
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ids.add(i);
        }
        List<User> allUsers = mMapper.queryUserByIds(ids);
        System.out.println(allUsers);
    }

    @Test
    public void queryUsers() {
        // 执行方法
        User user = new User(null, "李思思", null);
        List<User> allUsers = mMapper.queryUsers(user);
        System.out.println(allUsers);
    }

    @Test
    public void findUsersByName() {
        // 执行方法
        List<User> users = mMapper.findUsersByName("李");
        System.out.println(users);
    }

    @Test
    public void saveUser() {
        // 执行方法
        int rows = mMapper.saveUser(new User(20, "李四", "123456"));
        System.out.println(rows);
    }

    @Test
    public void updateUser() {
        // 执行方法
        int rows = mMapper.updateUser(new User(1, "李四", "123456"));
        System.out.println(rows);
    }

    @Test
    public void deleteUserById() {
        // 执行方法
        int rows = mMapper.deleteUserById(2);
        System.out.println(rows);
    }
}
