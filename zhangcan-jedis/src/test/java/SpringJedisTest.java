import com.zc.base.SpringJedisApplication;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;

/**
 * @Auther: zhangcan
 * @Date: 2019/2/28 14:56
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringJedisApplication.class)
public class SpringJedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() throws InterruptedException {
        //redisTemplate.opsForValue().set("zhangcan","dddd");
        while (true){
            try {
                System.out.println(redisTemplate.opsForValue().get("zhangcan"));
                Collection<RedisServer> collections = redisTemplate.getConnectionFactory().getSentinelConnection().masters();
                collections.forEach(s->{
                    System.out.println("集群大小="+s.getQuorum());
                });
                Thread.sleep(2000);

            }catch (Exception e){
                System.out.println("进入第二次尝试！！！！！！！！！！！！！！！！！！！！！");
                Thread.sleep(5000);
                System.out.println(redisTemplate.opsForValue().get("zhangcan"));
                Collection<RedisServer> collections = redisTemplate.getConnectionFactory().getSentinelConnection().masters();
                collections.forEach(s->{
                    System.out.println("集群大小="+s.getQuorum());
                });
                Thread.sleep(2000);
            }
        }
    }
}
