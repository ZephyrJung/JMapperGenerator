package org.b3log.model;

/**
 * @author Zhang Yu
 * Date: 17年12月16日
 * Email: 2895205695@qq.com
 */
public enum FileTypeEnum {
    JAVA(".java"),
    XML(".xml");

    private String type;

    FileTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
