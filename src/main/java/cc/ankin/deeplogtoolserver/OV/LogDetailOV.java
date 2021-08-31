package cc.ankin.deeplogtoolserver.OV;

import cc.ankin.deeplogtoolserver.pojo.Log;
import cc.ankin.deeplogtoolserver.pojo.LogDetail;
import cc.ankin.deeplogtoolserver.utils.ToolUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDetailOV {
    private String id;
    private String logId;
    private Integer epoch;
    private Double accuracy;
    private Double trainLoss;
    private Double testLoss;
    private Double learningRate;
    private String startTime;
    private Long trainTime;
    private Long testTime;

    public LogDetailOV(LogDetail logDetail){
        this.id = logDetail.getId();
        this.logId = logDetail.getLogId();
        this.epoch = logDetail.getEpoch();
        this.accuracy = logDetail.getAccuracy();
        this.trainLoss = logDetail.getTrainLoss();
        this.testLoss = logDetail.getTestLoss();
        this.learningRate = logDetail.getLearningRate();
        this.startTime = ToolUtils.getTextTime(logDetail.getStartTime());
        this.trainTime = logDetail.getTrainTime();
        this.testTime = logDetail.getTestTime();


    }
}

