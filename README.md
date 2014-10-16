jasper_sample
=============

JasperReports-iReport 报表


###PDF 中文乱码解决方法

设置为宋体，英文显示重叠了。如下方法可设置任何字体。

1. 在系统字体中找到黑体或者宋体 ttf文件

2. iReport 中设置-》Fonts-》install Font  导入刚刚找到的ttf

3. 导入后，在 iReport 的安装目录中找到 font 文件夹夹，执行jar cf simfang_heiti.jar * 打成 jar 包

4. 将 此jar 设置为iReport的 classpath ，然后在 font 中勾选此 jar，iReport模板设置中即可看到此字体

5. web 或者项目中导入 该jar即PDF 正常显示中文字体
