package cn.xdns.service.impl;

import cn.xdns.pojo.TaskJson;
import cn.xdns.service.MonitorServiceI;
import cn.xdns.utils.MonitorExecutor;
import cn.xdns.utils.ThreadExecutorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class DefaultMonitorServiceImpl implements MonitorServiceI {

    @Autowired
    private ThreadExecutorUtils executorUtils;

    @Override
    public Object executePoc(TaskJson taskJson) {
        System.out.println("开始执行漏洞检测===》" + taskJson.getTarget() + ".....");
        Object result = MonitorExecutor.execute(taskJson);
        System.out.println(taskJson.getPluginName() + "漏洞检测结果为===》》》" + result);
        return result;
    }

    @Override
    public Map<String, Object> executePocs(List<TaskJson> taskJsonList) {
        Map<String, Object> results = new HashMap<>();
        ExecutorService executor = executorUtils.getExecutor();
        List<FutureTask<Map<String, Object>>> futureTasks = new ArrayList<>();
        taskJsonList.forEach(task -> {
            Callable taskCall = () ->   results.put(task.getNetloc()+"," + task.getTarget(), executePoc(task));
            FutureTask<Map<String, Object>> futureTestTask = new FutureTask<Map<String, Object>>(taskCall);
            futureTasks.add(futureTestTask);
            executor.submit(futureTestTask);
        });
        futureTasks.forEach(task -> {
            try {
                task.get(1000 * 60 * 5, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
        return results;
    }

}
