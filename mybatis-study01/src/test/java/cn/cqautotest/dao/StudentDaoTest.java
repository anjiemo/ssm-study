package cn.cqautotest.dao;

import cn.cqautotest.entity.Student;
import cn.cqautotest.entity.User;
import cn.cqautotest.mapper.StudentMapper;
import cn.cqautotest.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class StudentDaoTest {

    private SqlSession mSession = null;
    private StudentMapper mMapper = null;

    @Before
    public void before() {
        // 构建一个session工厂
        InputStream resource = getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
        // 获取session
        mSession = sqlSessionFactory.openSession();
        // 获取代理对象
        mMapper = mSession.getMapper(StudentMapper.class);
    }

    @After
    public void after() {
        mSession.commit();
    }

    @Test
    public void selectStudentById() {
        // 执行方法
        Student student = mMapper.selectStudentById(2);
        System.out.println(student);
    }

    @Test
    public void findAllStudents() {
        // 执行方法
        List<Student> allStudents = mMapper.findAllStudents();
        System.out.println(allStudents);
    }

    @Test
    public void findStudentsByName() {
        // 执行方法
        List<Student> students = mMapper.findStudentsByName("李");
        System.out.println(students);
    }

    @Test
    public void saveStudent() {
        // 执行方法
        int rows = mMapper.saveStudent(new Student(23, "李四", "1234567"));
        System.out.println(rows);
    }

    @Test
    public void updateStudent() {
        // 执行方法
        int rows = mMapper.updateStudent(new Student(1, "李思思", "123456"));
        System.out.println(rows);
    }

    @Test
    public void deleteStudentById() {
        // 执行方法
        int rows = mMapper.deleteStudentById(2);
        System.out.println(rows);
    }
}
