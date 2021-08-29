package cc.ankin.deeplogtoolserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config {
    private String id;
    private String logId;
    private String name;
    private String value;
}
