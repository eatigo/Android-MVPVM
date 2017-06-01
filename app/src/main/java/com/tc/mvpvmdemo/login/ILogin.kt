package com.tc.mvpvmdemo.login

interface ILogin {
    interface IView {

        fun updateTitle(title: String) //更新页面title

        fun showToast(content: String) //显示toast

        fun showDialog(content: String) //显示弹窗

        fun closeDialog() //关闭弹窗

        fun jumpToUserInfo() //跳转到用户信息页面

        fun getMyTitle(): String
    }

    interface IPresenter {
        fun onViewInit()
    }
}
