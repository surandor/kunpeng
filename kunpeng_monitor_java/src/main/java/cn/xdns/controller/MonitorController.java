package cn.xdns.controller;

import cn.xdns.pojo.TaskJson;
import cn.xdns.service.MonitorServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("monitor")
public class MonitorController {

    @Autowired
    private MonitorServiceI monitorService;

    @PostMapping("executeTask")
    public String excuteTask (@RequestBody TaskJson taskJson ) {
        return monitorService.executePoc(taskJson).toString();
    }

    @PostMapping("executeTasks")
    public Map<String, Object> excuteTasks (@RequestBody List<TaskJson> taskJsons ) {
        return monitorService.executePocs(taskJsons);
    }
}
