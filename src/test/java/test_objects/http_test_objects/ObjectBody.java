package test_objects.http_test_objects;

import java.util.List;

public class ObjectBody {
    String code;
    List<User> data;

    public ObjectBody(String code, List<User> user) {
        this.code = code;
        this.data = data;
    }

    public List<User> getData() {
        return data;
    }
    @Override
    public String toString(){
        return this.code + " " + this.data.stream();
    }
}
