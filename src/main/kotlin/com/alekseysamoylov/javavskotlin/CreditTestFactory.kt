package com.alekseysamoylov.javavskotlin

import java.math.BigDecimal
import java.util.concurrent.ThreadLocalRandom


class CreditTestFactory {

    companion object {
        private var idCount = 0L
        private fun getAmount(i: Long = 1) = BigDecimal.valueOf(i * 100)
        private fun getUser(i: Long = 0) = User(getCount(), "UserName ${getCount(i)}")
        private fun getCreditType(i: Long = 0): CreditType = if (getCount(i) % 2L == 0L) {
            CreditType.MONTH
        } else {
            CreditType.WEEK
        }

        private fun getCount(i: Long = 0): Long {
            return if (i == 0L) {
                idCount++
            } else {
                i
            }
        }

        @JvmStatic
        fun createRandomCredit(i: Long = 0): Credit {
            return Credit.Builder(getUser(i))
                .id(getCount(i))
                .amount(getAmount(i))
                .type(getCreditType(i))
                .build()
        }
    }
}
