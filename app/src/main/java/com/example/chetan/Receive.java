package com.example.chetan;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chetan.kitnapyara.Persantage;
import com.example.chetan.kitnapyara.R;

public class Receive extends Activity {

    public static EditText enterChoice;
    public static Button submitChoice;
    public static TextView tvBoyWGirl;
    public static TextView tvGirlWBoy;
    public static String bNameStr;
    public static String gNameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        enterChoice = (EditText) findViewById(R.id.etEnterOneRTwo);
        submitChoice = (Button) findViewById(R.id.btnSubmitChoice);
        tvBoyWGirl = (TextView) findViewById(R.id.tvBoyWedsGirl);
        tvGirlWBoy = (TextView) findViewById(R.id.tvGirlWedsBoy);
        Intent inRecv = getIntent();

        String saR[] = new String[2];
        saR=inRecv.getStringArrayExtra(Intent.EXTRA_TEXT);
        bNameStr = saR[0];
        gNameStr = saR[1];
        tvBoyWGirl.setText("1 . "+bNameStr+" WEDS "+gNameStr+" 's % ?");
        tvGirlWBoy.setText("2 . "+gNameStr+" WEDS "+bNameStr+" 's % ?");

    }

    @Override
    protected void onResume() {
        super.onResume();
        enterChoice.setText("");
    }

    public void submitChoice(View v)
    {

        try
        {
            if (enterChoice.getText()==null || enterChoice.getText().toString().length()==0)
                throw new IllegalArgumentException("AAPKO KUCH ENTER KARNA PADEGA, KRIPAYA 1 OR 2 ENTER KEEJIYE TQ");
            int choiceInt = Integer.parseInt(enterChoice.getText().toString());
           boolean choiceOkay= validateChoice(choiceInt);
            if(choiceOkay==true)
            {
                int count=1;
                String strCoupled ="";
                if (choiceInt==1)
                     strCoupled = bNameStr.trim()+"weds"+gNameStr.trim();
                else
                     strCoupled = gNameStr.trim()+"weds"+bNameStr.trim();
                 //after taking 1 /  2

                char ca[] = strCoupled.toCharArray();

                //define one int array to hold all lettrs numbr of ocuurnces

                int ia [] = new int [ca.length];

                outer: for (int i=0;i<strCoupled.length();i++)
                {
                    if(i==strCoupled.length()-1)
                    {
                        if(ca[i]=='1')
                            break;
                        ia[i] = count;
                    }
                    if(ca[i]=='1')
                    {
                        continue outer;
                    }
                    inner:for (int k=i+1 ; k<strCoupled.length();k++)
                    {
                        //check is It alredy visited value of K?
                        if(ca[k]=='1')
                        {
                            if(k==strCoupled.length()-1)
                            {
                                ia[i]=count;
                                continue outer;
                            }
                            else
                            {
                                continue inner;
                            }
                        }
                        //checkig is it end of k?
                        if(k==strCoupled.length()-1)
                        {
                            if(ca[i]==ca[k])
                            {
                                count++;
                                ca[k]='1';
                            }
                            ia[i]=count;
                            count = 1;
                            continue outer;
                        }
                        else
                        {
                            if(ca[i]==ca[k])
                            {
                                count++;
                                ca[k]='1';
                            }
                        }
                    }
                    //end innerFor

                }
                //end ouerFor

                //firt line iof int of intarray

                //skipping 0zerod elemnts
                int intZeroCount=0;
                for(int m=0;m<ia.length;m++)
                {
                    if(ia[m]==0)
                        intZeroCount++;

                }

                //create new intArray to hole new only letterd nmbrs
                int ia2[] = new int [ia.length-intZeroCount];


                //copy paste ia value to ia2 by removing zeros from ia
                for(int t = 0,u=0; t<ia.length ; t++)
                {
                    if(ia[t] != 0)
                        ia2[u++]=ia[t];
                }
               // calclulate %
               // call get% method of Persantage class
                String persantageStr = Persantage.getPersantage(ia2);
                String sentencePersantageStr="";
                if(choiceInt==1)
                    sentencePersantageStr="The chances for "+bNameStr+" to get married to "+gNameStr+" is "+persantageStr+" All the Best";
                else
                    sentencePersantageStr="The chances for "+gNameStr+" to get married to "+bNameStr+" is "+persantageStr+" All the Best";


                Intent in = new Intent(this,Result.class);
                //create arry to pass with intnent
                String resStrArray[]= {persantageStr,sentencePersantageStr};
                in.putExtra(Intent.EXTRA_TEXT,resStrArray);
                startActivity(in);

            }

        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }


    }

    private static boolean validateChoice(int c)
    {

        if (c != 1 && c != 2)
            throw new IllegalArgumentException("TUMHARE PASS SIRF DO OPTIONS HAI, 1 YA 2, TQ");
        else
            return true;

    }
}
