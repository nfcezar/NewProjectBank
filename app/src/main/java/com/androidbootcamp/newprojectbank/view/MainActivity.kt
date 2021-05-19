package com.androidbootcamp.newprojectbank.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidbootcamp.newprojectbank.R
import com.androidbootcamp.newprojectbank.data.accountRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setClickListener()

    }

    private fun setClickListener() {
        var btnEnter = findViewById<Button>(R.id.btn_enter)
        btnEnter.setOnClickListener() {
            onBtnClick()
        }

    }

    private fun startNavegation(identifier: String) {
        val intent = AccountInfoActivity.prepareIntent(this, identifier)

        startActivity(intent)
        finish()
    }

    private fun onBtnClick() {

        var edtId = findViewById<TextView>(R.id.edittext_idenficator)
        val identifier = edtId.text.toString()
        val validIdenfier = accountRepository.accountExists(identifier)

        if (validIdenfier) {
            startNavegation(identifier)
        } else {
            Toast.makeText(this, "Please, provide me a valid identifier!", Toast.LENGTH_LONG).show()
        }


    }

}