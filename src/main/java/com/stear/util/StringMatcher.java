package com.stear.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class StringMatcher {
    /**
     * 正则匹配，不支持分组匹配
     * @param s 带查字符串
     * @param regex 正则表达式
     * @return 匹配结果
     */
    public String matchString(String s,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
}
