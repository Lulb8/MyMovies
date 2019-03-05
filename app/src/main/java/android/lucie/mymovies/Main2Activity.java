package android.lucie.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static final String NAME = "showTextView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showName();
    }

    public void showName () {
        Intent intent = getIntent();
        // Get the text view where the name will be displayed
        TextView textView = (TextView) findViewById(R.id.name);
        // Get the name from the intent extras
        String myName = intent.getStringExtra(NAME);
        // Generate the random number
        String text = "";
        text = myName;
        // Display the name.
        textView.setText(text);

        /*
        Intent intent = getIntent();
        if (intent != null) {
            String str = "";
            if (intent.hasExtra("showTextView")) {
                str = intent.getStringExtra("showTextView");
            }
            TextView textView = (TextView) findViewById(R.id.name);
        }
    */

    }
}
