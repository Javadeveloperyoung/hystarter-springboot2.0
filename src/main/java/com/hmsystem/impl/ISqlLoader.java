package com.hmsystem.impl;
   /**
    * SqlLoader接口
    * @ClassName: ISqlLoader
    * @author sunt
    * @date 2017年11月15日
    * @version V1.0
   */
public interface ISqlLoader {

    /**
     * 自动生成控制文件
     * @Title: ctlFileWriter
     * @author sunt
     * @date 2017年11月15日
     * @param fileRoute 数据文件地址路径(文件所在磁盘目录)
     * @param fileName 数据文件名
     * @param tableName 表名
     * @param fieldName 要写入表的字段
     * @param ctlfileName 控制文件名
     * @return void
     */
    void ctlFileWriter(String fileRoute,String fileName,String tableName,String fieldName,String ctlfileName);

       /**
        * 执行系统dos命令
        * @Title: Executive
        * @author sunt
        * @date 2017年11月15日
        * @param user 数据库的用户名
        * @param pwd 数据库的密码
        * @param database 连接数据库的地址
        * @param fileRoute 文件路径
        * @param ctlfileName 控制文件名
        * @param logfileName 日志文件名
        * @return void
        */
       void Executive(String user,String pwd,String database,String fileRoute,String ctlfileName,String logfileName);

}
