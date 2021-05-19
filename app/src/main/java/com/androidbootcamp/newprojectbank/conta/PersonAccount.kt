package com.androidbootcamp.newprojectbank.conta

class PersonAccount(personName: String, personBalance: Float, val identifierCpf: String) :
    Account(personName, personBalance, identifierCpf) {
}