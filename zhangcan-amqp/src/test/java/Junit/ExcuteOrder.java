package Junit;

import org.junit.*;

/**
 * @Auther: zhangcan
 * @Date: 2020/5/22 11:08
 * @Description: 测试相关注解执行顺序
 */
public class ExcuteOrder {

        @BeforeClass
        public static void beforeClass(){
             System.out.println("BeforeClass");
         }

         @Before
        public void before(){
             System.out.println("Before");
         }

        @Test
        public void test(){
             System.out.println("Test");
         }

         @Test
        public void test2(){
             System.out.println("Test2");
         }

         @After
        public void after(){
            System.out.println("After");
         }

         @AfterClass
        public static void afterClass(){
            System.out.println("AfterClass");
         }

}
