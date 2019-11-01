import com.alibaba.fastjson.JSONObject;
import com.zc.base.SpringElasticsearchApplication;
import com.zc.base.entity.GpsBean;
import com.zc.base.repository.GpsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Auther: zhangcan
 * @Date: 2019/10/31 19:40
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringElasticsearchApplication.class)
public class TestSpringDataElasticsearch {

    @Autowired
    private GpsRepository gpsRepository;

    @Test
    public void testFind(){
        System.out.println("=======================");
        Iterable<GpsBean> iterables = gpsRepository.findAll();
        iterables.forEach(t->{
            System.out.println(JSONObject.toJSONString(t));
        });
    }
}
