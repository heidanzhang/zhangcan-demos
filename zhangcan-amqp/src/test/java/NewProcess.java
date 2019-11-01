import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: zhangcan
 * @Date: 2019/10/12 23:50
 * @Description:
 */
public class NewProcess {

    public static void main(String[] args){
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();

        NewTM newTM = new NewTM(26,reentrantLock,condition1,condition2);
        NewTT newTT = new NewTT(26,reentrantLock,condition2,condition1);

        newTM.start();
        newTT.start();
    }
}
