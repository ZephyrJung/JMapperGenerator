package org.b3log.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Zhang Yu
 * Date: 17年12月16日
 * Email: 2895205695@qq.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MapperInfo {
    private String url;
    private String userName;
    private String password;
    private String database;
    private String modelPack;
    private String mapperJavaPack;

    public boolean checkParam() {
        return !StringUtils.isBlank(url)
                && !StringUtils.isBlank(userName)
                && !StringUtils.isBlank(password)
                && !StringUtils.isBlank(database);
    }
}
