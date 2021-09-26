package com.example.loginmvp.mvp

interface LoginContract {

    interface View: BaseView<LoginPresenter>{
        fun displayErrorMessage()
        fun displaySuccessMessage()
        fun startHomeActivity()
    }

    interface Presenter : BasePresenter{
        fun isLoginValid(userName: String, password : String)
    }

}