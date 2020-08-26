package com.example.chetan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chetan.kitnapyara.R;

public class Result extends Activity {

    public static TextView tvCompliment;
    public static TextView tvPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvCompliment =(TextView) findViewById(R.id.tvCompliment);
        tvPercentage = (TextView) findViewById(R.id.tvPercentage);

        Intent resIntent = getIntent();
        String resSA []= resIntent.getStringArrayExtra(Intent.EXTRA_TEXT);
        String perStr = resSA[0];
        String sentenceStr = resSA[1];



        String [] namesArray = sentenceStr.split(" ");
        String hunterName = namesArray[3];
        String destName = namesArray[8];

        try {
            String modifiedPerStr = perStr.substring(0,perStr.length()-1);
            int perInt = Integer.parseInt(modifiedPerStr);
            String complimentStr = getComplimentStr(perInt,hunterName,destName);
            tvPercentage.setText(perStr);
            tvCompliment.setText(complimentStr);

            Toast.makeText(this,"Courtesy :- CHETAN  PATIL",Toast.LENGTH_LONG).show();
            Toast.makeText(this,"All the best to "+hunterName+" & "+destName+" By CHETAN PATIL",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }


    }

    private static String getComplimentStr(int i,String hunterName,String destName)
    {
        String complimentStr="";
        StringBuilder sbHunter = new StringBuilder();
        StringBuilder sbDest = new StringBuilder();
        sbHunter.append(Character.toUpperCase(hunterName.charAt(0)));
        sbDest.append(Character.toUpperCase(destName.charAt(0)));
        if (hunterName.length()>1)
        {
                sbHunter.append(hunterName.substring(1,hunterName.length()));
        }
        if (destName.length() > 1)
        {
            sbDest.append(destName.substring(1,destName.length()));
        }

        hunterName = sbHunter.toString();
        destName = sbDest.toString();
        if(i>0 && i<= 15)
        {

            complimentStr="Not just this life, "+hunterName+" will never get "+destName+" in any of future lives .Best advise is just forget "+destName+" & search for some one else."
                    + " Very Sorry, I pity on "+hunterName+", TQ.";

        }
        else  if(i>15 && i<= 25)
        {
            complimentStr=hunterName+" will not get "+destName+" in this life. Sorry better luck for next life. TQ.";
        }
        else  if(i>25 && i< 35)
        {
            complimentStr=hunterName+" should better forget "+destName+" & search for some one else. Otherwise wait for next life, TQ.";
        }
        else  if(i>34 && i<= 45)
        {
            complimentStr="Very very less chances are there for "+hunterName+" to get married to "+destName+" .I will pray for you "+hunterName+" , TQ.";
        }
        else  if(i>45 && i<= 50)
        {
            complimentStr="Need little effort .Less chances are there for "+hunterName+" to get "+destName+". May Jesus help you.";
        }
        else  if(i>50 && i<= 55)
        {
            complimentStr="Chances are there for "+hunterName+" to get married to "+destName+" . Hope for the best .All the best "+hunterName+".";
        }
        else  if(i>55 && i<= 59)
        {

            complimentStr="Better chances are there. Do not worry "+hunterName+" you will get "+destName+". All the best.";
        }
        else  if(i>=60 && i<= 65)
        {
            complimentStr="Congratulations "+hunterName+". Very much possible to get married to "+destName+" Happy married life.";
        }
        else  if(i>65 && i<= 70)
        {
            complimentStr="Congratulations "+hunterName+". "+destName+" will be your spouse. Happy married life. All the best.";
        }
        else  if(i>70 && i<= 75)
        {
            complimentStr=hunterName+" & "+destName+" will be a great couple. Happy married life. Congratulations "+hunterName+".";
        }
        else  if(i>75 && i<= 80)
        {
            complimentStr=destName+" is born for you "+hunterName+". Congratulations "+hunterName+". Happy married life both of you.";
        }
        else  if(i>80 && i<= 85)
        {
            complimentStr="Congratulations "+hunterName+". "+destName+" is your soulmate for ever. Happy married life." +
                    " All the best.";
        }
        else  if(i>85 && i<= 90)
        {
            complimentStr="The pair "+hunterName+" & "+destName+" will be one of the best pairs in the world. Happy married life both of you.";
        }
        else  if(i>90 && i<= 94)
        {
            complimentStr=destName+" is "+hunterName+"'s spouse for this life & is fixed by Jesus. Just go and get "+destName+". All the best.";

        }
        else  if(i>94 && i<= 97)
        {
            complimentStr="Hmmmmmmm... "+destName+" will be "+hunterName+"'s spouse for all "+hunterName+"'s  upcoming lives. Happy married life."
                    + " & Congartulations "+hunterName;
        }
        else if (i==98)
        {
            complimentStr="Even Jesus can't separate "+destName+" from "+hunterName+". Congartulations "+hunterName+". Happy married life.";
        }
        else  if(i==99)
        {
            complimentStr="No need to test for chances at all "+destName+" will be "+hunterName+"'s spouse for all lives. Congartulations "+hunterName+
                    " & HAPPY MARRIED LIFE.";
        }
        else  if(i==100)
        {
            complimentStr="Marvelous, impossible become possible hmmmmm.";
        }
        return complimentStr;

    }



}
