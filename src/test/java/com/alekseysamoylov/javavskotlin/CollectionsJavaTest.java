package com.alekseysamoylov.javavskotlin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class CollectionsJavaTest {

    @Test
    void timingTest() {
        List<Credit> credits = CollectionsKotlin.createRandomCreditList();
        CollectionsKotlin.timingTest(credits);
        CollectionsJava.timingTest(credits);
        Assertions.assertEquals(credits.size(), 30000);
    }
}
