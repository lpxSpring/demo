package com.example.everydayjava.jdk;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 18124550
 * @date 2019/6/15
 */
public class ZipEntryTest {
    public static void main(String[] args) {
        FileOutputStream fo = null;
        FileInputStream fi = null;
        try {
            fo = new FileOutputStream("C:\\Users\\18124550\\Desktop\\lpxtest.zip");
            // 获取文件的修改时间
            File file = new File("C:\\Users\\18124550\\Desktop\\dayNote.txt");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println(sdf.format(new Date(file.lastModified())));
            fi = new FileInputStream("C:\\Users\\18124550\\Desktop\\dayNote.txt");
            ZipEntry zipEntry = new ZipEntry("day01/dayNote.txt");// 添加指定目录
            zipEntry.setMethod(ZipEntry.DEFLATED); // 默认压缩方式
            zipEntry.setLastModifiedTime(FileTime.fromMillis(file.lastModified())); // 设置文件的修改原有修改时间
            ZipOutputStream zos = new ZipOutputStream(fo);
            zos.putNextEntry(zipEntry);
            byte[] buf = new byte[1024 * 1024];
            int len;
            while (-1 != (len = fi.read(buf))) {
                zos.write(buf, 0, len);
            }

            zos.flush();
            zos.closeEntry();
            System.out.println("压缩文件[" + "C:\\Users\\18124550\\Desktop\\lpxtest.zip" + "]成功!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fo);
            IOUtils.closeQuietly(fi);
        }

    }
}

