package cc.ankin.deeplogtoolserver.mapper;

import cc.ankin.deeplogtoolserver.pojo.Log;
import cc.ankin.deeplogtoolserver.pojo.User;

import java.util.List;

public interface LogMapper {
    void insertLog(Log log);
    void updateLog(Log log);
    Log getLogById(String id);
    List<Log> getLogListByUserId(String UserId);
    List<Log> getLogListByUserIdDone(String UserId);

}
