package unittests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class MyInt {

    final static MyInt ZERO = new MyInt("0");
    final static MyInt ONE = new MyInt("1");

    private List<Integer> numbers = new ArrayList<>();
    private final boolean minus;
    private final int amount;

    MyInt(long value){

        minus = value < 0;
        int count = 0;

        if (value == 0) {
            numbers.add(0);
            count++;
        }

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
                {
                    int now;
                    while (true) {

                        now = this.numbers.get(lim);
                        lim++;

                        if (now != 9)
                            break;

                        out.append(0);
                    }
                    out.append(now + buf);
                }
                else if (this.amount < n.amount) {
                    int now;
                    while (true) {

                        now = n.numbers.get(lim);
                        lim++;

                        if (now != 9)
                            break;

                        out.append(0);
                    }
                    out.append(now + buf);
                }
                else
                    out.append(buf);

            }

            if (lim < this.amount)
                out.append(new StringBuilder(this.toString().substring(0, this.amount - lim)).reverse());
            if (lim < n.amount)
                out.append(new StringBuilder(n.toString().substring(0 ,n.amount - lim)).reverse());

            String ans = out.reverse().toString();

            if (!ans.equals("0"))
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
                        int now;
                        while (true) {

                            now = this.numbers.get(lim);
                            lim++;

                            if (now != 0)
                                break;

                            out.append(9);
                        }
                        out.append(now - buf);
                    }

                    if (lim < this.amount)
                        out.append(new StringBuilder(this.toString().substring(0, this.amount - lim )).reverse());
                    if (lim < n.amount)
                        out.append(new StringBuilder(n.toString().substring(0 ,n.amount - lim )).reverse());

                    String ans = out.reverse().toString();

                    if (!ans.equals("0"))
                        while (ans.charAt(0) == '0')
                            ans = ans.substring(1);

                    return new MyInt(ans);
                }
            }
        }
    }

    MyInt multiply (MyInt n) {

        if (this.compareTo(MyInt.ZERO) == 0 || n.compareTo(MyInt.ZERO) == 0)
            return MyInt.ZERO;

        if(this.minus && !n.minus) {
            return new MyInt("-" + MyInt.abs(this).multiply(n).toString());
        }

        if (!this.minus && n.minus) {
            return new MyInt("-" + this.multiply(MyInt.abs(n)).toString());
        }

        if (this.minus) {
            return new MyInt(MyInt.abs(this).multiply(MyInt.abs(n)));
        }

        MyInt ans = MyInt.ZERO;

        for (int i = 0; i < n.amount; i++) {
            MyInt now = this.multiply(n.numbers.get(i));
            StringBuilder temp = new StringBuilder(now.toString());
            for (int j = 0; j < i; j++) {
                temp.append("0");
            }
            ans = ans.add(new MyInt(temp.toString()));
        }

        return new MyInt(ans);
    }

    private MyInt multiply (int n) {

        int buf = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < this.amount; i++) {
            int now = this.numbers.get(i) * n + buf;
            out.append(now % 10);
            buf = now / 10;
        }

        if (buf != 0)
            out.append(buf);

        return new MyInt(out.reverse().toString());
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
                    break;
                }
                if (d1 < d2)
                {
                    ans = -1;
                    break;
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

    MyInt gcd(MyInt n) {

        String s1 = this.toString();
        if (s1.equals("0"))
            return n;
        String s2 = n.toString();
        if (s2.equals("0"))
            return this;

        while (!s1.equals(s2))
        {
            MyInt a = MyInt.abs(new MyInt(s1));
            MyInt b = MyInt.abs(new MyInt(s2));

            if (a.compareTo(b) > 0) {
                s1 = a.subtract(b).toString();
            }
            else {
                s2 = b.subtract(a).toString();
            }
        }

        return new MyInt(s1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(minus ? "-" : "");
        for (int i = amount - 1; i >= 0; i--) {
            res.append(String.valueOf(numbers.get(i)));
        }
        return res.toString();
    }

    long longValue() {

        long q = 0;
        for(int i = amount - 1; i >= 0; i--) {
            long now = numbers.get(i) * (long)Math.pow(10, i);
            long free = Long.MAX_VALUE - q;
            if (now < free)
                q += now;
            else
                q += free;
        }

        return q * (minus ? -1 : 1);
    }
}
