package pwittchen.com.androiddebugplayground;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;

import com.github.stephanenicolas.loglifecycle.LogLifeCycle;

import hugo.weaving.DebugLog;


@LogLifeCycle
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getName("John","Doe");
    }

    @DebugLog
    public String getName(String first, String last) {
        SystemClock.sleep(15); // Don't ever really do this!
        return first + " " + last;
    }
}
