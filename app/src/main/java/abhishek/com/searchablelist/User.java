package abhishek.com.searchablelist;

/**
 * Created by Abhishek on 10/18/2018.
 */

public class User {


    public User(String price, String name) {
        this.price = price;
        this.name = name;
    }

    private String price;
    private String name;


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {


        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
