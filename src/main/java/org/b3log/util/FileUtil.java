package org.b3log.util;

import org.b3log.model.FileTypeEnum;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class FileUtil {


    public static void writeModel(String name, String content) {
        write("model", name, content, FileTypeEnum.JAVA);
    }

    public static void writeMapperJava(String name, String content) {
        write("mapper_java", name, content, FileTypeEnum.JAVA);
    }

    public static void writeMapperXml(String name, String content) {
        write("mapper_xml", name, content, FileTypeEnum.XML);
    }

    private static void write(String pack, String name, String content, FileTypeEnum fileType) {
        File file = new File(pack);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath() + File.separator + name + fileType.getType()));
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
