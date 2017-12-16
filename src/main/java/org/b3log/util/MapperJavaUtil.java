package org.b3log.util;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class MapperJavaUtil {
    public static String generateMapperJava(String packageName, String tableName) {

        return CommonValues.MAPPER_TEMPLATE.replaceFirst(CommonValues.REPLACE, packageName)
                .replaceFirst(CommonValues.REPLACE, StringUtil.CamelToUpperCase(tableName));
    }
}
