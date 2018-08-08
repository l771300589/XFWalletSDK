# XFWalletSDK使用简介
基于Kotlin实现，调用XF钱包的SDK
## 仓库依赖

Maven：
```Java
<dependency>
	<groupId>com.github.lcaifu</groupId>
	<artifactId>XFWalletSDK</artifactId>
	<version>0.0.1</version>
</dependency>
```
Gradle：
```Java
implementation 'com.github.lcaifu:XFWalletSDK:0.0.1'
```
## PayModel详解
|   属性名  |   字段类型  |  是否必填  |     介绍    |
| ------------ |:--------------:|:-------------:| ------------:|
|   order     |     String     |        否      |    转账类型-单号等类似内容(默认“转账”)    |
| toAddress|     String     |        是     |  转入地址（收款方） |
| gwei|     Double |        否      |  矿工单价 |
| gasLimit|     Double |        否      |  矿工费(gwei)总数量 |
| money|     String     |        是     |  转账金额 |
| inputData|     String     |        否      |  输入的数据(十六进制) |
