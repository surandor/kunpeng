package cn.xdns.pojo;

public class TaskJson {

    private String type;
    private String netloc;
    private String target;
    private TaskJsonMeta meta;
    private String pluginName;

    public TaskJson() {
    }

    public TaskJson(String type, String netloc, String target) {
        this.type = type;
        this.netloc = netloc;
        this.target = target;
    }

    @Override
    public String toString() {
        return "TaskJson{" +
                "type='" + type + '\'' +
                ", netloc='" + netloc + '\'' +
                ", target='" + target + '\'' +
                ", meta=" + meta +
                ", pluginName='" + pluginName + '\'' +
                '}';
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNetloc() {
        return netloc;
    }

    public void setNetloc(String netloc) {
        this.netloc = netloc;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public TaskJsonMeta getMeta() {
        return meta;
    }

    public void setMeta(TaskJsonMeta meta) {
        this.meta = meta;
    }
}
