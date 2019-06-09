package com.alekseysamoylov.javavskotlin;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CollectionsJava {

    public static void timingTest(List<Credit> credits) {
        long start = System.nanoTime();
        List<Credit> filteredCredits = filterAndSortExample(credits);
        long finish = System.nanoTime();
        long timeElapsed = (finish - start) / 1000;
        System.out.println("Java: filter and sort time " + timeElapsed + " milliseconds");
        start = System.nanoTime();
        Map<User, List<Credit>> mappedCredits = mapCreditsByUsers(credits);
        finish = System.nanoTime();
        timeElapsed = (finish - start) / 1000;
        System.out.println("Java: group by time " + timeElapsed + " milliseconds");
    }

    public static List<Credit> createRandomCreditList() {
        return LongStream.range(1, 3000)
                .mapToObj(CreditTestFactory::createRandomCredit).collect(Collectors.toList());
    }

    private static List<Credit> filterAndSortExample(List<Credit> credits) {
        return credits.stream()
                .filter(i -> BigDecimal.valueOf(200).compareTo(i.getAmount()) > 0)
                .sorted(Comparator.comparing(Credit::getAmount))
                .collect(Collectors.toList());
    }

    private static Map<User, List<Credit>> mapCreditsByUsers(List<Credit> credits) {
        return credits.stream().collect(Collectors.groupingBy(Credit::getUser));
    }
}
