package com.example.agritrader.models

class User {
    var email: String = ""
    var pass: String = ""
    var userid: String = ""

    constructor(email: String, pass: String, userid: String){
        this.email=email
        this.pass=pass
        this.userid=userid
    }
    constructor()
}