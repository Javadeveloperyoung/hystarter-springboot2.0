package com.hmsystem.service;

import java.io.*;

/**
 * 循环将数据按照指定的格式写入文本文件
 * @ClassName: OperaFile
 * @author yliu
 * @date 2021年05月25日
 * @version V1.0
 */
public class OperaFile {

    /**
     * 写数据到文件
     * @Title: writeFile
     * @author yliu
     * @date 2021年05月25日
     * @return void
     */
    public static void writeFile(String filePath) throws IOException {
        File fout = new File(filePath);
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (Long i = 0L; i < 10000000; i++) {
            bw.write(i + "|测试数据"+i+"|");
            bw.newLine();
        }
        bw.close();
    }
}
