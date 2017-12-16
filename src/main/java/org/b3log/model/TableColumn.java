package org.b3log.model;

import lombok.Data;
import org.b3log.util.StringUtil;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
@Data
public class TableColumn {
    private String columnName;
    private String dataType;
    private String columnComment;

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(TableColumn.class.getResourceAsStream("/typemap.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getType() {
        return properties.getProperty(this.dataType);
    }

    public String getField() {
        return StringUtil.camelToUpperCase(this.columnName);
    }

    public static void main(String[] args) {
        TableColumn column = new TableColumn();
        column.setColumnName("test_table_column");
        System.out.println(column.getField());
    }
}
