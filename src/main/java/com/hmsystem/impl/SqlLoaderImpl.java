package com.hmsystem.impl;

import com.hmsystem.utils.LogUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;


/**
 * SqlLoader接口实现
 * @ClassName: SqlLoaderImpl
 * @author yliu
 * @date 2021年05月25日
 * @version V1.0
 */
@Service
public class SqlLoaderImpl implements ISqlLoader{

    // Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    // private final static  Logger logger = LogManager.getLogger(SqlLoaderImpl.class);
    Logger logger = LogUtils.getBussinessLogger();

    @Override
    public void ctlFileWriter(String fileRoute, String fileName, String tableName, String fieldName,String ctlfileName) {
        FileWriter fw = null;
        String strctl = "OPTIONS (skip=0)" + // 0是从第一行开始  1是 从第二行
                " LOAD DATA CHARACTERSET AL32UTF8 INFILE '"+fileRoute+""+fileName+"'" + //设置字符集编码SELECT * FROM NLS_DATABASE_PARAMETERS WHERE PARAMETER = 'NLS_CHARACTERSET';
                " APPEND INTO TABLE "+tableName+"" + ////覆盖写入
                " FIELDS TERMINATED BY '\\|'" + //数据中每行记录用","分隔 ,TERMINATED用于控制字段的分隔符，可以为多个字符。|需要转译
                " OPTIONALLY  ENCLOSED BY \"'\"" + //源文件有引号 ''，这里去掉    ''''"
                " TRAILING NULLCOLS "+fieldName+"";  //表的字段没有对应的值时允许为空  源数据没有对应，写入null
        try {
            fw = new FileWriter(fileRoute + "" + ctlfileName);
            fw.write(strctl);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                logger.error("生成控制器文件异常...");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void Executive(String user, String pwd, String database, String fileRoute, String ctlfileName,String logfileName) {
        InputStream ins = null;
        //要执行的DOS命令  --数据库  用户名  密码  user/password@database
        String dos="sqlldr "+user+"/"+pwd+"@"+database+" control="+fileRoute+""+ctlfileName+" log="+fileRoute+""+logfileName;
        logger.info("执行的dos命令:" + dos);
        String[] cmd = new String[] { "cmd.exe", "/C", dos }; // 命令cmd /c dir：是执行完dir命令后关闭命令窗口cmd /k dir：是执行完dir命令后不关闭命令窗口。
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            ins = process.getInputStream(); // 获取执行cmd命令后的信息

            BufferedReader reader = new BufferedReader(new InputStreamReader(ins, Charset.forName("GBK")));//解决dos下中文输出乱码
            String line = null;
            long startTime = new Date().getTime();
            while ((line = reader.readLine()) != null) {
                logger.info("调用dos执行的结果==========>" + line); // 输出
            }
            int exitValue = process.waitFor();
            if (exitValue == 0) {
                logger.info("返回值:" + exitValue + "\n数据导入成功");
                logger.info("总共耗时:" + (new Date().getTime() - startTime) / 1000 + "秒");
            } else {
                logger.info("返回值:" + exitValue + "\n数据导入失败");
            }

            process.getOutputStream().close(); // 关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
