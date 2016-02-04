package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by bashir1 on 1/28/16.
 */

/**
 * @see Tweet
 * @see NormalTweet
 * @see ImportantTweet
 *
 * Holds an ArrayList<Tweet>
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        if (this.hasTweet(tweet)) {
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * grabs tweets and sorts them by date.
     * @return a tweets object (ArrayList<tweet>)
     * @see Tweet
     */
    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t2.getDate().compareTo(t1.getDate());
            }
        });

        return tweets;
    }

    /**
     * getTweets returns the tweet you asked for.
     * @param index is the index number of the tweet
     * @return a tweet object
     * @see Tweet
     */
    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public int getCount() {
        return tweets.size();
    }

}
