package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main activity for a small Twitter app to capture,
 * <br> notes and comments.
 * <p> It saves the input tweets in the form of json files. </p><br>
 *     A sample code is as: <br>
 *         <code>
 *             for (int i = 0; i < 10; i++) {
 *                 System.out.println(i);
 *             }
 *         </code>
 * The list of important activities in this class are as follows: <br>
 *     <ul>
 *         <li> item1 </li>
 *         <li> item2 </li>
 *         <li> item3 </li>
 *         <li> item4 </li>
 *     </ul>
 * @see NormalTweet
 * @see java.awt
 * @author easy e
 * @version 2.1
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * @see Tweet
	 */

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<Tweet> adapter;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private Gson gson;
	
	
	public int calculateTweetSize () {
		return -1;
	}
	
	public String removeStopWords (String text) {
		return "";
	}
	
	public void startSecondActivity (Intent intent) {
		
	}

	/**
	 *
	 * @param text1 text
	 * @param text2 directory
	 * @param text3 username
	 * @param text4 file
	 * @return applies stuff
	 * @deprecated
	 * @exception IllegalAccessError
	 * This happens if
	 * @exception java.util.InvalidPropertiesFormatException
	 * This happens if
	 */
	public String doSomething (String text1, String text2, String text3, String text4) {
		return "";
	}
	
	protected boolean evaluateOtherActivity (Intent intent) {
		String exp1 = "",
				exp2 = "",
				exp3 = "",
				exp4 = "",
				expression = doSomething(exp1, exp2, 
						doSomething(exp1, exp2, exp3, exp4), exp3);
		int count = 10;
		
		for (int i = 0; i < count; i++) {
			try {
				int a = 1,
					b = 2;
				if (a < b) doSomething("", "", "", "");
				else if (b > a && b > 2) doSomething("a", "b", "", "");
				else doSomething("l", "m", "a", "o");
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return false;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// do something my parent class is doing
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// grabbing body text from input box
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newestTweet = new NormalTweet(text);
				tweets.add(newestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tweets.clear();
				saveInFile();
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}


	/**
	 * This method loads a file from disk from json format and encodes it into GSON format
	 * @return void
	 */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			gson = new Gson();

			/* take from google documentation.
			https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
			*/
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();

			/*  ptr changes. */
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * This method is used to save a file to the disk in JSON format
	 * @return void
	 */
	private void saveInFile() {
		try {
			//debug mode for file output. can only be
			//accessed by this app only. Or set it to 0, replace Context.MODE_PRIVATE with 0.
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace(); //not useful
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
	}
}