package com.test.ruleEngine.common;

/**
 * Created by 王亚运 on 2018/5/5.
 */
public class StringUtil {

    /**
     * 返回字符串Position位置开始空白的位数
     * @param str
     * @param start
     * @return
     */
    public static int skipBlank(String str, int start) {
        int blank = 0;
        while (str.length()> start && Character.isWhitespace(str.charAt(start)))
        {
            start ++;
            blank ++;
        }
        return blank;
    }

    public static boolean isBlank(String str) {
        return null == str || str.trim().length() == 0;
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static boolean isNumerics(String str)
    {
        return str.matches("^[+\\-]?(0|[1-9]\\d*|[1-9]\\d*\\.\\d+|0\\.\\d+)");
    }

    /**
     * 判断是否为日期
     * @param op
     * @return
     */
    public static boolean isDatetime(String op)
    {
        op = op.replace("\"","").trim();
        return op.matches("[0-9]{3}[1-9]-[0-9]{2}-[1-9][0-9](\\s[0-2][0-9]:[0-6][0-9]:[0-6][0-9])?");
    }

    public static void main(String[] args) {
        System.out.println(isDatetime("2014-02-11 10:00:001"));
    }
}
