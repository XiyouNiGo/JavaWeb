package xupt.se.ttms.entity;

public class Schedule {
  private long schedId;
  private long studioId;
  private long playId;
  private java.sql.Timestamp schedTime;
  private double schedTicketPrice;
  private long schedStatus;

  public long getSchedId() {
    return schedId;
  }

  public void setSchedId(long schedId) {
    this.schedId = schedId;
  }

  public long getStudioId() {
    return studioId;
  }

  public void setStudioId(long studioId) {
    this.studioId = studioId;
  }

  public long getPlayId() {
    return playId;
  }

  public void setPlayId(long playId) {
    this.playId = playId;
  }

  public java.sql.Timestamp getSchedTime() {
    return schedTime;
  }

  public void setSchedTime(java.sql.Timestamp schedTime) {
    this.schedTime = schedTime;
  }

  public double getSchedTicketPrice() {
    return schedTicketPrice;
  }

  public void setSchedTicketPrice(double schedTicketPrice) {
    this.schedTicketPrice = schedTicketPrice;
  }

  public long getSchedStatus() {
    return schedStatus;
  }

  public void setSchedStatus(long schedStatus) {
    this.schedStatus = schedStatus;
  }
}
