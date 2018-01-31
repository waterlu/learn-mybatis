package cn.lu.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口类
 *
 * @author lutiehua
 * @date 2018/01/31
 *
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.lu.learn.mapper"})
public class MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}