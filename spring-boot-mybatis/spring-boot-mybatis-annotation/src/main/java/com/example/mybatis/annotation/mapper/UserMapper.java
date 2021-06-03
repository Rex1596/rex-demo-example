package com.example.mybatis.annotation.mapper;

import com.example.mybatis.annotation.enums.UserSexEnum;
import com.example.mybatis.annotation.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author lzw
 * Create 2021/6/3
 * Description
 */
@Mapper
public interface UserMapper {

    /**
     * Select 是查询类的注解，所有的查询均使用这个
     * Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，
     * 如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
     * Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
     * Update 负责修改，也可以直接传入对象
     * Delete 负责删除
     */
    @Select("select * from users where userName = #{userName}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User getUserByName(String userName);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Select("select * from users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Insert("insert into users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    int insert(User user);

    @Update("update users set userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    int update(User user);

    @Delete("delete from Users where id=#{id}")
    int delete(User user);
}
