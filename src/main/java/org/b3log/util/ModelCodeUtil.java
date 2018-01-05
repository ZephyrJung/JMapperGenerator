package org.b3log.util;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.apache.commons.lang3.StringUtils;
import org.b3log.model.TableColumn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class ModelCodeUtil {
    private static Formatter formatter = new Formatter();


    public static String generateModel(String packageName, String className, List<TableColumn> columnList) {
        StringBuilder codeHead = new StringBuilder();
        codeHead.append("package ")
                .append(packageName).append(";\n\n")
                .append("import lombok.Data;\n");
        if (columnList.stream().anyMatch(c -> "date".equalsIgnoreCase(c.getDataType())
                || "datetime".equalsIgnoreCase(c.getDataType()))) {
            codeHead.append("import java.util.Date;\n");
        }
        codeHead.append("\n");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        codeHead.append(CommonValues.TITLE.replace(CommonValues.REPLACE,simpleDateFormat.format(new Date())));
        codeHead.append("@Data\n");
        StringBuilder codeBody = new StringBuilder();
        codeBody.append("public class ").append(className).append("{\n");
        for (TableColumn column : columnList) {
            if (StringUtils.isNotBlank(column.getColumnComment())) {
                codeBody.append("/**\n")
                        .append(" * ").append(column.getColumnComment()).append("\n")
                        .append(" */\n");
            }
            codeBody.append("private ")
                    .append(column.getType()).append(" ")
                    .append(column.getField()).append(";\n\n");
        }
        codeBody.append("}");
        return codeHead.append(formatSource(codeBody.toString())).toString();
    }

    public static String formatSource(String source) {
        try {
            return formatter.formatSource(source);
        } catch (FormatterException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("1");
        builder.append("2");
        System.out.println(builder.toString());
    }
}
