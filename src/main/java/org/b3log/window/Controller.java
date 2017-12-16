package org.b3log.window;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.b3log.model.MapperInfo;
import org.b3log.util.MybatisUtil;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class Controller {
    public TextField database;
    public TextField username;
    public TextField password;
    public TextField url;
    public TextField model;
    public TextField mapper;
    public Button generate;

    public void generateFiles(ActionEvent actionEvent) {
        MapperInfo mapperInfo = MapperInfo.builder()
                .database(database.getText())
                .userName(username.getText())
                .password(password.getText())
                .url(url.getText())
                .modelPack(model.getText())
                .mapperJavaPack(mapper.getText()).build();
        if(MybatisUtil.generate(mapperInfo)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("成功");
            alert.headerTextProperty().set("请查看当前目录下的mapper_java,mapper_xml,model文件夹");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.titleProperty().set("失败");
            alert.headerTextProperty().set("没成功，要不你再试试");
            alert.showAndWait();
        }
    }
}
