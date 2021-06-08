package xupt.se.ttms.entity;

public class Play {
    private long playId;
    private long dictTypeId;
    private long dictLangId;
    private String playName;
    private String playIntroduction;
    private String playImage;
    private String playVideo;
    private long playLength;
    private double playTicketPrice;
    private long playStatus;
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    private String playType;

    public Play() {
    }

    public Play(String playName, String playIntroduction, String playImage, String playVideo, long playLength,
                double playTicketPrice, long playStatus) {
        this.playName = playName;
        this.playIntroduction = playIntroduction;
        this.playImage = playImage;
        this.playVideo = playVideo;
        this.playLength = playLength;
        this.playTicketPrice = playTicketPrice;
    }

    public long getPlayId() {
        return playId;
    }

    public void setPlayId(long playId) {
        this.playId = playId;
    }

    public long getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(long dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public long getDictLangId() {
        return dictLangId;
    }

    public void setDictLangId(long dictLangId) {
        this.dictLangId = dictLangId;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public String getPlayIntroduction() {
        return playIntroduction;
    }

    public void setPlayIntroduction(String playIntroduction) {
        this.playIntroduction = playIntroduction;
    }

    public String getPlayImage() {
        return playImage;
    }

    public void setPlayImage(String playImage) {
        this.playImage = playImage;
    }

    public String getPlayVideo() {
        return playVideo;
    }

    public void setPlayVideo(String playVideo) {
        this.playVideo = playVideo;
    }

    public long getPlayLength() {
        return playLength;
    }

    public void setPlayLength(long playLength) {
        this.playLength = playLength;
    }

    public double getPlayTicketPrice() {
        return playTicketPrice;
    }

    public void setPlayTicketPrice(double playTicketPrice) {
        this.playTicketPrice = playTicketPrice;
    }

    public long getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(long playStatus) {
        this.playStatus = playStatus;
    }
}
