# XFWalletSDK使用简介
基于Kotlin实现，调用XF钱包的SDK
## 仓库依赖

Maven：
```Java
<dependency>
	<groupId>com.github.lcaifu</groupId>
	<artifactId>XFWalletSDK</artifactId>
	<version>0.0.4</version>
</dependency>
```
Gradle：
```Java
implementation 'com.github.lcaifu:XFWalletSDK:0.0.4'
```
## 使用方法
1. 继承"BaseXFActivity()"类。<br>
2. 实现接口"callBackPay()"，用于接收交易完成后的返回值。
```kotlin
override fun callBackPay(data: PayBackModel) {
        Log.i("XFTestActivity", "返回的状态"+data.code)
    }
```
3. 调用支付方法"StartPay()"发起交易
```kotlin
home_skip.setOnClickListener {
            val payModel = PayModel()
            payModel.order = "转账" //转账类型-单号等类似内容(默认“转账”), 选填
            payModel.toAddress = "0xfff39c790f072c360ca243e0c742a8dd51396c5c"//转入地址（收款方）, 必填
            payModel.gwei = 10.0//矿工单价, 选填
            payModel.gasLimit = 25200//矿工费(gwei)总数量, 选填
            payModel.money = "0.005"//转账金额, 必填
            payModel.inputData = ""//输入的数据(十六进制), 选填
            StartPay(payModel)
        }
```
## PayModel详解
进行交易时需要传递到XF钱包的参数模型类<br>
|   属性名  |   字段类型  |  是否必填  |     介绍    |
