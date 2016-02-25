package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    // TODO: A function that gets tweets

    private static JestDroidClient client;

    private static String url = "http://cmput301.softwareprocess.es:8080";

    public static ArrayList<Tweet> getTweets() {
        if (client == null) verifyConfig();
        //return new ArrayList<Tweet>();
        return null;
    }


    // TODO: A function that adds a tweet

    public static void verifyConfig() {
        DroidClientConfig.Builder builder = new DroidClientConfig.Builder(url);
        DroidClientConfig config = builder.build();

        JestClientFactory factory = new JestClientFactory();
        factory.setDroidClientConfig(config);
        client = (JestDroidClient) factory.getObject();
    }

    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>> {
        @Override
        protected ArrayList<NormalTweet> doInBackground(String... params) {
            verifyConfig();
            /* holds tweets from ES */
            ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();
            //String search_string = params[0];


            String query = "{'query': {'match': {'tweet': '" + params[0] + "'}}}";
            Search search = new Search.Builder(query).addIndex("testing").addType("tweet").build();
            try {
               SearchResult execute =  client.execute(search);
                if (execute.isSucceeded()) {

                    List<NormalTweet> foundTweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(foundTweets);
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("TODO", "search was unsuccessful");
            }
            return tweets;
        }
    }

    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void>{
        @Override
        protected Void doInBackground(NormalTweet... params) {
            verifyConfig();
            for(NormalTweet tweet : params) {
                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult execute = client.execute(index);
                    if (execute.isSucceeded()) {
                        tweet.setId(execute.getId());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("TODO", "Add tweet failed");
                }
            }
            return null;
        }
    }
}
