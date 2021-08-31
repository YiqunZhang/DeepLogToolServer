package cc.ankin.deeplogtoolserver.mapper;

import cc.ankin.deeplogtoolserver.pojo.Config;
import cc.ankin.deeplogtoolserver.pojo.LogDetail;

import java.util.List;

public interface ConfigMapper {
    void insertConfig(Config config);
    List<Config> getConfigByLogId(String logId);
}

