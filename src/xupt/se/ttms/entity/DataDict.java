package xupt.se.ttms.entity;

public class DataDict {
    private long dictId;
    private long superDictId;
    private long dictIndex;
    private String dictName;
    private String dictValue;

    public long getDictId() {
        return dictId;
    }

    public void setDictId(long dictId) {
        this.dictId = dictId;
    }

    public long getSuperDictId() {
        return superDictId;
    }

    public void setSuperDictId(long superDictId) {
        this.superDictId = superDictId;
    }

    public long getDictIndex() {
        return dictIndex;
    }

    public void setDictIndex(long dictIndex) {
        this.dictIndex = dictIndex;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
