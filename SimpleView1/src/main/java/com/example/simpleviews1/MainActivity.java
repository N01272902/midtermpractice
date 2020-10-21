package com.example.simpleviews1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //rotates image button images onClick
        ImageButton image = (ImageButton) findViewById(R.id.btnImg1);
        image.setOnClickListener(new View.OnClickListener() {
           int counter = 0;
            @Override
            public void onClick(View v) {
                counter ++;
                switch (v.getId()) {
                    case R.id.btnImg1:
                        if (counter == 1) {
                            ImageButton image = findViewById(R.id.btnImg1);
                            image.setImageResource(R.drawable.pic1);
                            break;
                        } else if (counter == 2) {
                            ImageButton image = findViewById(R.id.btnImg1);
                            image.setImageResource(R.drawable.pic2);
                            break;
                        } else if (counter == 3) {
                            ImageButton image = findViewById(R.id.btnImg1);
                            image.setImageResource(R.drawable.pic3);
                            counter = 0;
                            break;
                        }
                        break;
                }
            }
        });

            //---Button view---
        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        //register the button with an event listener
        btnOpen.setOnClickListener(new View.OnClickListener()
        { //anonymous class
            //implement your event handler method
            public void onClick(View v) {
               // DisplayToast("You have clicked the Open button");

                //Opens an alert dialog with option to stay or exit app
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure to Exit")
                        .setMessage("Clicking 'Yes' will call the finish() method")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                 /* To completely remove the activity from recent tasks list */
                                //finishAndRemoveTask();
                 /* Or to just exit the app */
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                DisplayToast("You clicked the 'No' option");
                            }
                        }).show();
            }
        });



		//---Button view---
        final EditText editText = findViewById(R.id.txtName);

		Button btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				//DisplayToast("You have clicked the Save button");

                String result = editText.getText().toString();
                Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
			}
		});


        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    DisplayToast("The switch is ON");
                }else{
                    DisplayToast("The switch is OFF");
                }
            }
        });


        //---CheckBox---
        CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
        checkBox.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                if (((CheckBox)v).isChecked())
                    DisplayToast("CheckBox is checked");
                else
                    DisplayToast("CheckBox is unchecked");
            }
        });

        //---RadioButton---
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdbGp1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.rdb1);
                if (rb1.isChecked()) {
                    DisplayToast("Option 1 checked!");
                } else {
                    DisplayToast("Option 2 checked!");
                }
            }
        });

        //---ToggleButton---
        ToggleButton toggleButton =
                (ToggleButton) findViewById(R.id.toggle1);
        toggleButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                if (((ToggleButton)v).isChecked())
                    DisplayToast("Toggle button is On");
                else
                    DisplayToast("Toggle button is Off");
            }
        });
    }

    private void DisplayToast(String msg)
    {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }
}