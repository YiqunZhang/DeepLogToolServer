package cc.ankin.deeplogtoolserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDetail {
    private String id;
    private String logId;
    private Integer epoch;
    private Double accuracy;
    private Double trainLoss;
    private Double testLoss;
    private Double learningRate;
    private Long startTime;
    private Long trainTime;
    private Long testTime;
}
