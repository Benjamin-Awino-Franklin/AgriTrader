package com.example.agritrader.models

class Buyer {
    var name: String = ""
    var email: String = ""
    var pass: String = ""
    var userid: String = ""

    constructor(name: String,email: String, pass: String,){
        this.name=name
        this.email=email
        this.pass=pass
    }

    constructor()

}