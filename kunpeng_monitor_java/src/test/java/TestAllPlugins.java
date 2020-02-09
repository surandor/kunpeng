import cn.xdns.MonitorApplication;
import cn.xdns.pojo.TaskJson;
import cn.xdns.service.MonitorServiceI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MonitorApplication.class)
public class TestAllPlugins {

    @Autowired
    private MonitorServiceI monitorService;

    private String type = "";
    private List<String> targets = Arrays.asList("ssh", " smb", " redis", " postgresql", " mysql", " mssql", " mongodb", " memcache", " ftp", " discuz", " discuz", " axis", " web", " grafana", " proxy", " iis", " iis", " jboss", " web", " tomcat", " discuz", " web", " iis", " weblogic", " web", " wordpress", " zabbix", " zabbix", " zookeeper", " wordpress", " weblogic", " thinkphp", " activemq", " solr", " nexus", " struts2", " struts2", " struts2", " struts2", " struts2", " struts2", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " discuz", " django", " docker", " drupal", " docker", " glassfish", " hadoop", " joomla", " joomla", " joomla", " phpmyadmin", " thinkphp", " weblogic", " weblogic", " wordpress", " wordpress", " wordpress", " wordpress", " wordpress", " wordpress", " wordpress", " jenkins", " proxy", " struts2", " struts2", " thinkphp", " solr", " rails", " gitlab", " confluence", " rdp", " coremail", " webmin");
    private List<String> targetNames = Arrays.asList("SSH 弱口令", " SMB 匿名共享/弱口令", " Redis 未授权访问/弱口令", " PostgreSQL 弱口令", " MySQL 弱口令", " SQLServer 弱口令", " MongoDB 未授权访问/弱口令", " Memcache 未授权访问", " FTP 弱口令", " Discuz 3.X SSRF", " Discuz! 6.x/7.x 代码执行", " Axis2控制台 弱口令", " web目录浏览", " grafana 控制台弱口令", " HTTP代理 未授权访问", " IIS 物理路径泄露", " IIS 短文件名枚举", " JBoss 控制台弱口令", " shellshock 破壳漏洞", " Apache Tomcat 弱口令", " UcServer 创始人弱口令", " WebDav Put开启", " WebDav PROPFIND RCE(理论检测)", " Weblogic 控制台弱口令", " WebServer 任意文件读取", " WordPress 后台弱口令", " Zabbix jsrpc.php SQL注入漏洞", " Zabbix latest.php SQL注入漏洞", " zookeeper 未授权访问", " WordPress Mailpress Plugin 远程代码执行漏洞", " WebLogic WLS RCE", " ThinkPHP5 SQL Injection Vulnerability", " ActiveMQ 任意文件写入漏洞", " Apache solr XXE漏洞", " Nexus Repository Manager 3 远程代码执行漏洞", " Struts2 s2-016 远程代码执行", " Struts2 s2-017 URL跳转", " Struts2 s2-019 Dynamic method executions", " Struts2 s2-020 远程代码执行", " Struts2 s2-032 远程代码执行", " Struts2 s2-045 远程代码执行", " Discuz! 7.2 admincp.php XSS", " Discuz! 7.x ajax.php XSS", " Discuz! 7.x announcement.php XSS", " Discuz! X2.5 /api.php 网站物理路径泄露", " Discuz! 7.x attachment.php XSS", " Disucz! x3.0 focus.swf XSS", " Discuz! JiangHu Plugin SQL注入", " Discuz! 7.x member.php XSS", " Discuz! x3.2 misc.php SQL注入", " Disucz! x3.0 mp3player.swf XSS", " Discuz! 7.2 post.php XSS", " Discuz! 积分商城 Plugin SQL注入", " Discuz! 6.0 XSS", " Django < 2.0.8 任意URL跳转漏洞", " Docker Remote API未授权访问", " Drupal Drupalgeddon 2 远程代码执行漏洞", " ElasticSearch 未授权访问", " GlassFish 任意文件读取", " Hadoop YARN ResourceManager 未授权访问/RCE", " Joomla 3.7.0 SQL注入漏洞", " Joomla contushdvideoshare 任意文件读取漏洞", " Joomla departments SQL注入", " phpmyadmin scripts/setup.php 反序列化漏洞", " ThinkPHP5 5.0.22/5.1.29 远程代码执行漏洞", " Weblogic 任意文件上传漏洞", " Weblogic SSRF", " Wordpress cmdownloads RCE", " WordPress DZS-VideoGallery XSS", " WordPress example.html jQuery DomXSS", " WordPress MainWP 2.0.9.1 登录绕过", " WordPress Sexy Squeeze Pages Plugin XSS", " WordPress swfupload.swf FlashXSS", " WordPress Wpml Plugin XSS", " Jenkins Script Security and Pipeline RCE", " Socks5代理 未授权访问", " Struts2 s2-046 远程代码执行", " Struts2 s2-057 远程代码执行", " ThinkPHP5 5.0.23 远程代码执行", " Apache Solr ConfigAPI 远程代码执行", " Ruby on Rails 任意文件读取漏洞", " Gitlab OAuth Jira blind SSRF", " Atlassian Confluence Widget Connector macro RCE", " Microsoft Remote Desktop RCE", " coremail 配置文件读取", " Webmin 远程命令注入/执行");
    private List<List<TaskJson>> urlPlugins = null;


