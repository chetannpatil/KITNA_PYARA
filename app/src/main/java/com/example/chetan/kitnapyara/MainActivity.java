package com.example.chetan.kitnapyara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.chetan.Receive;
import com.example.chetan.credits;


public class MainActivity extends Activity
{
    public static EditText etBoyName;
    public  static EditText etGirlName;
    public static Button btnDetails;

    @Override
    protected void onCreate(Bundle bd)
    {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);
        etBoyName = (EditText) findViewById(R.id.etBoyName);
        etGirlName = (EditText) findViewById(R.id.etGirlName);
        btnDetails = (Button) findViewById(R.id.btn_submit_details);
        if ( bd != null )
        {
            etBoyName.setText(bd.getString("bNameFromBundle"));
            etGirlName.setText(bd.getString("gNameFromBundle"));
        }
    }

    //overridnign & incresing accesbiliy level
    @Override
    public void onSaveInstanceState(Bundle b)
    {
        String bNStr = etBoyName.getText().toString();
        String gNStr = etGirlName.getText().toString() ;

        b.putString("bNameFromBundle",bNStr.toLowerCase());
        b.putString("gNameFromBundle",gNStr.toLowerCase());
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    //first time submitting details
    public void submitDetails(View v)
    {
        String bNameStr =etBoyName.getText().toString().toLowerCase();
        String gNameStr = etGirlName.getText().toString().toLowerCase();
        String sa[] = new String[2];
        if( bNameStr.length()==0)
            Toast.makeText(this,"KRIPAYA LADKEKA NAAM ENTER KEEJIYE",Toast.LENGTH_SHORT).show();
        else if (gNameStr==null || gNameStr.length()==0)
            Toast.makeText(this,"KRIPAYA LADKIKA NAAM ENTER KEEJIYE",Toast.LENGTH_SHORT).show();
        try {
            boolean bNameOkay= validateName(bNameStr);
            boolean gNameOkay =validateName(gNameStr);

            if (bNameOkay==true && gNameOkay==true)
            {
                sa[0]=bNameStr;
                sa[1]=gNameStr;
                Intent in = new Intent(this, Receive.class);
                in.putExtra(Intent.EXTRA_TEXT,sa);
                startActivity(in);
            }
                  }
        catch (Exception e)
        {
            Toast.makeText(this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }



    }

    private static boolean validateName(String n)
    {
        boolean okay=false;
        for (int i=0;i<n.length();i++)
        {
            char ch = n.charAt(i);
            if ((ch>=65 && ch<=90) || ( ch>=97 && ch <= 122))
            {//okay
            }
            else if (ch==32)
                throw new IllegalArgumentException("SURNAME NAHI LE SAKTE HAI SORRY,SIRF FIRSTNAME ENTER KEEJIYE, TQ");
            else
                throw new IllegalArgumentException("KRIPAYA SIRF LETTERS ENTER KEEJIYE, TQ");
            if (i==n.length()-1)
                okay=true;
        }
        return okay;
    }

    public void cr(View v)
    {
        Intent in = new Intent(this,credits.class);
        startActivity(in);
    }
}
