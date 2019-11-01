import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: zhangcan
 * @Date: 2019/10/12 23:51
 * @Description:
 */
public class NewTM extends Thread{

    private ReentrantLock reentrantLock;

    private Condition mycondition;
    private Condition othercondition;

    private int i;

    public NewTM(int i,ReentrantLock reentrantLock,Condition mycondition,Condition othercondition){
        this.i = i;
        this.reentrantLock = reentrantLock;
        this.mycondition = mycondition;
        this.othercondition = othercondition;
    }

    @Override
    public void run(){
        int j = 0;
        while (j<i){
            reentrantLock.lock();
            othercondition.signal();
            j++;
            System.out.println("THREAD="+Thread.currentThread().getName()+"="+j);
            try {
                mycondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }
    }
}
