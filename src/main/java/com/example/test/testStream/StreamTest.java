package com.example.test.testStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 18124550
 * @date 2019/10/30
 */
public class StreamTest {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipeIn = new PipedInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(pipeIn));
        PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);
        ZipOutputStream zipOutputStream = new ZipOutputStream(pipeOut);
        ZipEntry zipEntry = new ZipEntry("test.txt");
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write("test".getBytes());
        zipOutputStream.flush();
        zipOutputStream.closeEntry();
        zipOutputStream.close();

        export(pipeIn);


        /*PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(pipeOut)));

        writer.println("李培贤 Coming through the pipe...");
        writer.flush();*/

//        System.out.println(reader.readLine()); // Coming through the pipe...

//        reader.close();
//        writer.close();
    }

    private static void export(PipedInputStream is) throws IOException {
        byte[] buffer = new byte[1024*1024];
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\ttt.zip"));
        int len = 0;
        while (-1 != (len = is.read(buffer))) {
            fileOutputStream.write(buffer, 0, len);
        }

        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
