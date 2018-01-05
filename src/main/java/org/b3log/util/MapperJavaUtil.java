package org.b3log.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class MapperJavaUtil {
    public static String generateMapperJava(String packageName, String tableName) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return CommonValues.MAPPER_TEMPLATE.replaceFirst(CommonValues.REPLACE, packageName)
                .replaceFirst(CommonValues.REPLACE,CommonValues.TITLE.replace(CommonValues.REPLACE,simpleDateFormat.format(new Date())))
                .replaceFirst(CommonValues.REPLACE, StringUtil.CamelToUpperCase(tableName));
    }
}
