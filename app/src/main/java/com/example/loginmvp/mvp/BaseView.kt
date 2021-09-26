package com.example.loginmvp.mvp

interface BaseView<T>{
    var presenter : T
    fun bindViews()
}