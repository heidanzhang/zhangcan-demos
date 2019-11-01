package com.zc.base.repository;



import com.zc.base.entity.GpsBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @Auther: zhangcan
 * @Date: 2019/10/31 16:25
 * @Description:
 */
public interface GpsRepository extends ElasticsearchRepository<GpsBean, String> {

}
