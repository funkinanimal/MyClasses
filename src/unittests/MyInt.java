package unittests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class MyInt {

    private List<Integer> numbers = new ArrayList<>();
    private final boolean minus;
    private final int amount;

    MyInt(long value){

        minus = value < 0;
        int count = 0;
        while (value != 0)
        {
            numbers.add((int)Math.abs(value % 10));
            value /= 10;
            count++;
        }

        amount = count;
        numbers = Collections.unmodifiableList(numbers);
    }

    MyInt(String value) {

        minus = value.charAt(0) == '-';
        amount = minus ? value.length() - 1 : value.length();
        int last = minus ? 1 : 0;

        for ( int i = value.length() - 1; i >= last; i--) {
            numbers.add(Character.getNumericValue(value.charAt(i)));
        }

        numbers = Collections.unmodifiableList(numbers);
    }

    MyInt(byte[] value) {

        minus = value[0] == 1;
        amount = value.length - 1;

        for (int i = value.length - 1; i >= 0; i--) {
            numbers.add(new Byte(value[i]).intValue());
        }

        numbers = Collections.unmodifiableList(numbers);
    }

    private MyInt(MyInt n ) {
        this.minus = n.minus;
        this.amount = n.amount;
        this.numbers = n.numbers;
    }

    MyInt add(MyInt n) {

        if (this.minus != n.minus) {
            if (this.minus)
                return n.subtract(MyInt.abs(this));
            else
                return this.subtract(MyInt.abs(n));
        }
        else {
            int lim = MyInt.min(this, n).amount;
            StringBuilder out = new StringBuilder();
            int buf = 0;
            for (int i = 0; i < lim; i++){
                int now = this.numbers.get(i) + n.numbers.get(i) + buf;
                out.append(now % 10);
                buf = now / 10;
            }
            if (buf != 0)
            {
                if (this.amount > n.amount)
                    out.append(buf + this.numbers.get(lim));
                else if (this.amount < n.amount)
                    out.append(buf + n.numbers.get(lim));
                else
                    out.append(buf);
            }

            String ans = out.reverse().toString();

            while (ans.charAt(0) == '0')
                ans = ans.substring(1);

            if (minus)
                ans = "-" + ans;

            return new MyInt(ans);
        }

    }

    MyInt subtract(MyInt n) {

        if (this.minus != n.minus) {

            if (this.minus)
                return new MyInt("-" + MyInt.abs(this).add(n).toString());
            else
                return this.add(MyInt.abs(n));

        }
        else {
            if (minus)
                return new MyInt("-" + MyInt.abs(this).add(MyInt.abs(n)).toString());
            else {
                if (this.compareTo(n) == 0)
                    return new MyInt(0);

                if (this.compareTo(n) < 0)
                    return new MyInt("-" + n.subtract(this).toString());
                else {

                    int lim = MyInt.min(this, n).amount;
                    StringBuilder out = new StringBuilder();
                    int buf = 0;
                    for (int i = 0; i < lim; i++) {
                        buf = this.numbers.get(i) - n.numbers.get(i) - buf;
                        out.append((buf + 10) % 10);
                        buf = buf < 0 ? 1 : 0;
                    }

                    if (buf != 0)
                    {
                        int q = lim;
                        int now = this.numbers.get(q);
                        while (now == 0) {
                            q++;
                            now = this.numbers.get(q);
                        }
                        out.append(now - buf);
                    }

                    String ans = out.reverse().toString();

                    while (ans.charAt(0) == '0')
                        ans = ans.substring(1);

                    return new MyInt(ans);
                }
            }
        }
    }

    static MyInt max (MyInt n1, MyInt n2) {
        if (n1.compareTo(n2) > 0)
            return new MyInt(n1);
        else
            return new MyInt(n2);
    }

    static MyInt min (MyInt n1, MyInt n2) {
        if (n1.compareTo(n2) < 0)
            return new MyInt(n1);
        else
            return new MyInt(n2);
    }

    static MyInt abs (MyInt n) {
        if (!n.minus)
            return new MyInt(n);
        else
            return new MyInt(n.toString().substring(1));
    }

    int compareTo(MyInt n)
    {
        int ans = 0;
        if (this.amount == n.amount)
        {
            String s1 = this.toString(), s2 = n.toString();
            for (int i = 0; i < this.amount; i++)
            {
                int d1, d2;
                d1 = Character.getNumericValue(s1.charAt(i));
                d2 = Character.getNumericValue(s2.charAt(i));
                if (d1 > d2)
                {
                    ans = 1;
                }
                if (d1 < d2)
                {
                    ans = -1;
                }
            }
        }
        else {
            if (this.amount > n.amount){
                ans = 1;
            }
            if (this.amount < n.amount) {
                ans = -1;
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(minus ? "-" : "");
        for (int i = amount - 1; i >= 0; i--) {
            res.append(String.valueOf(numbers.get(i)));
        }
        return res.toString();
    }

}
