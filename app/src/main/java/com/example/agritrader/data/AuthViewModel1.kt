package com.example.agritrader.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.agritrader.models.Buyer
import com.example.agritrader.navigation.ROUTE_HOME
import com.example.agritrader.navigation.ROUTE_HOME2
import com.example.agritrader.navigation.ROUTE_LOGIN
import com.example.agritrader.navigation.ROUTE_LOGIN2
import com.example.agritrader.navigation.ROUTE_PHOME
import com.example.agritrader.navigation.ROUTE_REGISTER
import com.example.agritrader.navigation.ROUTE_REGISTER2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel1(var navController: NavHostController, var context: Context){

    var mAuth1: FirebaseAuth = FirebaseAuth.getInstance()
    var progress:ProgressDialog

    init {
        progress=ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait.....")
    }
    fun signup(email:String,pass:String,confpass:String){
        //progress.show()

        if (email.isBlank() || pass.isBlank() ||confpass.isBlank()){
            //progress.dismiss()
            Toast.makeText(context,"Please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth1.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){
                    val userData= Buyer(email,pass,mAuth1.currentUser!!.uid)
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Buyer/"+mAuth1.currentUser!!.uid)
                    regRef.setValue(userData).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_HOME2)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_REGISTER2)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_REGISTER2)
                }

            }
        }
    }
    fun login1(email: String,pass: String){
        progress.show()

        mAuth1.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME2)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN2)
            }
        }
    }
    fun logout(){
        mAuth1.signOut()
        navController.navigate(ROUTE_PHOME)
    }
    fun isloggedin1():Boolean{
        return mAuth1.currentUser !=null
    }

}