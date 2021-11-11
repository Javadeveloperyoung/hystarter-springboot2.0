package com.hmsystem.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本地日志参考类
 * @author Administrator
 *由于配置了4个文件存放不同日志，分别为平台日志（${project.name}_platform.log）、
 *  业务日志（${project.name}_bussiness.log）、错误日志（${project.name}_exception.log）、
 * DB 日志（${project.name}_db.log），文件夹外面为运行日志，不同文件日志级别不一样
 * 因此在开发时候需要注意引入不同日志
 */
public class LogUtils {


        /**
         * 获取业务日志logger
         *
         * @return
         */
        public static Logger getBussinessLogger() {
        return LoggerFactory.getLogger(LogEnum.BUSSINESS.getCategory());
        }

        /**
         * 获取平台日志logger
         *
         * @return
         */
        public static Logger getPlatformLogger() {
        return LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
        }

        /**
         * 获取数据库日志logger
         *
         * @return
         */
        public static Logger getDBLogger() {
        return LoggerFactory.getLogger(LogEnum.DB.getCategory());
        }


        /**
         * 获取异常日志logger
         *
         * @return
         */
        public static Logger getExceptionLogger() {
        return LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
        }

}