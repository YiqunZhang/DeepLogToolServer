package cc.ankin.deeplogtoolserver.OV;

import cc.ankin.deeplogtoolserver.pojo.Config;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigOV {
    private String id;
    private String logId;
    private String name;
    private String value;

    public ConfigOV(Config config) {
        this.id = config.getId();
        this.logId = config.getLogId();
        this.name = config.getName();
        this.value = config.getValue();
    }
}