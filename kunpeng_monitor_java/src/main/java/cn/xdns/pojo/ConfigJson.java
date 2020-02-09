package cn.xdns.pojo;

import java.util.Arrays;

public class ConfigJson {
    private String  timeout;
    private String  aider;// 漏洞辅助验证接口，部分漏洞无法通过回显判断是否存在漏洞，可通过辅助验证接口进行判断。
    private String  http_proxy;// HTTP代理，所有插件http请求流量将通过代理发送（需使用内置的http请求函数util.RequestDo）
    private String[]  pass_list;//"默认密码字典，不定义则使用硬编码在代码里的小字典
    private String  extra_plugin_path;// 除已编译好的插件（Go、JSON）外，可指定额外插件目录（仅支持JSON插件），指定后程序会周期读取加载插件

    @Override
    public String toString() {
        return "ConfigJson{" +
                "timeout='" + timeout + '\'' +
                ", aider='" + aider + '\'' +
                ", http_proxy='" + http_proxy + '\'' +
                ", pass_list=" + Arrays.toString(pass_list) +
                ", extra_plugin_path='" + extra_plugin_path + '\'' +
                '}';
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getAider() {
        return aider;
    }

    public void setAider(String aider) {
        this.aider = aider;
    }

    public String getHttp_proxy() {
        return http_proxy;
    }

    public void setHttp_proxy(String http_proxy) {
        this.http_proxy = http_proxy;
    }

    public String[] getPass_list() {
        return pass_list;
    }

    public void setPass_list(String[] pass_list) {
        this.pass_list = pass_list;
    }

    public String getExtra_plugin_path() {
        return extra_plugin_path;
    }

    public void setExtra_plugin_path(String extra_plugin_path) {
        this.extra_plugin_path = extra_plugin_path;
    }
}
