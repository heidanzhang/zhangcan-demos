/**
 * @Auther: zhangcan
 * @Date: 2019/10/12 21:27
 * @Description:
 */
public class TT extends Thread{

        private Data data;
        private Object t;

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
                    System.out.println("THREAD="+Thread.currentThread().getName()+"="+j);
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
