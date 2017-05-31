package com.tc.mvpvmdemo.userinfo

interface IUserInfo {
    interface IView {
        fun updateTitle(title: String) //更新页面title

        fun showDialog(content: String) //显示弹窗

        fun closeDialog() //关闭弹窗
    }

    interface IPresenter {
        fun onViewInit()
    }
}