package com.example.kusteau;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // button for selecting menu
    Button menuButton[];
    // tell if the button is selected
    Boolean isSelected[];
    // button for sending
    Button sendButtonOn;
    Button sendButtonOff;
    // # of selected menu
    int     selected = 0;

    // assign button object per button
    void setButtons() {
        menuButton[0] = (Button)findViewById(R.id.koreanFood);
        menuButton[1] = (Button)findViewById(R.id.chinaFood);
        menuButton[2] = (Button)findViewById(R.id.japanFood);
        menuButton[3] = (Button)findViewById(R.id.americaFood);
        menuButton[4] = (Button)findViewById(R.id.schoolFood);
        menuButton[5] = (Button)findViewById(R.id.desert);
        menuButton[6] = (Button)findViewById(R.id.guitar);
        menuButton[7] = (Button)findViewById(R.id.nightFood);
        menuButton[8] = (Button)findViewById(R.id.fastFood);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init each button
        menuButton = new Button[9];
        isSelected = new Boolean[9];
        sendButtonOn = (Button)findViewById(R.id.sendButtonOn);
        sendButtonOff = (Button)findViewById(R.id.sendButtonOff);
        // assign button object per button
        setButtons();
        for (int i=0; i<menuButton.length; ++i)
            isSelected[i] = false;
    }

    void checkSelected(int i) {
        if (isSelected[i]) {
            --selected;
        } else {
            ++selected;
        }
        isSelected[i] = !isSelected[i];

        if (selected <= 0) {
            sendButtonOn.setVisibility(View.INVISIBLE);
            sendButtonOff.setVisibility(View.VISIBLE);
        } else {
            sendButtonOn.setVisibility(View.VISIBLE);
            sendButtonOff.setVisibility(View.INVISIBLE);
        }
    }

    void onMenuButtonClicked(View v) {
        int     i = -1;
        // case
        switch (v.getId()) {
            case R.id.koreanFood:
                i = 0;
                break;
            case R.id.chinaFood:
                i = 1;
                break;
            case R.id.japanFood:
                i = 2;
                break;
            case R.id.americaFood:
                i = 3;
                break;
            case R.id.schoolFood:
                i = 4;
                break;
            case R.id.desert:
                i = 5;
                break;
            case R.id.guitar:
                i = 6;
                break;
            case R.id.nightFood:
                i = 7;
                break;
            case R.id.fastFood:
                i = 8;
                break;
        }
        if (i <= -1) {
            return;     // error
        }

        // check the # of selected button
        checkSelected(i);
    }
}
