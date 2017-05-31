package com.tc.mvpvmdemo.userinfo

import android.databinding.BaseObservable
import android.databinding.Bindable

import com.tc.mvpvmdemo.BR

class UserInfoViewModel : BaseObservable() {

    @get:Bindable
    var headBackgroundRes: Int = 0
        set(headBackgroundRes) {
            field = headBackgroundRes
            notifyPropertyChanged(BR.headBackgroundRes)
        }
    @get:Bindable
    var headImageRes: Int = 0
        set(headImageRes) {
            field = headImageRes
            notifyPropertyChanged(BR.headImageRes)
        }
    @get:Bindable
    var name: String? = null
        set(name) {
            field = name
            notifyPropertyChanged(BR.name)
        }
    @get:Bindable
    var sex: String? = null
        set(sex) {
            field = sex
            notifyPropertyChanged(BR.sex)
        }
    @get:Bindable
    var nationality: String? = null
        set(nationality) {
            field = nationality
            notifyPropertyChanged(BR.nationality)
        }
    @get:Bindable
    var specialty: String? = null
        set(specialty) {
            field = specialty
            notifyPropertyChanged(BR.specialty)
        }
    @get:Bindable
    var advantage: String? = null
        set(advantage) {
            field = advantage
            notifyPropertyChanged(BR.advantage)
        }
    @get:Bindable
    var createTime: String? = null
        set(createTime) {
            field = createTime
            notifyPropertyChanged(BR.createTime)
        }
}
