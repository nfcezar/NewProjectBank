package com.androidbootcamp.newprojectbank.conta

class Account(val name: String, var balance: Float) {

    fun deposit(amount: Float, paymentVoucher: Boolean = true) {
        val canIDeposit = amount > 0
        if (canIDeposit) {
            this.balance += amount
        }
        val messageStatus = if (canIDeposit) "Success" else "Failed"
        paymentVoucher(paymentVoucher, OperationType.DEPOSIT, amount, messageStatus)

    }

    fun withdraw(amount: Float, paymentVoucher: Boolean = true): Boolean {
        val canIWithdraw = amount > 0 && this.balance >= amount
        if (canIWithdraw) {
            this.balance -= amount
        }

        val messageStatus = if (canIWithdraw) "Success" else "Failed"
        paymentVoucher(paymentVoucher, OperationType.WITHDRAW, amount, messageStatus)
        return canIWithdraw
    }

    fun transfer(
        accountDest: Account,
        amount: Float,
        paymentVoucher: Boolean = true
    ) {
        val canITransfer = this.withdraw(amount, false)
        if (canITransfer) {
            accountDest.deposit(amount, false)
        }
        val messageStatus = if (canITransfer) "Success" else "Failed"
        paymentVoucher(paymentVoucher, OperationType.TRANSFER, amount,messageStatus)
    }

    fun balancePrint(account: Account) {
        val paymentVoucher: Boolean = true
        paymentVoucher(paymentVoucher, OperationType.BALANCE, account.balance)
    }

    fun zeroBalance(account: Account, paymentVoucher: Boolean = true) {
        account.balance = 0.0f
        paymentVoucher(paymentVoucher, OperationType.ZERO_BALANCE, account.balance)
    }

    private fun paymentVoucher(
        paymentVoucher: Boolean,
        operationType: OperationType,
        value: Float, messageStatus: String = ""
    ) {
        if (paymentVoucher) {
            when (operationType) {
                OperationType.WITHDRAW
                -> println("${messageStatus}: withdraw operations finished. Value of: $value")
                OperationType.BALANCE
                -> println("Your current balance is: $value")
                OperationType.DEPOSIT
                -> println("${messageStatus}: deposit operations finished! Value of: $value")
                OperationType.TRANSFER
                -> println("${messageStatus}: transfer operations finished. Value of: $value")
                OperationType.ZERO_BALANCE
                -> println("Your balance is empty. Value of: $value")
            }
        }
    }
}


/*if (paymentVoucher) {
            val messageStatus = if (canIDeposit) "Success" else "Failed"
            println("${messageStatus}: deposit operations finished!")*/