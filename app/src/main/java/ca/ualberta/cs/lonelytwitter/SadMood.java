package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bashir1 on 1/14/16.
 */
public class SadMood extends Mood {

    public SadMood() {
    }

    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String currentMood() {
        return "Sad Mood D:";
    }
}

