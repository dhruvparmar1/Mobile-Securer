package tranquvis.simplesmsremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import tranquvis.simplesmsremote.Activities.MainActivity;

public class welcomepage extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        mHandler = new Handler();

        mHandler.postDelayed(mUpdateTimeTask, 5000);
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            // do what you need to do here after the delay
            Intent intent = new Intent(welcomepage.this, MainActivity.class);
            startActivity(intent);
        }
    };
}
