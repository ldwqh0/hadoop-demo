package com.dm.hbase.demo;

import java.io.IOException;
import java.util.Collections;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DdlTest {

    private Connection connection;

    @Test
    public void createTable() throws IOException {
        Admin admin = connection.getAdmin();
        // 定义一个表
        TableDescriptorBuilder builder = TableDescriptorBuilder
                // :前面是命名空间
                .newBuilder(TableName.valueOf("lidong:dm_region_"));
        // 构建一个列族
        ColumnFamilyDescriptor desc = ColumnFamilyDescriptorBuilder.of("columns");
        builder.setColumnFamilies(Collections.singleton(desc));
        // 创建表
        admin.createTable(builder.build());
    }

    @Test
    public void dropTable() throws IOException {
        Admin admin = connection.getAdmin();
        admin.disableTable(TableName.valueOf("t1"));
        admin.deleteTable(TableName.valueOf("t1"));
    }

    @BeforeEach
    public void getConnection() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "dm106:2181");
        this.connection = ConnectionFactory.createConnection(conf);
    }

    @AfterEach
    public void close() {
        try {
            this.connection.close();
        } catch (IOException e) {
        }
    }
}
