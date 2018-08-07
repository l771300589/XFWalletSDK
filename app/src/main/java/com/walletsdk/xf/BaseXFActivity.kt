@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.walletsdk.xf

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson

@SuppressLint("Registered")
abstract class BaseXFActivity: AppCompatActivity() {
    protected abstract fun callBackPay(data: PayBackModel)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        Log.i("tag", "onActivityResult1")
        if (resultCode === Activity.RESULT_OK && requestCode === 101) {
//            Log.i("tag", "被调用者返回的数据:$payCode")
            val payBackModel = PayBackModel()
            payBackModel.code = data?.getIntExtra("code",-1) //0:进行中 1：成功   2：取消    3：失败
            callBackPay(payBackModel)
        }
    }

    fun StartPay(payModel: PayModel) {
//        Log.d("跳转传送数据", Gson().toJson(payModel))
        val xfPay = XFPay(this, payModel)
        xfPay.skipWallet()
    }
}