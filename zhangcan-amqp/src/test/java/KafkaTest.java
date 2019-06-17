import com.google.common.collect.Maps;
import com.zc.base.SpringKafkaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.Map;

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

    @Autowired
    private AmqpTemplate amqpTemplate;

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
    /**
    *@author zhangcan
    *@Description 测试上传文件
    *@Date 20:32 2019/6/5
    *@Param []
    *@return void
    **/
/*    @Test
    public void testAmqp(){
        Map<String,Object> param = Maps.newHashMap();

        param.put("carId",2546);
        param.put("name","1231312313"+"_"+2416);
        Date date = new Date();
        Long times = date.getTime();
        param.put("eventTime",times);
        param.put("multimediaType",2);
        param.put("fileType","jpg");
        byte[] bts = new byte[]{1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
                ,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3};
        param.put("mdiaBytes",bts);
        amqpTemplate.convertAndSend("terminal_file_queue",param);
    }*/
    /**
    *@author zhangcan
    *@Description 测试报警下发
    *@Date 20:33 2019/6/5
    *@Param []
    *@return void
    **/
    @Test
    public void testWarn(){
        String s = "{\"latitude\":\"39.771202\",\"remark\":\"车辆围栏越界，请注意查看\",\"type\":11,\"speed\":0,\"fileOriginalName\":\"2725_21_20190605111224\",\"eventTime\":1559704340000,\"startTime\":\"11:12:20\",\"id\":49748,\"createDate\":\"2019-06-05 11:12:24\",\"longitude\":\"116.529319\",\"terminalNo\":\"13049990000000\",\"alarmNumber\":\"1559704358348\",\"passId\":0,\"attrList\":[{\"areaId\":505,\"id\":18,\"type\":1,\"direction\":1,\"carId\":2725}],\"versionCode\":\"5.0.0\",\"carId\":2725,\"location\":\"北京市大兴区北京经济技术开发区永昌南路康盛工业园\",\"subType\":21,\"isUpload\":2}";
        for (int i=0; i <5 ; i++) {
            amqpTemplate.convertAndSend("zc.warnning.message.queue",s);
        }
    }
    /**
    *@author zhangcan
    *@Description 测试多个for循环性能
    *@Date 13:42 2019/6/13
    *@Param []
    *@return void
    **/
    @Test
    public void testFor(){
        int a=0,b=0,c=0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i < 2000000; i++) {
            a++;
            b++;
            c++;
        }
        stopWatch.stop();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(stopWatch.prettyPrint());
    }
    /**
     *@author zhangcan
     *@Description 测试多个for循环性能   测试结论= for次数增加,会提高运行时间,建议减少for次数;
     *@Date 13:42 2019/6/13
     *@Param []
     *@return void
     **/
    @Test
    public void testFor1(){
        int a=0,b=0,c=0;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i < 2000000; i++) {
            a++;
        }
        for (int i=0; i < 2000000; i++) {
            b++;
        }
        for (int i=0; i < 2000000; i++) {
            c++;
        }
        stopWatch.stop();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(stopWatch.prettyPrint());
    }

    /**
    *@author zhangcan
    *@Description 测试 intValue
    *@Date 17:19 2019/6/14
    *@Param []
    *@return void
    **/
    @Test
    public void testValue(){
        Long a = 100L;
        Long b = 100L;
        System.out.println(a.intValue()==b.intValue());
        System.out.println(a==b);
        Long cache[] = new Long[-(-128) + 127 + 1];
        System.out.println(cache.length);
    }
}
