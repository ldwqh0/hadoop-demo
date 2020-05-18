package com.dm.hadoop.test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;

public class TestFileSystem {

    @Test
    public void saveToHdfs() throws IOException, URISyntaxException, InterruptedException {
        try (FileSystem fs = getFs()) {
            fs.copyFromLocalFile(new Path("D:\\Users\\LiDong\\Downloads\\spark-2.4.5-bin-hadoop2.7.tgz"),
                    new Path("/test/spark-2.4.5-bin-hadoop2.7.tgz"));
        } catch (Exception e) {
            throw e;
        }

    }

    @Test
    public void readFromHdfs() {
        try (FileSystem fs = getFs()) {
            fs.copyToLocalFile(new Path("/test/spark-2.4.5-bin-hadoop2.7.tgz"),
                    new Path("D:\\rr\\spark-2.4.5-bin-hadoop2.7.tgz"));
        } catch (Exception e) {
        }
    }

    @Test
    public void writeStream() {
        try (FileSystem fs = getFs();
                FSDataOutputStream outputStream = fs.create(new Path("/test/good.txt"));
                OutputStreamWriter writer = new OutputStreamWriter(outputStream);) {
            writer.write("good good");
        } catch (Exception e) {

        }
    }

    private FileSystem getFs() throws IOException, InterruptedException, URISyntaxException {
        Configuration conf = new Configuration();
        // 使用hdfs api系统读写数据
        // 需要指定hdfs的协议和地址端口等
        return FileSystem.get(new URI("hdfs://dm105:9000"), conf, "hadoop");
        // 以下使用webhdfs读写文件
        // return FileSystem.get(new URI("webhdfs://ubuntu3:9870"), conf, "hadoop");
    }
}
