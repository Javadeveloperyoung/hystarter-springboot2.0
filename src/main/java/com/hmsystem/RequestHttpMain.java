package com.hmsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 程序入口
 */
@SpringBootApplication
public class RequestHttpMain {

    public static void main(String[] args) {
        // Springアプリケーション起動処理
        SpringApplication.run(RequestHttpMain.class,args);
        // log4j2のバグ修正「JNDIインジェクション」
        System.setProperty("log4j2.formatMsgNoLookups","true");
    }
}