    @Before
    public void before () {
        type = "web";
        List<String> urls = Arrays.asList(
//                "http://www.jingruis.com/",
//                " https://www.circ.com.cn/",
//                " http://www.dongfang.com/",
//                " http://www.dytrustee.com/",
//                " http://www.cnnc.com.cn/",
//                " Cnadc.com.cn"

//                "http://www.cnnc.com.cn/"
//                "http://www.jingruis.com/"
//                "http://www.dongfang.com/"
//                "http://www.dytrustee.com/"
//                "https://www.circ.com.cn/"
//                "http://www.valedonia.com/hbt.php"
//                "http://www.pjcfzf.com/"
//                "https://hoya1798.com/"
//                "www.shandongyunxiao.com"
//                "https://www.meizitu.com/"
//                "http://www.bgctv.com.cn/",
                "http://www.dytrustee.com/"
        );


        urlPlugins = new ArrayList<>();
        urls.forEach(url -> {
            List<TaskJson> allPlugins = targets.stream().map(target -> new TaskJson(type, url, target)).collect(Collectors.toList());
            for (int i = 0; i < allPlugins.size(); i++) {
                allPlugins.get(i).setPluginName(targetNames.get(i));
            }
            urlPlugins.add(allPlugins);
        });
    }

    @Test
    public void testAllPlugins () {
        urlPlugins.forEach(allPlugin -> {
            System.out.println("=================================================================");
            System.out.println("开始执行全部漏洞检测, 检测网址为: " + allPlugin.get(0).getNetloc());
            System.out.println("====================================================================");
            monitorService.executePocs(allPlugin);
        });
    }

    @Test
    public void testAllPlugins2 () {
        urlPlugins.forEach(allPlugin -> {
            System.out.println("=================================================================");
            System.out.println("开始执行全部漏洞检测, 检测网址为: " + allPlugin.get(0).getNetloc());
            System.out.println("====================================================================");
            monitorService.executePocs(allPlugin);
        });
    }

    @Test
    public void testSinglePlugin () {
        String url = "http://www.cnnc.com.cn/";
//        String url = "http://www.jingruis.com/";
        System.out.println("检查网址为>>>" + url);
        TaskJson taskJson = new TaskJson("service", url, "thinkphp");
//        TaskJson taskJson = new TaskJson("service", "39.104.55.92", "thinkphp");
        monitorService.executePoc(taskJson);
    }
}
