/**
 * @Auther: zhangcan
 * @Date: 2019/10/12 21:48
 * @Description:
 */
public class Data {

    private int i;

    private int j;

    private Object object;

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j=j;
    }

    public Data(int i, Object object){
        this.i = i;
        this.object = object;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i=i;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object=object;
    }

}
