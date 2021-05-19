package com.androidbootcamp.newprojectbank.data

import com.androidbootcamp.newprojectbank.conta.Account
import com.androidbootcamp.newprojectbank.conta.LegalPersonAccount
import com.androidbootcamp.newprojectbank.conta.PersonAccount

//singleton
object accountRepository {
    private val accountlist = listOf<Account>(
        PersonAccount("Natalia", 1_000_000f, "123"),
        PersonAccount("Carlos", 500_000f, "456"),
        PersonAccount("Vitor", 1_000_000f, "789"),
        LegalPersonAccount("CN&V", 10_000_000f, "1111"),
        LegalPersonAccount("Ota Celulares", 1_000f, "222")

    )

    fun accountExists(identifier: String): Boolean {
        return getAccountData(identifier) != null
    }

    fun getAccountData(identfier: String): Account? {
        return accountlist.firstOrNull { it.identifier == identfier }
    }

}