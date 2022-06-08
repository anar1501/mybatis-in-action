package az.cybernet;

import az.cybernet.data.entity.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("az.cybernet.mapper")
@MappedTypes(User.class)
public class MybatisInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisInActionApplication.class, args);
    }

}
