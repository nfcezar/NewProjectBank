package com.androidbootcamp.newprojectbank.conta

fun main() {

    val accountJohn = PersonAccount("John", 2000f, "111.111.111-X")
    val accountMary = PersonAccount("Mary", 100f, "222.222.222-0")

    val legalpersonaccountMary =
        LegalPersonAccount("Mary Company of Beauty", 200_000f, "555.555.555/0001-55")
    val legalpersonaccountJohn = LegalPersonAccount("John's Pub", 1_000_000f, "666.666.666/0001-6")

    //Operations
    /*accountJohn.deposit(3000f)
    accountMary.withdraw(-50f)
    accountJohn.transfer(accountMary, 50f)
    accountJohn.zeroBalance(accountJohn)*/

    legalpersonaccountJohn.deposit(300_000f)
    legalpersonaccountMary.withdraw(-50f)
    legalpersonaccountJohn.transfer(accountMary, 50_000f)
    legalpersonaccountJohn.zeroBalance(accountJohn)




    //Prints
    accountJohn.balancePrint(accountJohn)
    accountMary.balancePrint(accountMary)
    legalpersonaccountJohn.balancePrint(legalpersonaccountJohn)
    legalpersonaccountMary.balancePrint(legalpersonaccountMary)

    Account.imprimeNomeBanco()
}