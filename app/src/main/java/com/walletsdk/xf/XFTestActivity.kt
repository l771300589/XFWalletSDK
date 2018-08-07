@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.walletsdk.xf

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.walletsdk.xf.xfwalletsdk.R
import kotlinx.android.synthetic.main.xf_activity_test.*


class XFTestActivity : BaseXFActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.xf_activity_test)


        home_skip.setOnClickListener {
            val payModel = PayModel()
            payModel.order = "跳转转账"
            payModel.toAddress = "0xfff39c790f072c360ca243e0c742a8dd51396c5c"
//        jsonData.formAddress = walletData.address
//        jsonData.gwei = 10.0
//        jsonData.gasLimit = 25200
            payModel.money = "0.005"
            payModel.inputData = ""
            StartPay(payModel)
        }

    }

    override fun callBackPay(data: PayBackModel) {
        Log.i("回调数据", data.code.toString())
        refreshData(data.code)
    }

    fun refreshData(getCode: Int?) {
        when (getCode) {
            0 -> {
                //进行中
                home_value.text = "进行中"
            }
            1 -> {
                //成功
                home_value.text = "成功"
            }
            2 -> {
                //取消
                home_value.text = "取消"
            }
            3 -> {
                //失败
                home_value.text = "失败"
            }
            else -> {
                //其它
                home_value.text = "其它"
            }
        }
    }

}
