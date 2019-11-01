/**
 * @Auther: zhangcan
 * @Date: 2019/10/12 21:28
 * @Description:
 */
public class TM extends Thread{

    private Object t;

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data=data;
    }

    public Object getT() {
        return t;
    }

    public void setT(Object t) {
        this.t=t;
    }
    @Override
    public void run(){
        //System.out.println(data.hashCode());
        //data.out();
        synchronized (t){
            for (int j=1; j <= data.getI();) {
                t.notify();
                System.out.println("thread="+Thread.currentThread().getName()+"="+(char)(j+64));
                try {
                    j++;
                    t.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
