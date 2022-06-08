package az.cybernet.mapper;

import az.cybernet.data.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("select * from users")
    List<User> findAll();

    @Insert("insert into users(name,salary) values(#{name},#{salary})")
    @SelectKey(statement = "Select LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Long.class)
    void insert(User user);

    @Update("update users set name=#{name},salary=#{salary} where id=#{id}")
    void update(User user);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "salary", column = "salary")
    })
    @Select("SELECT * from users WHERE id = #{id}")
    Optional<User> selectById(@Param("id") Long id);

    @Delete("DELETE from users where id=#{id}")
    void delete(User user);

}
