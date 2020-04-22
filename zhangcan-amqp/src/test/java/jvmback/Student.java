package jvmback;

import lombok.Data;

/**
 * @Auther: zhangcan
 * @Date: 2020/4/22 17:00
 * @Description:
 */
@Data
public class Student {

    private String name;
    private Integer age;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("我被回收了=="+this.getName());
    }

}
