package cc.ankin.deeplogtoolserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDetail {
    private String id;
    private String logId;
    private String filename;
    private String comment;

}
