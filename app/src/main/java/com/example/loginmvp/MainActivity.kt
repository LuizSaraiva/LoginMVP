package com.example.loginmvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginmvp.mvp.LoginContract
import com.example.loginmvp.mvp.LoginPresenter
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), LoginContract.View{

    lateinit var loginInput: TextInputLayout
    lateinit var passwordInput: TextInputLayout
    lateinit var btnLogin: MaterialButton

    override lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter(this)

        presenter.start()

        btnLogin.setOnClickListener {
            presenter.isLoginValid(loginInput.editText?.text.toString(),passwordInput.editText?.text.toString())
        }
    }

    override fun displayErrorMessage() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
        loginInput.editText?.setError("Login Failed")
        passwordInput.editText?.setError("Login Failed")
    }

    override fun displaySuccessMessage() {
        Toast.makeText(this, "Success",Toast.LENGTH_LONG).show()
    }

    override fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
    override fun bindViews() {
        loginInput = findViewById(R.id.il_user)
        passwordInput = findViewById(R.id.il_pass)
        btnLogin = findViewById(R.id.btnLogin)
    }
}