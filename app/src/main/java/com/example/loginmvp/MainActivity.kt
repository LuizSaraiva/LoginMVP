package com.example.loginmvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var loginInput: TextInputLayout
    lateinit var password: TextInputLayout
    lateinit var btnLogin: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginInput = findViewById(R.id.il_user)
        password = findViewById(R.id.il_pass)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val login = loginInput.editText?.text.toString()
            val pass = password.editText?.text.toString()


            if (login.isEmpty() || pass.isEmpty()) {
                loginInput.setError("An error occur while trying to log in")
                password.setError("An error occur while trying to log in")
            } else {
                if (login == "luiz" && pass.toInt() == 123) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    loginInput.setError("An error occur while trying to log in")
                    password.setError("An error occur while trying to log in")
                }
            }
        }
    }
}