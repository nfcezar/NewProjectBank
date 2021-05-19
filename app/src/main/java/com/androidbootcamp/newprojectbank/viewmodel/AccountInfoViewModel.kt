package com.androidbootcamp.newprojectbank.viewmodel

import androidx.lifecycle.ViewModel
import com.androidbootcamp.newprojectbank.conta.Account
import com.androidbootcamp.newprojectbank.data.accountRepository

class AccountInfoViewModel() : ViewModel() {
    var seeBalance: Boolean = false

    var account: Account? = null

    fun initViewModel(document: String) {
        if (account == null) {
            account = accountRepository.getAccountData(document)
        }
    }
}
