package com.wixsite.mupbam1.resume.newfirebase

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    private var mDataBase: DatabaseReference? = null
    val USER_KEY:String = "USER"
    var edNm: EditText? = null
    var edCmpn: EditText? = null
    var edEml: EditText? = null
    var saveBtn:TextView? = null
    var readBtn:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init(){
        edNm = findViewById(R.id.edName)
        edCmpn = findViewById(R.id.edCompany)
        edEml = findViewById(R.id.edEmail)
        saveBtn = findViewById(R.id.saveButton)
        readBtn = findViewById(R.id.readButton)
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY)

    }
    fun onClickSave (view: View){
        var id = mDataBase?.getKey()
        var name = edNm?.text.toString()
        var company = edCmpn?.text.toString()
        var email = edEml?.text.toString()
        var newUser = User(id, name, company, email)
        if (email != ""){
            mDataBase?.push()?.setValue(newUser)
            Toast.makeText(this, "Saved sucsessful.", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Enter your email for a best connection, please.", Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickRead (view: View){

    }


}


