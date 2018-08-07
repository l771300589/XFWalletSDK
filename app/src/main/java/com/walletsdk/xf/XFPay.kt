package com.walletsdk.xf

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson


class XFPay(private val activity: Activity, private var data: PayModel) {

    /**
     * 跳转支付钱包
     */
    @SuppressLint("WrongConstant")
    fun skipWallet() {
        if (isAvilible(activity, "com.wallet.cf")) {
//            Toast.makeText(this, "已经安装", Toast.LENGTH_SHORT).show()
            //要调用另一个APP的activity所在的包名
            val packageName = "com.wallet.cf"
            //要调用另一个APP的activity名字
            val activityName = "com.wallet.cf.SkipActivity"
            val component = ComponentName(packageName, activityName)
            val skipIntent = Intent()
            skipIntent.component = component
            skipIntent.flags = 101
            skipIntent.putExtra("data", Gson().toJson(data))
            skipIntent.putExtra("packageName", activity.packageName)
            skipIntent.putExtra("activityName", activity.javaClass.name)
//            skipIntent.putExtra("data", "传过去了一堆数据，给我打开吧，巴啦啦魔力变身。")
//            context.startActivity(skipIntent)
            activity.startActivityForResult(skipIntent, 101)

        } else {
            //未安装，跳转至market下载该程序
            Toast.makeText(activity, "未安装XF钱包", Toast.LENGTH_SHORT).show()
//                val uri = Uri.parse("market://details?id=com.tencent.mm")
            // 直接从指定网址下载
//            val uri = Uri.parse("http://dldir1.qq.com/foxmail/weixin521android400.apk")
//            val intent = Intent(Intent.ACTION_VIEW, uri)
//            activity.startActivity(intent)
        }
    }

    /**
     * 判断是否已经安装支付钱包
     */
    private fun isAvilible(context: Context, packageName: String): Boolean {
        val packageManager = context.packageManager
        // 获取所有已安装程序的包信息
        val pinfo = packageManager.getInstalledPackages(0)
        pinfo.forEach {
            if (it.packageName == packageName) {
                Log.d("xfWallet", "已安装" + it.packageName)
                return true
            }
        }
        Log.d("xfWallet", "未安装xf钱包")
        return false
    }

}