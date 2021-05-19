package com.androidbootcamp.newprojectbank.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.androidbootcamp.newprojectbank.R
import com.androidbootcamp.newprojectbank.data.accountRepository
import com.androidbootcamp.newprojectbank.viewmodel.AccountInfoViewModel

class AccountInfoActivity : AppCompatActivity() {

    private val textBalance by lazy {
        findViewById<TextView>(R.id.textview_balance_value)
    }
    private val document by lazy { intent.getStringExtra(KEY_DOCUMENT).toString() }

    private val viewmodel by viewModels<AccountInfoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_info)

        val btnSee = findViewById<Button>(R.id.btn_to_see)
        val btnExit = findViewById<Button>(R.id.btn_exit)

        viewmodel.initViewModel(document)
        toCompleteField()

        btnSee.setOnClickListener() { view ->
            isBalanceVisible(view)
        }

        btnExit.setOnClickListener() {
            toExit()
        }

    }

    private fun toCompleteField() {
        viewmodel.account?.let {
            val textName = findViewById<TextView>(R.id.textview_name_owner_account)
            textName.text = "Olá, ${it.name}!"
            if (viewmodel.seeBalance) {
                textBalance.text = it.balance.toString()
            } else {
                textBalance.text = "******"
            }
        }
    }

    private fun toExit() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun isBalanceVisible(view: View) {

        viewmodel.seeBalance = !viewmodel.seeBalance

        if (viewmodel.seeBalance) {
            textBalance.text = viewmodel.account?.balance.toString()
        } else {
            textBalance.text = "******"
        }

    }

    companion object {
        const val KEY_DOCUMENT = "Document"

        fun prepareIntent(context: Context, identifier: String): Intent {
            val intent = Intent(context, AccountInfoActivity::class.java).apply {
                putExtra(KEY_DOCUMENT, identifier)
            }

            return intent
        }

    }

}