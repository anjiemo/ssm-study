package cn.cqautotest.mapper;

import cn.cqautotest.entity.User;

import java.util.List;

public interface UserMapper {

    /**
     * 根据 id 查找用户
     * @param id 用户ID
     * @return
     */
    User selectUserById(int id);

    /**
     * 根据 id 删除用户
     * @param id 用户ID
     * @return
     */
    int deleteUserById(int id);

    /**
     * 更新用户
     *
     * @param user 用户信息
     * @return
     */
    int updateUser(User user);

    /**
     * 保存用户
     *
     * @param user 用户信息
     * @return
     */
    int saveUser(User user);

    /**
     * 返回所有用户
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     * 查询名字相关的用户
     *
     * @param userName
     * @return
     */
    List<User> findUsersByName(String userName);

    /**
     * 多条件查询
     *
     * @param user
     * @return
     */
    List<User> queryUsers(User user);
}
