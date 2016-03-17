package ca.ualberta.cs.lonelytwitter;

import android.graphics.Bitmap;

import java.util.Date;

public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(Date date, String message, Bitmap thumbnail) {
        super(date, message, thumbnail);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
