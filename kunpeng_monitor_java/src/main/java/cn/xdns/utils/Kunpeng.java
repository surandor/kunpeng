package cn.xdns.utils;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Kunpeng extends Library {
        Kunpeng INSTANCE = (Kunpeng) Native.load("dylib/kunpeng_c.dll", Kunpeng.class);

        /*  配置设置，传入配置JSON，格式为：
           {
               "timeout": 15, // 插件连接超时
               "aider": "http://123.123.123.123:8088", // 漏洞辅助验证接口，部分漏洞无法通过回显判断是否存在漏洞，可通过辅助验证接口进行判断。
               "http_proxy": "http://123.123.123.123:1080", // HTTP代理，所有插件http请求流量将通过代理发送（需使用内置的http请求函数util.RequestDo）
               "pass_list": ["passtest"], // 默认密码字典，不定义则使用硬编码在代码里的小字典
               "extra_plugin_path": "/tmp/plugin/" // 除已编译好的插件（Go、JSON）外，可指定额外插件目录（仅支持JSON插件），指定后程序会周期读取加载插件
           }
       */
        void SetConfig(String configJSON);
        String GetPlugins();
        String Check(String taskJSON);

    }