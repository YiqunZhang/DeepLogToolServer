package cc.ankin.deeplogtoolserver.utils;

import cc.ankin.deeplogtoolserver.OV.ConfigOV;
import cc.ankin.deeplogtoolserver.OV.FileDetailOV;
import cc.ankin.deeplogtoolserver.OV.LogDetailOV;
import cc.ankin.deeplogtoolserver.OV.LogOV;
import cc.ankin.deeplogtoolserver.pojo.Config;
import cc.ankin.deeplogtoolserver.pojo.FileDetail;
import cc.ankin.deeplogtoolserver.pojo.Log;
import cc.ankin.deeplogtoolserver.pojo.LogDetail;
import cc.ankin.deeplogtoolserver.utils.MainUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class PageController {


    @GetMapping("/config")
    public String index(Model model, String logId) {
        List<ConfigOV> configOVList = new ArrayList<ConfigOV>();

        List<Config> configList = MainUtils.getInstance().getConfigByLogId(logId);

        Collections.sort(configList, new Comparator<Config>() {

            @Override
            public int compare(Config o1, Config o2) {
                return o1.getName().compareTo(o2.getName());

            }
        });


        for (Config config : configList) {
            configOVList.add(new ConfigOV(config));
        }

        model.addAttribute("configOVList", configOVList);
        return "config";
    }

    @GetMapping({"/index", "/"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/log")
    public String index(Model model, Boolean done) {
        List<LogOV> logOVList = new ArrayList<LogOV>();
        List<Log> logList = null;

        if (done) {
            logList = MainUtils.getInstance().getLogListMineDone();
        } else {
            logList = MainUtils.getInstance().getLogListMine();
        }

        Collections.sort(logList, new Comparator<Log>() {

            @Override
            public int compare(Log o1, Log o2) {
                return o2.getCreateTime().compareTo(o1.getCreateTime());

            }
        });



        for (Log log : logList) {
            logOVList.add(new LogOV(log));
        }

        model.addAttribute("logOVList", logOVList);
        return "log";
    }

    @GetMapping("/logDetail")
    public String logDetail(Model model, String logId) {
        List<LogDetailOV> logDetailOVList = new ArrayList<LogDetailOV>();

        List<LogDetail> logDetailList = MainUtils.getInstance().getLogDetailByLogId(logId);

        Collections.sort(logDetailList, new Comparator<LogDetail>() {

            @Override
            public int compare(LogDetail o1, LogDetail o2) {
                return o1.getEpoch()-o2.getEpoch();
            }
        });

        for (LogDetail logDetail : logDetailList) {
            logDetailOVList.add(new LogDetailOV(logDetail));
        }

        model.addAttribute("logDetailOVList", logDetailOVList);
        return "logDetail";
    }

    @GetMapping("/fileDetail")
    public String fileDetail(Model model, String logId) {

        List<FileDetailOV> fileDetailOVList = new ArrayList<FileDetailOV>();

        List<FileDetail> fileDetailList = MainUtils.getInstance().getFileDetailByLogId(logId);


        for (FileDetail fileDetail : fileDetailList) {
            fileDetailOVList.add(new FileDetailOV(fileDetail));
        }

        model.addAttribute("fileDetailOVList", fileDetailOVList);
        return "fileDetail";
    }



}