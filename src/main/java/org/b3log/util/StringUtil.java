package org.b3log.util;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class StringUtil {
    public static String camelToUpperCase(String s) {
        String[] strings = s.split("_");
        if (strings.length < 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i == 0) {
                builder.append(strings[i]);
            } else {
                builder.append(strings[i].substring(0, 1).toUpperCase()).append(strings[i].substring(1));
            }
        }
        return builder.toString();
    }

    public static String CamelToUpperCase(String s) {
        String[] strings = s.split("_");
        if (strings.length < 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i].substring(0, 1).toUpperCase()).append(strings[i].substring(1));
        }
        return builder.toString();
    }
}
