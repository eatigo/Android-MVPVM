package com.tc.mvpvmdemo.login

import android.os.Handler
import android.view.View

class LoginPresenter(private val mView: ILogin.IView, private val mViewModel: LoginViewModel) : ILogin.IPresenter {

    override fun onViewInit() {
        mView.updateTitle("登录")
        mViewModel.btnText = "sign in"
        mViewModel.btnClickListener = View.OnClickListener {
            val userName = mViewModel.userName
            val password = mViewModel.password
            login(userName!!, password!!)
        }
    }

    private fun login(userName: String, password: String) {
        mView.showDialog("正在登陆\nuserName:$userName\npassword:$password")
        //不建议这么用Handler，这里只是模拟网络请求的延迟
        Handler().postDelayed({
            mView.closeDialog()
            mView.showToast("登陆成功")
            mView.jumpToUserInfo()
        }, 2000)
    }
}
