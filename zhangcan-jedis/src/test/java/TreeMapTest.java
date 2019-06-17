import net.minidev.json.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: zhangcan
 * @Date: 2019/3/6 11:59
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TreeMapTest {

    @Test
    public void testTreeMap(){
        TreeMap<String,String> adviceContentMaps=new TreeMap<>();
        adviceContentMaps.put("1","我是");
        adviceContentMaps.put("0","你是");
        System.out.println(JSONObject.toJSONString(adviceContentMaps));
    }

    @Test
    public void testMap(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,0);
        Date date = calendar.getTime();
        System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(date));
    }

    @Test
    public void testAdd(){
        Long c=1L;
        for (int i=0; i < 5; i++) {
            //System.out.println(c++);
            System.out.println(String.format("{%s}", i));
        }
    }
    public Boolean checkTime(String time){
        //正则校验格式是否正确
        // HH:mm:ss
        String regEx = "[0-9]{2}:[0-9]{2}:[0-9]{2}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        Matcher matcher = pattern.matcher(time);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        return rs;
    }
    @Test
    public void checkTimeTest() throws ParseException {
        String s = "01:01:01";
        System.out.println(checkTime(s));
        String s1 = "HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s1);
        System.out.println(simpleDateFormat.parse(s));
    }

    @Test
    public void testChar(){
        char[] numbers = new char[]{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
        numbers[15]='1';
        numbers[14]='1';
        numbers[13]='1';
        numbers[12]='1';
        numbers[11]='1';
        numbers[8]='1';
        Integer result = 0;
        int count = 0;
        for(int i=numbers.length-1;i>=0;i--){
            if(numbers[i]=='1')result+=(int)Math.pow(2, count);
            count++;
        }
        System.out.println(result);

    }
    /**
    *@author zhangcan
    *@Description 测试16进制  
    *@Date 14:43 2019/5/28
    *@Param []
    *@return void
    **/
    @Test
    public void test16Byte(){

        int d = 0x11;
        System.out.println(d);

    }

    @Test
    public void testByte(){
        byte a = 127;
        int b = 0x11;
        byte c = 0x1F;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

}
