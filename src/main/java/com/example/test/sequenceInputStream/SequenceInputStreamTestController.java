package com.example.test.sequenceInputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 18124550
 * @date 2019/7/19
 */
@RestController
public class SequenceInputStreamTestController {
    @RequestMapping(value = "/SequenceInputStreamTest", method = RequestMethod.GET)
    public void getFileText(HttpServletResponse response) {
        Vector<InputStream> vi = new Vector<>();
        InputStream is = null, is2 = null;
        SequenceInputStream sequenceInputStream = null;
        OutputStream outputStream = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream("dayNote.txt");
            is2 = this.getClass().getClassLoader().getResourceAsStream("dayNote2.txt");
            vi.add(is);
            vi.add(is2);
            Enumeration<InputStream> enumeration = vi.elements();
            sequenceInputStream = new SequenceInputStream(enumeration);

            outputStream = response.getOutputStream();
            IOUtils.copy(sequenceInputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(is2);
            IOUtils.closeQuietly(sequenceInputStream);
            IOUtils.closeQuietly(outputStream);
        }

    }

}
