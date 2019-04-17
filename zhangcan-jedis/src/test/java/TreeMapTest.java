import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.TreeMap;

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

}
