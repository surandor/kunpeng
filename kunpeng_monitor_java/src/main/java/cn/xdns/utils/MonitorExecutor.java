package cn.xdns.utils;

import cn.xdns.pojo.ConfigJson;
import cn.xdns.pojo.TaskJson;
import com.alibaba.fastjson.JSON;

public class MonitorExecutor {

    public static Object execute (TaskJson taskJson) {
        return execute(null, taskJson);
    }

    public static Object execute(ConfigJson configJson, TaskJson taskJson) {
        String cfg_json = configJson != null ? JSON.toJSONString(configJson)
                : "{ \"timeout\":15 }";

        Kunpeng.INSTANCE.SetConfig(cfg_json);

        String taskJsonStr = JSON.toJSONString(taskJson);

        String resut = Kunpeng.INSTANCE.Check(taskJsonStr);
        System.out.println(resut);
        return resut;
   }

}
