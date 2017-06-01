package com.tc.mvpvmdemo.userinfo

import android.os.Handler

import com.tc.mvpvmdemo.R

import java.text.SimpleDateFormat
import java.util.Date

class UserInfoPresenter(private val mView: IUserInfo.IView, private val mViewModel: UserInfoViewModel) : IUserInfo.IPresenter {

    override fun onViewInit() {
        mView.updateTitle("用户信息")
        requestData()
    }

    private fun mockTrump(): UserInfoModel {
        val trump = UserInfoModel()
        trump.head = "xxx.jpg"
        trump.headBackground = "xxxx.jpg"
        trump.name = "川普"
        trump.nationality = 2
        trump.sex = 1
        trump.specialty = "表情包"
        trump.advantage = "漂亮的女儿"
        trump.createTime = System.currentTimeMillis()
        return trump
    }

    private fun requestData() {
        mView.showDialog("正在获取数据")
        //不建议这么用Handler，这里只是模拟网络请求的延迟
        Handler().postDelayed({
            mView.closeDialog()
            updateUi(mockTrump())
        }, 2000)
    }

    private fun updateUi(model: UserInfoModel) {
        mViewModel.name = model.name
        mViewModel.headImageRes = R.mipmap.ic_head
        mViewModel.headBackgroundRes = R.mipmap.bg_trump
        val sex: String
        when (model.sex) {
            1 -> sex = "男"
            2 -> sex = "女"
            else -> sex = "不详"
        }
        mViewModel.sex = sex
        val nationality: String
        when (model.nationality) {
            1 -> nationality = "中国"
            2 -> nationality = "美国"
            else -> nationality = "地球"
        }
        mViewModel.nationality = nationality
        mViewModel.advantage = model.advantage
        mViewModel.specialty = model.specialty
        mViewModel.advantage = model.advantage
        mViewModel.createTime = SimpleDateFormat("yyyy.MM.dd HH:mm").format(Date(model.createTime))

    }
}