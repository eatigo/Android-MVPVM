package com.tc.mvpvmdemo.login

import android.app.ProgressDialog
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import com.tc.mvpvmdemo.R
import com.tc.mvpvmdemo.databinding.ActivityLoginBinding
import com.tc.mvpvmdemo.userinfo.UserInfoActivity

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), ILogin.IView {

    internal var binding: ActivityLoginBinding? = null
    internal var presenter: LoginPresenter? = null
    internal var dialosg: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        val viewModel = LoginViewModel()
        presenter = LoginPresenter(this, viewModel)
        binding?.viewModel = viewModel
        presenter?.onViewInit()
    }

    override fun updateTitle(title: String) {
        this.title = title
    }

    override fun showToast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }

    override fun showDialog(content: String) {
        if (dialosg == null) {
            dialosg = ProgressDialog(this)
        }
        dialosg!!.setMessage(content)
        dialosg!!.show()
    }

    override fun closeDialog() {
        if (dialosg != null && dialosg!!.isShowing) {
            dialosg!!.hide()
        }
    }

    override fun jumpToUserInfo() {
        val intent = Intent(this, UserInfoActivity::class.java)
        startActivity(intent)
    }

    override fun getMyTitle(): String {
        return ""
    }
}
