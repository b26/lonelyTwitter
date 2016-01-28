package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by bashir1 on 1/28/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");
        tweets.add(tweet);
        try {
            tweets.add(tweet);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("grabbing");
        tweets.add(tweet);
        assertEquals(tweet, tweets.getTweet(0));
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("deleting");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet first = new NormalTweet("Hello");
        Tweet second = new NormalTweet("Okay");
        tweets.add(first);
        tweets.add(second);
        assertEquals(second, tweets.getTweets().get(1));
    }

    public void getCountTest() {
        TweetList tweets = new TweetList();
        Tweet first = new NormalTweet("First");
        Tweet second = new NormalTweet("Second");
        tweets.add(first);
        assertEquals(1, tweets.getCount());
        tweets.add(second);
        assertEquals(2, tweets.getCount());
        tweets.delete(first);
        assertEquals(1, tweets.getCount());
    }


}
