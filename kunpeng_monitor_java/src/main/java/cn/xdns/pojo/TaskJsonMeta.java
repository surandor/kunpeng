package cn.xdns.pojo;

public class TaskJsonMeta {

    private String  system;
    private String  pathlist;
    private String  filelist;
    private String  passlist;

    @Override
    public String toString() {
        return "TaskJsonMeta{" +
                "system='" + system + '\'' +
                ", pathlist='" + pathlist + '\'' +
                ", filelist='" + filelist + '\'' +
                ", passlist='" + passlist + '\'' +
                '}';
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getPathlist() {
        return pathlist;
    }

    public void setPathlist(String pathlist) {
        this.pathlist = pathlist;
    }

    public String getFilelist() {
        return filelist;
    }

    public void setFilelist(String filelist) {
        this.filelist = filelist;
    }

    public String getPasslist() {
        return passlist;
    }

    public void setPasslist(String passlist) {
        this.passlist = passlist;
    }
}
