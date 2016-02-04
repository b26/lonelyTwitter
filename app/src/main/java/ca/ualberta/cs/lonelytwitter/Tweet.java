package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bashir1 on 1/14/16.
 */

/**
 * Abstract Tweet class
 * @see NormalTweet
 * @see ImportantTweet
 * @see TweetList
 */
public abstract class Tweet {
    public String message;
    private ArrayList<Mood> mood;
    private Date date;

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Tweet(String message) {
        this.message = message;
        // TODO, set the date with a call to the date object.
        this.date = new Date();
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    /**
     *
     * @param message takes a string object. The message is from Tweet.getMessage
     * @throws TweetTooLongException if Tweet is too long...
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     *
     * @param date takes a date object. new Date() is enough.
     *             <code>
     *             Tweet.setDate(new Date());
     *             </code>
     */
    public void setDate(Date date) {
        this.date = date;
    }

    abstract public boolean isImportant();

    @Override
    public String toString() {
        return this.date.toString() + " | " + this.message;
    }
}
