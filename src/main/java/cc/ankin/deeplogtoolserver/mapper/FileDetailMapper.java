package cc.ankin.deeplogtoolserver.mapper;

import cc.ankin.deeplogtoolserver.pojo.Config;
import cc.ankin.deeplogtoolserver.pojo.FileDetail;

import java.util.List;

public interface FileDetailMapper {
    void insertFileDetail(FileDetail fileDetail);
    List<FileDetail> getFileDetailByLogId(String logId);
    FileDetail getFileDetailById(String id);
}
