package com.alekseysamoylov.javavskotlin

import java.math.BigDecimal


class Credit private constructor(builder: Builder) {
    var id: Long = 0
        private set
    var user: User
    var amount: BigDecimal = BigDecimal.ZERO
        private set
    var type: CreditType? = null
        private set

    init {
        this.id = builder.id
        this.user = builder.user
        this.amount = builder.amount
        this.type = builder.type
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Credit
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Credit(id=$id, user=$user, amount=$amount, type=$type)"
    }

    class Builder(private val newUser: User) {
        var id: Long = 0
            private set
        var user: User = User(newUser.getId(), newUser.getName())
            private set
        var amount: BigDecimal = BigDecimal.ZERO
            private set
        var type: CreditType? = CreditType.MONTH
            private set

        fun id(id: Long) = apply { this.id = id }
        fun amount(amount: BigDecimal) = apply { this.amount = amount }
        fun type(type: CreditType) = apply { this.type = type }
        fun build() = Credit(this)
    }
}
