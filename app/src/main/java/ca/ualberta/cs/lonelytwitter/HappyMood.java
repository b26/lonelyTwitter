package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bashir1 on 1/14/16.
 */

public class HappyMood extends Mood {
    public HappyMood() {
    }

    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public String currentMood() {
        return "Happy Mood :D";
    }
}
