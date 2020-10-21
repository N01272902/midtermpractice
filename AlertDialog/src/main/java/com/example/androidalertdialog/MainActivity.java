package com.example.androidalertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 Button alert1 = (Button) findViewById(R.id.alert1);
	        alert1.setOnClickListener(new View.OnClickListener() {
	          
				public void onClick(View view) {
					//
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
					// set title
					alertDialogBuilder.setTitle("Dialog 1");
					// set dialog message
					alertDialogBuilder
							.setMessage("Click yes to exit!")
							.setCancelable(false)
							.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

									//display in short period of time
									Toast.makeText(getApplicationContext(), "Yes is clicked",
											Toast.LENGTH_LONG).show();

								}
							})

							.setNegativeButton("No", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();

									//display in short period of time
									Toast.makeText(getApplicationContext(), "No is clicked",
											Toast.LENGTH_LONG).show();
								}
							});
					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();

					// show it
					alertDialog.show();

				}
	        });
	 
	        Button alert2 = (Button) findViewById(R.id.alert2);
	        alert2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	               // showDialog(ALERT_DIALOG2);
	                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
	            	builder.setTitle("Dialog 2");
	            	builder.setMessage("I am informing you about something");
	            	builder.show();
	            }
	        });
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		Log.d("CDA", "onBackPressed Called");
		// create alert dialog

		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Dilog 2");
		builder.show();
	}
}
