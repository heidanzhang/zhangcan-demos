package com.zc.base.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @Auther: zhangcan
 * @Date: 2019/10/31 16:18
 * @Description:
 */
@Document(indexName = "gps", type = "_doc")
@Data
public class GpsBean {

    private String type;
    @Id
    private String rowKey;

    private Long carId;

    private Double slatitude;

    private Double slongitude;

    private Date time;

    private Long warnId;//报警id

    private Double speed;//速度

    private Double direction;//方向

    private Double during_time;//时长

    private Double during_mileage;//里程
}
