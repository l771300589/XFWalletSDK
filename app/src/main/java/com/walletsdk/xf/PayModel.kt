package com.walletsdk.xf

/**
 * 转账数据模型
 */
class PayModel {
    var order = "转账"//转账类型-单号，选填
    var toAddress = ""//转入地址, 必填
//    var formAddress = ""//付款钱包
    var gwei = 10.0//矿工单价，选填
    var gasLimit = 25200//矿工费总数量，选填
    var money = ""//转账金额, 必填
    var inputData = ""//输入的数据，十六进制，选填
}