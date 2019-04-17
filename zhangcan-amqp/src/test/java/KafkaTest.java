import com.zc.base.SpringKafkaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @Auther: zhangcan
 * @Date: 2019/2/21 18:23
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringKafkaApplication.class)
public class KafkaTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public  void test02(){
        System.out.println("********************************dd");
    }


    @Test
    public void test01(){
        String message = "asdfa";
        ListenableFuture future = kafkaTemplate.send("zhangcan-topic",message);
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message), throwable -> System.out.println("消息发送失败：" + message));
    }

}
