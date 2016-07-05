package www.godchin.tool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import www.godchin.tool.info.DeviceUuidFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DeviceUuidFactory deviceUuidFactory = new DeviceUuidFactory(this);
        String deviceId = deviceUuidFactory.getDeviceId(this);
        Log.d(TAG, " deviceId" + deviceId);


    }
}
