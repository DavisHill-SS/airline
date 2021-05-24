package entity;

public class BookingPayment {
	private Booking booking;
	private String id;
	private Integer refunded;
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getRefunded() {
		return refunded;
	}
	public void setRefunded(Integer refunded) {
		this.refunded = refunded;
	}
}
