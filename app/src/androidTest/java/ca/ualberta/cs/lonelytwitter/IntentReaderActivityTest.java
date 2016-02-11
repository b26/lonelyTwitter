package ca.ualberta.cs.lonelytwitter;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sajediba on 2/8/16.
 */
public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2{

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    //
    //
    public void testSendText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "free bobby");
        setActivityIntent(intent);
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();

        assertEquals("free bobby", intentReaderActivity.getText());
    }
    //
    //

    public void testDefaultText() {
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();
        assertEquals("text was null", ((TextView) intentReaderActivity.findViewById(R.id.intentText)).getText().toString());
    }

    public void testDisplayText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "free bobby");
        setActivityIntent(intent);
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();
        assertEquals("free bobby", ((TextView) intentReaderActivity.findViewById(R.id.intentText)).getText().toString());
    }


    public void testDoubleText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Test message 4");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
        setActivityIntent(intent);

        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();
        assertEquals("The text should be repeated", "Test message 4Test message 4", intentReaderActivity.getText());

    }

    public void testReverseText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "stressed");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
        setActivityIntent(intent);

        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();
        assertEquals("The text should be repeated", "desserts", intentReaderActivity.getText());
    }

    public void testViewIsVisible() {
        IntentReaderActivity intentReaderActivity = (IntentReaderActivity) getActivity();

        ViewAsserts.assertOnScreen(intentReaderActivity.getWindow().getDecorView(),
                intentReaderActivity.findViewById(R.id.intentText));
    }
    // TODO: Add your code here ...
//-------------------------------------------------------------------------------
// no
//-------------------------------------------------------------------------------
}
