# XFWalletSDK使用简介
基于Kotlin实现，调用XF钱包的SDK
## 仓库依赖

Maven：
```Java
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
</repositories>

<dependency>
	<groupId>com.github.lcaifu</groupId>
	<artifactId>XFWalletSDK</artifactId>
	<version>0.0.1</version>
</dependency>
```
Gradle：
```Java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

dependencies {
	        implementation 'com.github.lcaifu:XFWalletSDK:0.0.1'
	}
```
