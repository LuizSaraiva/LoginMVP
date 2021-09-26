package com.example.loginmvp.mvp

import android.content.Intent
import com.example.loginmvp.HomeActivity

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter{
    override fun start() {
        view.bindViews()
    }

    override fun isLoginValid(userName: String, password: String) {
        if (userName.isEmpty() || password.isEmpty()) {
            view.displayErrorMessage()
        } else {
            if (userName == "luiz" && password.toInt() == 123) {
                view.displaySuccessMessage()
                view.startHomeActivity()
            } else {
                view.displayErrorMessage()
            }
        }
    }
}