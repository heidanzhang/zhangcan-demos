import com.google.common.primitives.UnsignedInts;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Test
    public void testTime(){
        Long second = 61L;

        StringBuffer stringBuffer = new StringBuffer();

        long day=0,hour=0,minute=0;

        day = second/(3600*24);
        if(day>=1){
            hour = (second-day*3600*24)/3600;
        }else{
            hour = second/3600;
        }
        minute = (second-day*3600*24-hour*3600)/60;

        if(day>=1){
            stringBuffer.append(day+"天");
        }if(hour>=1){
            stringBuffer.append(hour+"时");
        }if(minute>=1){
            stringBuffer.append(minute+"分");
        }
        System.out.println(stringBuffer.toString());
    }

    @Test
    public void testFor(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        for(int a = list.size()-1; a>=1; a--){
            int i = a;
            System.out.println(i);
        }
    }
    @Test
    public void testUnsignedInt(){
        Integer notReallyInt = UnsignedInts.parseUnsignedInt("4294967294");
        System.out.println(notReallyInt);
        String s =  Integer.toBinaryString(notReallyInt);
        System.out.println(s);
        System.out.println(Integer.parseInt(s.charAt(30)+""));

    }

    @Test
    public void test() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar sss = Calendar.getInstance();
        sss.set(Calendar.MONTH,5);
        String dd = simpleDateFormat.format(sss.getTime());
        Date ss = simpleDateFormat.parse(dd);
        Date date = this.getMonthLastDay(ss);
        //上月底的时间
        Date yestmonth = date;
        System.out.println("上月时间="+simpleDateFormat.format(yestmonth));

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.add(Calendar.MONTH,-1);
        //上上月底的时间
        Date preMonth = calendar1.getTime();
        Date predate = this.getMonthLastDay(preMonth);
        System.out.println("上上月时间="+simpleDateFormat.format(predate));

    }

    public static Date getMonthLastDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_MONTH,0);
        return calendar.getTime();
    }


    @Test
    public void testString(){
        String sendTo = "1,2";
        System.out.println(sendTo.indexOf("2"));
    }
}
