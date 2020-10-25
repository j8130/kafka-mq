package com.jiasy.kafka_mq.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: jsy
 * @Date: 2020/10/24 21:53
 */
public class Java2Unicode {

    //中文转Unicode
    public String cn2Unicode(final String gbString) {   //gbString = "测试"
        char[] utfBytes = gbString.toCharArray();   //utfBytes = [测, 试]
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);   //转换为16进制整型字符串
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }

    //Unicode转中文
    public String unicode2cn(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    /**
     * 这个工具牛批
     * @param str
     * @return
     */
    public static String unicodeToCn(String str) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            // group 6728
            String group = matcher.group(2);
            // ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            // group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;

    }

    public static void main(String[] args) {
        Java2Unicode java2Unicode = new Java2Unicode();
        String unicode = java2Unicode.cn2Unicode("哈哈果嘉年华了发达国家那还好");
        System.out.println(unicode);

        String s = java2Unicode.unicodeToCn("Flink\\u57fa\\u7840\\u6559\\u7a0b.\\u56fe\\u7075\\u7a0b\\u5e8f\\u8bbe\\u8ba1\\u4e1b\\u4e66");
        System.out.println(s);

    }
}
