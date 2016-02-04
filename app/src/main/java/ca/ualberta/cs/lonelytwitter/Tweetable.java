package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bashir1 on 1/14/16.
 */

/**
 * Tweetable interface
 * used in two classes
 * see
 * @see ImportantTweet
 * @see NormalTweet
 */
public interface Tweetable {
    // interface only takes methods.
    // interfaces provide a way to breaking up requirements where you want your
    // code to satisfy
    public String getMessage();
    public Date getDate();
}
