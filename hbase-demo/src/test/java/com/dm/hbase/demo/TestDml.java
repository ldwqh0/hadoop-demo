package com.dm.hbase.demo;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDml {
    private Connection connection;

    @Test
    public void listAll() throws IOException {
//        Table table = connection.getTable(TableName.valueOf("lidong:dm_region_"));
    };

    /**
     * 新增/保存数据
     * 
     * @throws IOException
     */
    @Test
    public void saveData() throws IOException {
        try (Table table = connection.getTable(TableName.valueOf("lidong:dm_region_"))) {
            Put put = new Put(Bytes.toBytes("_001"));
            byte[] family = Bytes.toBytes("columns");
            put.addColumn(family, Bytes.toBytes("code_"), Bytes.toBytes("1233333"));
            put.addColumn(family, Bytes.toBytes("money"), Bytes.toBytes(123));
            table.put(put);
        } catch (Exception e) {
        }
    }

    /**
     * 根据键名获取数据
     */
    @Test
    public void getData() {
        try (Table table = connection.getTable(TableName.valueOf("lidong:dm_region_"))) {
            Get get = new Get(Bytes.toBytes("_001"));
            Result result = table.get(get);
            byte[] bytes = result.getValue(Bytes.toBytes("columns"), Bytes.toBytes("code_"));
            System.out.println(Bytes.toString(bytes));
        } catch (Exception e) {
        }
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
