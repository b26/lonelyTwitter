package ca.ualberta.cs.lonelytwitter;

/**
 * Created by bashir1 on 1/14/16.
 */

import java.util.Date;

public class RandomClass {
    private String my_secret_data;
    private Date date;

    public RandomClass(String my_secret_data) {
        this.my_secret_data = my_secret_data;
    }

    public RandomClass(Date date) {
        this.date = date;
    }
}
