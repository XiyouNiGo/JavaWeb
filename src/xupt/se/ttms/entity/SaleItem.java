package xupt.se.ttms.entity;

public class SaleItem {
    private long saleItemId;
    private long ticketId;
    private long saleId;
    private double saleItemPrice;

    public long getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(long saleItemId) {
        this.saleItemId = saleItemId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    public double getSaleItemPrice() {
        return saleItemPrice;
    }

    public void setSaleItemPrice(double saleItemPrice) {
        this.saleItemPrice = saleItemPrice;
    }
}
