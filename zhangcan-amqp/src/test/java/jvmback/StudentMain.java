package jvmback;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhangcan
 * @Date: 2020/4/22 17:08
 * @Description: 
 */
@Slf4j
public class StudentMain {

    public static void main(String[] args){
        Student student = StudentFactory.Student();
        log.info("===开始了===");
        log.info("第一个学生的姓名:{},年龄{}",student.getName(),student.getAge());
        List<String> li = new ArrayList<>();
        for (int i=0; i <1000000 ; i++) {
            StudentFactory.Student();
        }
        log.info("===结束了==="+student);
        /**
            结论:student调用外部方法生成，接下来的程序中如果不使用该student对象，该student会被回收，如果使用，则不会被回收
         **/
    }
}
