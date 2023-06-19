package org.example;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
        double a = 10;
        double b = 2;
        double del = 0.00000000000000000000000000001;
        @Test
        public void divideResultTest(){
                double exp = 5.0;
            double act = Main.divideResult(a,b);
                Assert.assertEquals(exp, act, del);
        }

        @Test
        public void multiResultTest(){
                double exp = 20.0;
                double act = Main.multiResult(a,b);
                Assert.assertEquals(exp, act, del);
        }

        @Test
        public void subtractResultTest(){
                double exp = 8.0;
                double act = Main.subtractResult(a,b);
                Assert.assertEquals(exp, act, del);
        }

        @Test
        public void sumResultTest(){
                double exp = 12.0;
                double act = Main.sumResult(a,b);
                Assert.assertEquals(exp, act, del);
        }

        @Test
        public void isQTest(){
                boolean act = Main.isQ("q");
                boolean exp = true;
                Assert.assertEquals(exp, act);
        }
}
