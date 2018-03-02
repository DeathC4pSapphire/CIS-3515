package edu.temple.myfragcommapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements InitiateFragment.InitiateInterface{

    RandomFragment randomFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomFragment = new RandomFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.randomContainer, randomFragment).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.initiatorContainer, new InitiateFragment()).commit();

//        findViewById(R.id.newNumberButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                randomFragment.generateNewNumber();
//            }
//        });
    }

    @Override
    public void buttonClicked(){
        randomFragment.generateNewNumber();

    }

}
