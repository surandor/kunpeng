package cn.xdns.service;

import cn.xdns.pojo.TaskJson;

import java.util.List;
import java.util.Map;

public interface MonitorServiceI {

    Object executePoc (TaskJson taskJson);

    Map<String, Object> executePocs (List<TaskJson> taskJsonList);
}
