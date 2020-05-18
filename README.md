这是一个简单的，特别简单的hadoop测试项目

## 准备工作
* clone项目 ,假设在windows cmd命令模式下，并且你的电脑中存在d:符号
```bash
d:
git clone git@github.com:ldwqh0/hadoop-demo.git 或者
git clone https://github.com/ldwqh0/hadoop-demo.git
```
* 将项目导入到IDE
* 修改项目中的配置，hadoop相关的配置分别在每个测试类中
* 执行单元测试代码
* hadoop-win是hadoop中windows需要的依赖，如果你不想在本地部署完整的hadoop环境，可以直接使用该包
* 也可以使用maven执行测试代码
```bash
# 测试指定的方法
mvn clean test -Dtest=com.dm.hadoop.test.TestFileSystem#readFromHdfs -Dhadoop.home.dir="D:\hadoop-demo\hadoop-win" 
```

## 说明
### 关于环境变量
在实际开发中，可以使用HADOOP_HOME环境变量 也可以使用 -Dhadoop.home.dir="/path"的程序变量来指定hadoop目录

在eclipse中，可以修改debug configuration 指定java虚拟机参数，-Dhadoop.home.dir指向hadoop-win目录