package ca.ualberta.cs.lonelytwitter;

/**
 * Created by bashir1 on 1/14/16.
 */
public class ImportantTweet extends Tweet implements Tweetable {
    public ImportantTweet(String message) {
        super(message);
    }

    public String getMessage() {
        return "Important " + this.message;
    }

    @Override
    public boolean isImportant() {
        return false;
    }
}
