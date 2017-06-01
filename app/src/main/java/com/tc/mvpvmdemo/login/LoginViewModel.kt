package com.tc.mvpvmdemo.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View

import com.tc.mvpvmdemo.BR

class LoginViewModel : BaseObservable() {

    @get:Bindable
    var btnText: String? = ""
        set(btnText) {
            field = btnText
            notifyPropertyChanged(BR.btnText)
        }

    @get:Bindable
    var btnClickListener: View.OnClickListener? = null
        set(btnClickListener) {
            field = btnClickListener
            notifyPropertyChanged(BR.btnClickListener)
        }

    @get:Bindable
    var userName: String? = ""
        set(userName) {
            field = userName
            notifyPropertyChanged(BR.userName)
        }

    @get:Bindable
    var password: String? = ""
        set(password) {
            field = password
            notifyPropertyChanged(BR.password)
        }
}
