/**
 * @Auther: zhangcan
 * @Date: 2019/10/12 21:19
 * @Description:
 */
public class Process {


    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        TT tt = new TT();
        TM tm = new TM();
        Data data = new Data(26,lock);
        tt.setT(lock);
        tm.setT(lock);
        tt.setData(data);
        tm.setData(data);
        tt.start();
        tm.start();
    }
}
