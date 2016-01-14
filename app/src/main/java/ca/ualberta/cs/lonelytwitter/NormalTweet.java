package ca.ualberta.cs.lonelytwitter;

/**
 * Created by bashir1 on 1/14/16.
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(String message) {
        // change something in the parent class.
        // that's what super is doing.
        super(message);
    }
    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isImportant() {
        return false;
    }
}
