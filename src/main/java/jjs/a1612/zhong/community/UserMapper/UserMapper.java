package jjs.a1612.zhong.community.UserMapper;

import jjs.a1612.zhong.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 数据库的访问接口，类似与DAO层
 */
@Mapper
public interface UserMapper {
    //  通过这种方式查询时，方法中传的值不是对象，则sql语句中的参数不能正确匹配，此时则需要通过 @Param("name")声明
    @Insert("insert into user (name, account_id, token, gmt_create, gmt_modified) " +
            "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") int id);
    @Select("select * from user where name=#{name}")
    ArrayList<User> findAll(@Param("name") String name);
}
