package com.alekseysamoylov.javavskotlin

import java.math.BigDecimal
import java.util.stream.LongStream
import kotlin.streams.toList
import kotlin.system.measureNanoTime


class CollectionsKotlin {

    companion object {

        @JvmStatic
        fun timingTest(credits: List<Credit>) {
            val filterListTime = measureNanoTime { filterAndSortExample(credits) } / 1000
            println("Kotlin: filter and sort time $filterListTime milliseconds")
            val listToMapTime = measureNanoTime { mapCreditsByUsers(credits) } / 1000
            println("Kotlin group by time $listToMapTime milliseconds")
        }

        @JvmStatic
        fun createRandomCreditList(): List<Credit> = LongStream.range(1, 30001)
            .mapToObj<Credit> { CreditTestFactory.createRandomCredit(it) }.toList()

        private fun filterAndSortExample(credits: List<Credit>): List<Credit> {
            return credits.asSequence()
                .filter { i -> BigDecimal.valueOf(200) > i.amount }
                .sortedBy { it.amount }
                .toList()
        }

        private fun mapCreditsByUsers(credits: List<Credit>): MutableMap<User, MutableList<Credit>> {
            return credits.asSequence().groupByTo(mutableMapOf()) { it.user }

        }
    }
}
