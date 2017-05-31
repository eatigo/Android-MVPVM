package com.tc.mvpvmdemo.userinfo

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class UserInfoModel : Serializable {
    /**
     * head : string
     * headBackground : string
     * name : string
     * sex : int 1:男 2:女
     * nationality : int 1:中国 2:美国
     * specialty : string
     * advantage : string
     * createTime : long
     */

    @SerializedName("head")
    var head: String? = null
    @SerializedName("headBackground")
    var headBackground: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("sex")
    var sex: Int = 0
    @SerializedName("nationality")
    var nationality: Int = 0
    @SerializedName("specialty")
    var specialty: String? = null
    @SerializedName("advantage")
    var advantage: String? = null
    @SerializedName("createTime")
    var createTime: Long = 0
}
