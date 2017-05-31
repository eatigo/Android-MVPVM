package com.tc.mvpvmdemo.userinfo

import android.app.ProgressDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.tc.mvpvmdemo.R
import com.tc.mvpvmdemo.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity(), IUserInfo.IView {

    internal var binding: ActivityUserInfoBinding? = null
    internal var presenter: UserInfoPresenter? = null
    internal var dialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityUserInfoBinding>(this, R.layout.activity_user_info)
        val viewModel = UserInfoViewModel()
        presenter = UserInfoPresenter(this, viewModel)
        binding!!.viewModel = viewModel
        presenter!!.onViewInit()
    }

    override fun updateTitle(title: String) {
        this.title = title
    }

    override fun showDialog(content: String) {
        if (dialog == null) {
            dialog = ProgressDialog(this)
        }
        dialog!!.setMessage(content)
        dialog!!.show()
    }

    override fun closeDialog() {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }
}
