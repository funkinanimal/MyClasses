package unittests;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Слава on 10.05.2017.
 */
class MyInt {

    private ArrayList<Integer> numbers = new ArrayList<>();

    MyInt(int value){
        while (value != 0)
        {
            numbers.add(value % 10);
            value /= 10;
        }
        Collections.reverse(numbers);//need this?
    }

    MyInt(String value) {
        for (int i = 0; i < value.length(); i++) {
            numbers.add(Character.getNumericValue(value.charAt(i)));
        }
    }

    MyInt(byte[] value) {
        for (int i = 0; i < value.length; i++) {
            numbers.add(new Byte(value[i]).intValue());
        }
    }
/*
    MyInt add(MyInt n) {

    }

    MyInt subtract(MyInt n) {

    }

    MyInt divide(MyInt n){

    }

    MyInt max (MyInt n) {

    }

    MyInt min (MyInt n) {

    }

    static MyInt abs (MyInt n) {

    }*/

    boolean compareTo(MyInt n) {

    }
/*
    MyInt gcd (MyInt n) {

    }
*/
    String ToString() {

        return null;
    }
/*
    long longValue(){

    }*/
}
