package com.zc.hdfs;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @Auther: zhangcan
 * @Date: 2020/5/26 16:07
 * @Description:
 */
@SpringBootApplication
@Slf4j
public class HdfsApplication {


    public static void main(String[] args){
        //1获取hdfs客户端对象
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS","hdfs://one.bigdata.com:9000");
        try {
            log.info("hdfs开始");
            FileSystem fileSystem = FileSystem.get(configuration);
            fileSystem.mkdirs(new Path("/0526/dashen"));
            fileSystem.close();
            log.info("hdfs结束");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("hdfs异常");
        }

    }
}
