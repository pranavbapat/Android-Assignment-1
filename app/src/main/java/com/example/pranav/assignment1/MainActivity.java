package com.example.pranav.assignment1;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView clickCountOutput, backgroundCountOutput;
    int clickCount,backgroundCount;
    final String CLICK_COUNT = "clickCount";
    final String BACKGROUND_COUNT = "backgroundCount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickCountOutput = (TextView) this.findViewById(R.id.clickCount);
        clickCountOutput.setText(String.valueOf(clickCount));

        backgroundCountOutput = (TextView) this.findViewById(R.id.backgroundCount);
        backgroundCountOutput.setText(String.valueOf(backgroundCount));
    }

    @Override
    public void onResume(){
        super.onResume();

        backgroundCountOutput.setText(String.valueOf(backgroundCount));
        clickCountOutput.setText(String.valueOf(clickCount));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        backgroundCount = savedInstanceState.getInt(BACKGROUND_COUNT,0);
        clickCount = savedInstanceState.getInt(CLICK_COUNT,0);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        if(isChangingConfigurations())
            backgroundCount--;
        savedInstanceState.putInt(CLICK_COUNT,clickCount);
        savedInstanceState.putInt(BACKGROUND_COUNT, ++backgroundCount);
    }

    public void increaseClickCount(View button){
        clickCountOutput.setText(String.valueOf(++clickCount));
    }
}
