package cc.ankin.deeplogtoolserver.OV;

import cc.ankin.deeplogtoolserver.pojo.FileDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDetailOV {
    private String id;
    private String logId;
    private String filename;
    private String comment;

    public FileDetailOV(FileDetail fileDetail){
        this.id = fileDetail.getId();
        this.logId = fileDetail.getLogId();
        this.filename = fileDetail.getFilename();
        this.comment = fileDetail.getComment();
    }
}
