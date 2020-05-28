package testObject.BookingTestObjects;

import java.util.List;

public class BookingTestData {
    List<BookingTestCase> bookingTestCase;

    public BookingTestData(List<BookingTestCase> bookingTestCase) {
        this.bookingTestCase = bookingTestCase;
    }

    public List<BookingTestCase> getBookingTestCase() {
        return bookingTestCase;
    }
}
