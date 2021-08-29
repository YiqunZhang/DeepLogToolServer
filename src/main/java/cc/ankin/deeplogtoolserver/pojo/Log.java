package cc.ankin.deeplogtoolserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private String id;
    private String userId;
    private Long createTime;
    private String title;
    private String comments;
    private Integer done;

}