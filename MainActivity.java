package de.andreas.weltuhr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextClock;

public class MainActivity extends Activity {

    private static final String[] ZONES = {
            "Europe/Berlin",
            "Europe/London",
            "America/Toronto",
            "America/New_York",
            "Asia/Tokyo"
    };

    private static final int[] CLOCK_IDS = {
            R.id.clockBerlin,
            R.id.clockLondon,
            R.id.clockToronto,
            R.id.clockNewYork,
            R.id.clockTokyo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < CLOCK_IDS.length; i++) {
            TextClock clock = findViewById(CLOCK_IDS[i]);
            clock.setTimeZone(ZONES[i]);
            clock.setFormat24Hour("HH:mm:ss");
        }
    }
}
