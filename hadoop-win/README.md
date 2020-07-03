## 备注
如果在windows环境下调试hadoop程序，需要如下步骤
1. 将hadoop.dll复制的 %windir%\system32目录下
2. 如果hadoop集群不在本地，将HADOOP_HOME指定到该目录，或者在运行时使用JVM参数-Dhadoop.home.dir={path}的方式，指定到该目录。