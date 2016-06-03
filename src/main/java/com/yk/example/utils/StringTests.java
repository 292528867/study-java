package com.yk.example.utils;

/**
 * Created by yk on 16/6/1.
 */
public class StringTests {

  /*  public static void main(String[] args) {
        StringObject sb = new StringObject();
        StringObject sb1 = sb;

        sb.setName("123");
        sb.setaLong(123);
        long l = 1;
        char[] chars = {'a', 'b'};
        String s = "test";
        change(sb,chars,l,s);
        System.out.println(sb);
        System.out.println(sb1);
        System.out.println(sb.getName());
        System.out.println(sb.getaLong());
        System.out.println(chars[0]);
        System.out.println(l);
        System.out.println(s);

    *//*    String s1 = "ssss";
        String s = new String("ssss");
        System.out.println(s1 == s);
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());*//*
    }*/

    public static void change(StringObject sb,char[] chars,long l,String s) {
        sb = new StringObject();
        System.out.println(sb);
        sb.setName("456");
        sb.setaLong(456);
        chars[0] = 'g';
        s = "test1";
        l = 12;
    }

}
class StringObject {
    String name;
    long aLong;
    char[] chars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }
}
