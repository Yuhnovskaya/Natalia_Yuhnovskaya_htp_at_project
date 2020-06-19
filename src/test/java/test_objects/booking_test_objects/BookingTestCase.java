package test_objects.booking_test_objects;

public class BookingTestCase {
    String city;
    int daysIn;
    int daysFor;
    int adultsNumber;
    int childrenNumber;
    int roomNumber;

    public BookingTestCase(String city, int daysIn, int daysFor, int adultsNumber, int childrenNumber, int roomNumber) {
        this.city = city;
        this.daysIn = daysIn;
        this.daysFor = daysFor;
        this.adultsNumber = adultsNumber;
        this.childrenNumber = childrenNumber;
        this.roomNumber = roomNumber;
    }

    public String getCity() {
        return city;
    }

    public int getDaysIn() {
        return daysIn;
    }

    public int getDaysFor() {
        return daysFor;
    }

    public int getAdultsNumber() {
        return adultsNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public int getRoomsNumber() {
        return roomNumber;
    }

    @Override
   public String toString(){
       return this.city + " " + this.daysIn+" "+this.daysFor+" "+this.adultsNumber+" "+ this.childrenNumber+" "+roomNumber;
   }
}
