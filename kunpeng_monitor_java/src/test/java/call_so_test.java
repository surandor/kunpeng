/**
 * @Author: wstart
 * @Date: 2019-02-14
 * @Version 0.1
 * @Desc: kunpeng JAVA 版本实现
 * 环境：jdk1.8 ,jna 5.2.0 , mac
 * 1. 请先下载 JNA的jar包  http://repo1.maven.org/maven2/net/java/dev/jna/jna/5.2.0/jna-5.2.0.jar
 * 2. 添加到项目中去，https://zyjustin9.iteye.com/blog/2172445
 * 3. 引入com.sun.jna.Library，com.sun.jna.Native
 * 4. 创建 Kunpeng interface
 * 5. 引入 Kunpeng
 * 6. 编写对应的方法
 * 其他: 对应的类型转换对照表： https://github.com/java-native-access/jna/blob/master/www/Mappings.md
 *
 */

import com.sun.jna.Library;
import com.sun.jna.Native;


public class call_so_test {

    public interface Kunpeng extends Library {
        Kunpeng INSTANCE = (Kunpeng)Native.load("dylib/kunpeng_c.dll", Kunpeng.class);

        /*  配置设置，传入配置JSON，格式为：
           {
               "timeout": 15, // 插件连接超时
               "aider": "http://123.123.123.123:8088", // 漏洞辅助验证接口，部分漏洞无法通过回显判断是否存在漏洞，可通过辅助验证接口进行判断。
               "http_proxy": "http://123.123.123.123:1080", // HTTP代理，所有插件http请求流量将通过代理发送（需使用内置的http请求函数util.RequestDo）
               "pass_list": ["passtest"], // 默认密码字典，不定义则使用硬编码在代码里的小字典
               "extra_plugin_path": "/tmp/plugin/" // 除已编译好的插件（Go、JSON）外，可指定额外插件目录（仅支持JSON插件），指定后程序会周期读取加载插件
           }
       */
        public  void SetConfig(String configJSON);
        public  String GetPlugins();
        public  String Check(String taskJSON);

    }


    public static void main(String[] args) {

            System.out.println("Hello Kunpeng");
            
            //解决部分打包发布方式下dll文件返回值被默认为其他格式编码造成的乱码
            //System.setProperty("jna.encoding", "UTF-8");

            String cfg_json = "{ \"timeout\":15 }";

            Kunpeng.INSTANCE.SetConfig(cfg_json);

            String task_json =  "{\n" +
                    "    'type': 'service'\n" +
                    "    'netloc': 'http://www.jingruis.com/',\n" +
                    "    'target': 'mysql', 'web', 'thinkphp'\n" +
                    "    'meta':{\n" +
                    "        'system': '',\n" +
                    "        'pathlist':[],\n" +
                    "        'filelist':[],\n" +
                    "        'passlist':[]\n" +
                    "    }";
            String task_json1 =  "{{\n" +
                    "    \"Request\": \"http://www.jingruis.com/\",\n" +
                    "    \"Response\": \"\",\n" +
                    "    \"author\": \"wolf\",\n" +
                    "    \"level\": 0,\n" +
                    "    \"name\": \"MySQL 弱口令\",\n" +
                    "    \"references\": {\n" +
                    "      \"cve\": \"\",\n" +
                    "      \"kpid\": \"KP-0005\",\n" +
                    "      \"url\": \"https://www.cnblogs.com/yunsicai/p/4080864.html\"\n" +
                    "    },\n" +
                    "    \"remarks\": \"导致数据库敏感信息泄露，严重可导致服务器直接被入侵控制。\",\n" +
                    "    \"target\": \"mysql\",\n" +
                    "    \"type\": \"WEAKPWD\"\n" +
                    "  }";

            String resut = Kunpeng.INSTANCE.Check(task_json);
            System.out.println(resut);
            System.out.println("-==========");
//            String resut1 = Kunpeng.INSTANCE.Check(task_json1);
//            System.out.println(resut1);

            System.out.println("-==========");

//            String plugins = Kunpeng.INSTANCE.GetPlugins();
//            System.out.println(plugins);


    }
}
