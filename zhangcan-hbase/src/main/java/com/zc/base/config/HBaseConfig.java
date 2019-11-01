package com.zc.base.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;

/**
 * @Auther: zhangcan
 * @Date: 2019/2/27 12:51
 * @Description:
 */
@Configuration
@EnableConfigurationProperties(HBaseProperties.class)
public class HBaseConfig {
    private final HBaseProperties properties;

    public HBaseConfig(HBaseProperties properties) {
        this.properties = properties;
    }

/*    @Bean
    public HbaseTemplate hbaseTemplate() {
        HbaseTemplate hbaseTemplate =new HbaseTemplate();
        try {
            org.apache.hadoop.conf.Configuration configuration = configuration();
            hbaseTemplate.setConfiguration(configuration);
            hbaseTemplate.setAutoFlush(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hbaseTemplate;
    }*/


    @Bean
    public org.apache.hadoop.conf.Configuration configuration() {

        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();

        Map<String, String> config = properties.getConfig();
        Set<String> keySet = config.keySet();
        for (String key : keySet) {
            System.out.println(key+"加载配置文件="+config.get(key));
            configuration.set(key, config.get(key));
        }
        return configuration;
    }
}
