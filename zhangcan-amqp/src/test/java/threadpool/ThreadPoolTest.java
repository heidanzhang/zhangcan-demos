package threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: zhangcan
 * @Date: 2019/12/3 16:57
 * @Description:
 */
public class ThreadPoolTest {

    private static ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(3);
    }


    public static void main(String[] args){
        for (int i=0; i < 4 ; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"=hh");
            });
        }
        executorService.shutdown();
        for (int i=0; i < 4 ; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"=hh");
            });
        }
    }

}
