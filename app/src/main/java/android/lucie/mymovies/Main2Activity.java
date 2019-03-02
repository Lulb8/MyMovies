package android.lucie.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showName();
    }

    public void showName () {
        Intent intent = getIntent();
        if (intent != null) {
            String str = "";
            if (intent.hasExtra("showTextView")) {
                str = intent.getStringExtra("showTextView");
            }
            TextView textView = (TextView) findViewById(R.id.name);
        }
    }
}
