package com.tc.mvpvmdemo

import android.view.View
import com.nhaarman.mockito_kotlin.*
import com.tc.mvpvmdemo.login.ILogin
import com.tc.mvpvmdemo.login.LoginPresenter
import com.tc.mvpvmdemo.login.LoginViewModel
import org.amshove.kluent.shouldEqualTo
import org.amshove.kluent.shouldNotBe
import org.junit.Before
import org.junit.Test

class LoginPresenterUnitTest {

    private val view: ILogin.IView = mock()
    private val button: View = mock()
    private val viewModel: LoginViewModel = LoginViewModel()
    private val loginPresenter: LoginPresenter = LoginPresenter(view, viewModel)

    @Before
    fun setUp() {

    }

    @Test
    fun loginWhenNotInput() {
        loginPresenter.onViewInit()
        verify(view).updateTitle("登录")
        viewModel.btnClickListener shouldNotBe null

        whenever(view.getMyTitle()) doReturn "new"

        view.getMyTitle() shouldEqualTo "new"

        viewModel.btnClickListener?.onClick(button)

        verify(view).showDialog(any())

        viewModel.userName = "name"
        viewModel.password = "pass"

        viewModel.password shouldEqualTo "pass"
        viewModel.userName shouldEqualTo "name"
    }
}
