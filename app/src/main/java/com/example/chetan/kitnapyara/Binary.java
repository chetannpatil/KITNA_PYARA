package com.example.chetan.kitnapyara;

/**
 * Created by chetan on 5/1/17.
 */
public class Binary {

    public static boolean isSingleDigitAray(int ia[])
    {

        for (int i =0;i<ia.length;i++)
        {
            if(ia[i]>9)
                return false;
        }
        return true;
    }
    public static int [] splitToSigleDigitAray(int ia[])
    {
        String s1 = "";
        for (int k=0;k<ia.length;k++)
        {
            s1=s1+ia[k];
        }
        //adding ti charct array
        char ca[] = s1.trim().toCharArray();
        //define ia2 [] to hold int values of ca ,with length same as ca[]
        int ia2 [] = new int [ca.length];

        for (int k=0;k<ca.length;k++)
        {
            int z = ca[k];

            switch (z)
            {
                case 48:	ia2[k] = 0;
                                     break;
                case 49:

                    ia2[k] = 1;break;
                case 50:

                    ia2[k] = 2;break;
                case 51:
                           ia2[k] = 3;break;
                case 52:

                    ia2[k] = 4;break;

                case 53:

                    ia2[k] = 5;break;
                case 54:

                    ia2[k] = 6;break;
                case 55:

                    ia2[k] = 7;break;
                case 56:

                    ia2[k] = 8;break;
                case 57:

                    ia2[k] = 9;break;

                default:
                            break;
            }
            //swicth ends

        }
        //for ends

        return ia2;
    }

}//class ends
