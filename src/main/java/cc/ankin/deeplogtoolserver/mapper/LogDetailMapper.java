package cc.ankin.deeplogtoolserver.mapper;

import cc.ankin.deeplogtoolserver.pojo.LogDetail;

import java.util.List;

public interface LogDetailMapper {
    void insertLogDetail(LogDetail logDetail);
    List<LogDetail> getLogDetailByLogId(String logId);
}
