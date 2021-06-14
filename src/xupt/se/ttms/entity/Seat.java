package xupt.se.ttms.entity;

public class Seat {
    private long seatId;
    private long studioId;
    private long seatRow;
    private long seatColumn;
    private long seatStatus;

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public long getStudioId() {
        return studioId;
    }

    public void setStudioId(long studioId) {
        this.studioId = studioId;
    }

    public long getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(long seatRow) {
        this.seatRow = seatRow;
    }

    public long getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(long seatColumn) {
        this.seatColumn = seatColumn;
    }

    public long getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(long seatStatus) {
        this.seatStatus = seatStatus;
    }
}
