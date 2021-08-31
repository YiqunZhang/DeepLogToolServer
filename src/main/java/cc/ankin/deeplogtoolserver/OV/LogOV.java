package cc.ankin.deeplogtoolserver.OV;

import cc.ankin.deeplogtoolserver.pojo.Log;
import cc.ankin.deeplogtoolserver.utils.ToolUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogOV {
    private String id;
    private String userId;
    private String createTime;
    private String title;
    private String comments;
    private String done;
    private String dataset;
    private String task;
    private Integer epoch;

    public LogOV(Log log){
        this.id = log.getId();
        this.userId = log.getUserId();
        this.createTime = ToolUtils.getTextTime(log.getCreateTime());
        this.title = log.getTitle();
        this.comments = log.getComments();

        if (log.getDone() == 1){
            this.done = "Done";
        }else {
            this.done = "";
        }

        this.dataset = log.getDataset();
        this.task = log.getTask();
        this.epoch = log.getEpoch();
    }
}


