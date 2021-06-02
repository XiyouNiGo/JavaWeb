package xupt.se.ttms.entity;

public class Ticket {
  private long ticketId;
  private long seatId;
  private long schedId;
  private double ticketPrice;
  private long ticketStatus;
  private java.sql.Timestamp ticketLocktime;

  public long getTicketId() {
    return ticketId;
  }

  public void setTicketId(long ticketId) {
    this.ticketId = ticketId;
  }

  public long getSeatId() {
    return seatId;
  }

  public void setSeatId(long seatId) {
    this.seatId = seatId;
  }

  public long getSchedId() {
    return schedId;
  }

  public void setSchedId(long schedId) {
    this.schedId = schedId;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(double ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public long getTicketStatus() {
    return ticketStatus;
  }

  public void setTicketStatus(long ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  public java.sql.Timestamp getTicketLocktime() {
    return ticketLocktime;
  }

  public void setTicketLocktime(java.sql.Timestamp ticketLocktime) {
    this.ticketLocktime = ticketLocktime;
  }
}
