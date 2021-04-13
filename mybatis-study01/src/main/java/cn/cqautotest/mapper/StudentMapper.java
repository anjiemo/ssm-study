package cn.cqautotest.mapper;

import cn.cqautotest.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    /**
     * 根据 id 查找用户
     * @param id 用户ID
     * @return
     */
    @Select("select id, username, password from student where id = #{id}")
    Student selectStudentById(int id);

    /**
     * 根据 id 删除用户
     * @param id 用户ID
     * @return
     */
    @Delete("delete from student where id  = #{id}")
    int deleteStudentById(int id);

    /**
     * 更新用户
     *
     * @param Student 用户信息
     * @return
     */
    @Update("update student set username = #{userName}, password = #{password} where id = #{id}")
    int updateStudent(Student Student);

    /**
     * 保存用户
     *
     * @param Student 用户信息
     * @return
     */
    @Insert("insert into student (id, username, password) values (#{id}, #{userName}, #{password})")
    int saveStudent(Student Student);

    /**
     * 返回所有用户
     *
     * @return
     */
    @Select("select * from student")
    List<Student> findAllStudents();

    /**
     * 查询名字相关的用户
     *
     * @param StudentName
     * @return
     */
    @Select("select * from student where username like '%${userName}%'")
    List<Student> findStudentsByName(String StudentName);
}
