package test_objects.http_test_objects;

public class TestData {
    public String user;
    boolean strict;

    public TestData(String user, boolean strict) {
        this.user = user;
        this.strict = strict;
    }
    @Override
    public String toString(){
        return this.user + " " + this.strict;
    }
}
