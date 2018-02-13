package edu.temple.myactivityproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int requestCode = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //within the context of main, secondActivity is what we want to target
                Intent launchIntent =
                        new Intent(MainActivity.this, SecondActivity.class);
                launchIntent.putExtra("message", "Please show this message to the user");
                //key is always a string, value can be different things

//                startActivity(launchIntent);

                startActivityForResult(launchIntent, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //callback info from activity 2
        super.onActivityResult(requestCode, resultCode, data);

        //Log.d("Return Info", requestCode + ""); //result is 0 (cancelled) if setResult is never called

        if(requestCode == this.requestCode && resultCode == RESULT_OK){
            Toast.makeText(MainActivity.this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }


    }
}
