package com.androidbootcamp.newprojectbank.conta

fun main() {

    val accountJohn = Account("John", 2000f)
    val accountMary = Account("Mary", 100f)

    //Operations
    accountJohn.deposit(3000f)
    accountMary.withdraw(-50f)
    accountJohn.transfer(accountMary, 50f)
    accountJohn.zeroBalance(accountJohn)

    //Prints
    accountJohn.balancePrint(accountJohn)
    accountMary.balancePrint(accountMary)

}