package unittests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class MyInt {

    private List<Integer> numbers = new ArrayList<>();
    private final boolean minus;

    MyInt(long value){

        minus = value < 0;

        while (value != 0)
        {
            numbers.add((int)Math.abs(value % 10));//TODO make this abs later
            value /= 10;
        }

        Collections.reverse(numbers);
        numbers = Collections.unmodifiableList(numbers);
    }

    MyInt(String value) {

        minus = value.charAt(0) == '-';

        for ( int i = minus ? 1 : 0; i < value.length(); i++) {
            numbers.add(Character.getNumericValue(value.charAt(i)));
        }

        numbers = Collections.unmodifiableList(numbers);
    }

    MyInt(byte[] value) {

        minus = value[0] == 1;

        for (int i = 1; i < value.length; i++) {
            numbers.add(new Byte(value[i]).intValue());
        }

        numbers = Collections.unmodifiableList(numbers);
    }


    MyInt add(MyInt n) {
        String n1, n2;
        boolean s1 = true, s2 = true;
        n1 = toString();
        n2 = n.toString();

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
        boolean nIsGreater = false;

        n1 = toString();
        n2 = n.toString();


        if (compareTo(n)) {
            return new MyInt(0);
        }
        else if (n.isGreater(this)){
            String buf = n1;
            n1 = n2;
            n2 = buf;
            nIsGreater = true;
        }

        int dif = n1.length() - n2.length();
        StringBuilder zero = new StringBuilder();
        for (int i = 0; i < dif; i++)
            zero.append("0");

        n2 = zero.toString() + n2;

        boolean buf = false;
        StringBuilder out = new StringBuilder();

        for (int i = n1.length() - 1; i >= 0; i--)
        {
            int d1, d2;
            d1 = Character.getNumericValue(n1.charAt(i));
            d2 = Character.getNumericValue(n2.charAt(i));

            if (buf)
            {
                d1--;
                buf = false;
            }

            if (d1 >= d2)
            {
                out.append(d1 - d2);
            }
            else
            {
                out.append(10 + d1 - d2);
                buf = true;
            }
        }

        out = out.reverse();
        String ans = out.toString();

        while (ans.charAt(0) == '0')
            ans = ans.substring(1);

        if (nIsGreater)
            ans = "-" + ans;

        return new MyInt(ans);
    }

/*
    MyInt divide(MyInt n){

    }

    MyInt max (MyInt n) {

    }

    MyInt min (MyInt n) {

    }

    static MyInt abs (MyInt n) {

    }

    MyInt gcd (MyInt n) {

    }

    long longValue(){

    }
*/

    boolean compareTo(MyInt n) {
        return n.toString().equals(toString());
    }

    boolean isGreater(MyInt n)
    {
        if(isMinus() ^ n.isMinus())
        {
            return n.isMinus();
        }
        else if (toString().length() == n.toString().length())
        {
            for (int i = 0; i < toString().length(); i++)
            {
                int n1 = Character.getNumericValue(toString().charAt(i));
                int n2 = Character.getNumericValue(n.toString().charAt(i));
                if (n1 != n2)
                    return n1 > n2;
            }
            return true;//unreachable
        }
        else
            return toString().length() > n.toString().length();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(minus ? "-" : "");
        for (int number : numbers) {
            res.append(String.valueOf(number));
        }
        return res.toString();
    }

    boolean isMinus() {return minus;}

}
