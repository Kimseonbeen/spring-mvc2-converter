package hello.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.stereotype.Controller;

import javax.swing.text.NumberFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        Number result = formatter.parse("1,000", Locale.KOREA);
        assertThat(result).isEqualTo(1000L);

    }

    @Test
    void print() {
        String result = formatter.print(1000, Locale.KOREA);
        assertThat(result).isEqualTo("1,000");
    }

    interface Addable {
        int add(int a, int b);
    }

    interface MyInterface1 {
        public void method(int a, int b);
    }

    interface MyInterface2 {
        public void method(int a);
    }


    @Test
    void geric() {
        Addable ad1 = new Addable() {
            public int add(int a , int b) {
                return ( a + b);
            }
        };
        System.out.println(ad1.add(100,200));

        Addable ad2 = (int a, int b) -> {
            return ( a + b);
        };
        System.out.println(ad2.add(10, 20));

        Addable ad3 = (a, b) -> a + b;
        System.out.println(ad3.add(1,2));
    }

    @Test
    void interfaceTest() {
        MyInterface1 f1, f2, f3;
        MyInterface2 f4, f5;

        f1 = (int a, int b) -> System.out.println(a + b);
        f1.method(3, 4);
        f2 = (a, b) -> System.out.println(a + b);
        f2.method(5, 6);
        f3 = (a, b) -> System.out.println(a + b);
        f3.method(7, 8);

        f4 = (int a ) -> System.out.println("a = " + a);
        f4.method(9);
        f5 = a -> System.out.println("a = " + a);
        f5.method(10);
    }

    @Test
    void letTest() {
        List<Object> objects = new ArrayList<>();

        MyInterface1 f1;

    }
}