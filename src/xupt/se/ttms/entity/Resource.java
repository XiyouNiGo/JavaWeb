package xupt.se.ttms.entity;

public class Resource {
    private long resId;
    private String resParent;
    private String resName;
    private String resUrl;

    public long getResId() {
        return resId;
    }

    public void setResId(long resId) {
        this.resId = resId;
    }

    public String getResParent() {
        return resParent;
    }

    public void setResParent(String resParent) {
        this.resParent = resParent;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }
}
