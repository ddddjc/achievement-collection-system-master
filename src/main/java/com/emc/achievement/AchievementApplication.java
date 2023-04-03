package com.emc.achievement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.emc.achievement.mapper")
public class AchievementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchievementApplication.class, args);
    }
}
