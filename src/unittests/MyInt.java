package unittests;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Слава on 10.05.2017.
 */
class MyInt {

    private ArrayList<Integer> numbers = new ArrayList<>();
    private boolean minus;

    MyInt(int value){

        minus = value < 0;

        while (value != 0)
        {
            numbers.add(Math.abs(value % 10));
            value /= 10;
        }

        Collections.reverse(numbers);
    }

    MyInt(String value) {

        minus = Integer.valueOf(value) < 0;

        for ( int i = minus ? 1 : 0; i < value.length(); i++) {
            numbers.add(Character.getNumericValue(value.charAt(i)));
        }

    }

    MyInt(byte[] value) {

        minus = value[0] == 1;

        for (int i = 1; i < value.length; i++) {
            numbers.add(new Byte(value[i]).intValue());
        }
    }

    public boolean isMinus() {return minus;}

    MyInt add(MyInt n) {
        String n1, n2;
        boolean s1 = true, s2 = true;
        n1 = ToString();
        n2 = n.ToString();

        if (n1.charAt(0) == '-')
        {
            s1 = false;
            n1 = n1.substring(1);
        }
        if (n2.charAt(0) == '-')
        {
            s2 = false;
            n2 = n2.substring(1);
        }

        int max = Math.max(n1.length(), n2.length());
        int buf = 0;
        ArrayList<Integer> out = new ArrayList<>();

        for (int i = max - 1; i >= 0; i--)
        {
            int now1 = 0, now2 = 0;
            if (i <  n1.length())
            {
                now1 = Character.getNumericValue( n1.charAt(i) );
            }
            if (i < n2.length())
            {
                now2 = Character.getNumericValue( n2.charAt(i) );
            }
            int ans = now1 + now2 + buf;
            if (ans > 9)
            {
                buf = (ans - (ans % 10)) / 10;
                out.add(ans % 10);
            }
            else
            {
                out.add(ans);
            }
        }

        if (buf != 0)
            out.add(buf);

        Collections.reverse(out);

        String res = s1^s2 ? "-" : "";
        for (int st:out) {
            res += String.valueOf(st);
        }

        return new MyInt(res);
    }

    MyInt subtract(MyInt n) {
        String n1, n2;
        n1 = ToString();
        n2 = n.ToString();

        if (compareTo(n))
            return new MyInt(0);
        else if (isGreater(n)){
            String buf = n1;
            n1 = n2;
            n2 = buf;
        }

        for (int i = n1.length() - 1; i >= 0; i--)
        {
            int d1, d2;
            d1 = Character.getNumericValue(n1.charAt(i));
            if (i < n2.length())
            {

            }
        }

        return new MyInt(1);
    }
/*
   MyInt divide(MyInt n){

    }

    MyInt max (MyInt n) {

    }

    MyInt min (MyInt n) {

    }
*/
    private boolean isGreater(MyInt n)
    {
        if(isMinus() ^ n.isMinus())
        {
            return isMinus();
        }
        else if (ToString().length() == n.ToString().length())
        {
            for (int i = 0; i < ToString().length(); i++)
            {
                int n1 = Character.getNumericValue(ToString().charAt(i));
                int n2 = Character.getNumericValue(n.ToString().charAt(i));
                if (n1 != n2)
                    return n2 > n1;
            }
            return true;
        }
        else
            return ToString().length() < n.ToString().length();
    }

  /*  static MyInt abs (MyInt n) {

    }*/

    boolean compareTo(MyInt n) {
        return n.ToString().equals(ToString());
    }
/*
    MyInt gcd (MyInt n) {

    }
*/
    String ToString() {
        String res = minus ? "-" : "";
        for (int st:numbers) {
            res += String.valueOf(st);
        }
        return res;
    }
/*
    long longValue(){

    }*/
}
