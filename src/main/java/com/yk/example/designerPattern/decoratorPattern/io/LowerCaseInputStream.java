package com.yk.example.designerPattern.decoratorPattern.io;

import java.io.*;

/**
 * Created by yukui on 2016/7/15.
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + len; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        int c;
        try {
            InputStream is = new LowerCaseInputStream(
                    new BufferedInputStream(new FileInputStream("E:/test.txt")));
            while ((c = is.read()) > 0) {
                System.out.print((char) c);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
