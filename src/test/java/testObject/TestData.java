package testObject;

import java.util.List;

public class TestData {
    String code;
    List<Data> data;

    public TestData(String code, List<Data> user) {
        this.code = code;
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }
    @Override
    public String toString(){
        return this.code + " " + this.data.stream();
    }
}
