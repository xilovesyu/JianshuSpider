package com.xixi.Jiansu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 超链接提取内容和连接
 * Created by xijiaxiang on 2017/11/12.
 */
public class HrefHelper {

    public static String Content(String aHref){
        String content="";
        String regexURL=">.*?</a>";
        Pattern pt=Pattern.compile(regexURL);
        Matcher mt=pt.matcher(aHref);
        if(mt.find()) {
            String s2 = mt.group();
           content= mt.group().replaceAll(">|</a>","");
        }

        return content;
    }

    public static String URL(String aHref){
        String Url="";
        String regexURL="href=\".*?\"";
        Pattern pt=Pattern.compile(regexURL);
        Matcher mt=pt.matcher(aHref);
        if(mt.find()) {
            String s2 = mt.group();
            Url= mt.group().replaceAll("href=|\"","");
        }
        return Url;
    }
    public static void main(String[] args) {
        String test="<a class=\"name\" href=\"/u/ead8ecb1e8b0\">xilovesyu</a>";
        HrefHelper.Content(test);
        System.out.println(HrefHelper.URL(test));
    }
}
