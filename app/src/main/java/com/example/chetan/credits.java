package com.example.chetan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.chetan.kitnapyara.MainActivity;
import com.example.chetan.kitnapyara.R;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

    }

    public void back(View v)
    {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}
