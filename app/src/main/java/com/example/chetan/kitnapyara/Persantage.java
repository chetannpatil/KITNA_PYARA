package com.example.chetan.kitnapyara;

/**
 * Created by chetan on 5/1/17.
 */
public class Persantage {

    public static String strPercentage;

    public static int end;
    public static String getPersantage(int ia[])
    {
        end =ia.length-1;

        w:	while(end >= 2)
        {

            enLop:	for (int i = 0;i<end;i++)
            {

                if(   i >  (end-i))
                {
                    end = (i-1);

                    for(int p=0;p<=end;p++)
                    {
                    }
                    continue w;
                }
                if(   i == (end-i)  )
                {

                    end = i ;
                    for(int p=0;p<=end;p++)
                    {
                    }

                    continue w;

                }

                ia[i]= ia[i] + ia[end-i] ;

            }//for ends
        }
        //while ends

        //check if more than 9 in one char i f yes repeat while

        boolean b = Binary.isSingleDigitAray(ia);
        if(b)
        {
            strPercentage =ia[0]+""+ia[1]+"%";
        }
        else
        {
            //create new  tmprry array to check for singlecity
            int iaNew [] = new int [end+1];
            //copy value fro,ia to tmp array
            for(int p=0;p<=end;p++)
            {
                iaNew[p]=ia[p];
            }
            ia = Binary.splitToSigleDigitAray(iaNew);

            strPercentage = getPersantage(ia);
        }
        //returnig ia[]
        return strPercentage;
    }


}//end class
