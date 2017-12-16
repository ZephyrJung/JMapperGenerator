package org.b3log.util;

import org.b3log.model.TableColumn;

import java.util.List;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class MapperXmlUtil {
    public static String generateMapperXml(String packageName, String tableName, List<TableColumn> columnList) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columnList.size(); i++) {
            if (i != columnList.size() - 1) {
                builder.append(columnList.get(i).getColumnName()).append(",");
            } else {
                builder.append(columnList.get(i).getColumnName());
            }
        }
        return CommonValues.XML_TEMPLATE.replaceFirst(CommonValues.REPLACE, packageName+"."+tableName)
                .replaceFirst(CommonValues.REPLACE, builder.toString());
    }
}
