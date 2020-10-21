package com.example.simpleintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //
    //
    public void callIntent(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnBrowser:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.cbc.ca"));
                startActivity(intent);
                break;
            case R.id.btnPhoneCall:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(416)289-5000"));
                startActivity(intent);
                break;
            case R.id.btnActivity:
                intent = new Intent(this, DisplayActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
