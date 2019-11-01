import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.Calendar;

/**
 * Created by aaa on 2019/4/16.
 */
public class HbaseClient  {



    public static void main(String[] args){

        Configuration config = new Configuration();
        config.set("hbase.zookeeper.quorum", "bigdata-02.wd.net");//需根据hbase配置进行设置
        HBaseConfiguration hbaseConfig = new HBaseConfiguration(config);
        //最新的时间
        String time1 = "2019-05-08 16:48:27";
        //过去的时间
        String time2 = "2019-05-08 16:23:08";
        String car_id = "2546";
        //carid反转这个stringWay方法就是把字符串反转我写的scala 你用Java写
        String carid = "6452";
        //时间戳long的最大值减去当前时间戳
        Long timeStamp1 =Calendar.getInstance().getTimeInMillis();
        Long timeStamp2 =Calendar.getInstance().getTimeInMillis();

        Scan scan = new Scan();
       // FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ALL);
     //scan.setStartRow(Bytes.toBytes(carid+"_"+time1));
        // scan.setStopRow(Bytes.toBytes(carid+"_"+time2));
     //   Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new RegexStringComparator(carid+"_"+".*"));
       // list.addFilter(filter);
       // car_id+"_"+timeStamp1

        // String row1 = carid+"_"+time1
        //String row2 = carid+"_"+time2
        String row1 = "6452_9223370477307921807";
        System.out.println(timeStamp1);
        System.out.println(timeStamp2);
        String row2 = "6452_9223370477307961807";
      //  Filter filter1 = new RowFilter(CompareFilter.CompareOp.GREATER_OR_EQUAL, new BinaryComparator (Bytes.toBytes(row1)));
      //  list.addFilter(filter1);
        //Bytes.toBytes(row1)

     //   Filter filter2 = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL, new BinaryComparator (Bytes.toBytes(row2)));
       // list.addFilter(filter2);
       // scan.setFilter(list);
        scan.setStartRow(row1.getBytes());
       scan.setStopRow(row2.getBytes());
                  //  Long.MAX_VALUE;
        ResultScanner rs = null;

        try {
            HTable table = new HTable(hbaseConfig, Bytes.toBytes("Gps_car_id_table"));
            String rowkey = null;
            String value = null;
            String Qualifier = null;
            rs = table.getScanner(scan);
            for (Result r : rs) {
                for (KeyValue kv : r.list()) {
                    rowkey = Bytes.toString(kv.getRowArray());
                    Qualifier = Bytes.toString(kv.getQualifier());
                    value = Bytes.toString(kv.getValue());

                    System.out.println(rowkey+ " : " + Qualifier+ " : " + value);
                }
            }
        }   catch (Exception e) {
            e.printStackTrace();

        }
    }

//    public List<Map> getListRowBy(Integer carId, String datetime, String endtime){
//        Scan scan = new Scan();
//        StringBuffer carid = new StringBuffer(carId+"");
//        carid = carid.reverse();
//        String row1 = "";
//        String row2 = "";
//        try {
//            StringBuffer sb1 = new StringBuffer(DateUtils.parseDate(datetime, DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()).getTime()+"");
//            StringBuffer sb2 = new StringBuffer(DateUtils.parseDate(endtime, DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()).getTime()+"");
//            row1 = carid+"_"+(9223372036854775807L-new Long(sb2.toString()));
//            row2 = carid+"_"+(9223372036854775807L-new Long(sb1.toString()));
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//            log.error("hbase查询报错="+e.getMessage());
//        }
//        scan.setStartRow(row1.getBytes());
//        scan.setStopRow(row2.getBytes());
//
//        List<Map> list1 = hbaseTemplate.find("Gps_car_id_table", scan, (Result result, int i) -> {
//            HashMap hashMap=new HashMap();
//            try{
//                List<Cell> cells = result.listCells();
//                //HashMap hashMapRowKey=new HashMap();//记录rowkey
//                cells.forEach(cell -> {
//                    hashMap.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(),
//                            cell.getQualifierLength()),
//                            Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//                    //hashMapRowKey.put(Bytes.toString(cell.getRowArray(),cell.getRowOffset(),cell.getRowLength()),"rowkey");
//                });
//                //System.out.println("================================================"+hashMap);
//                //System.out.println("================================================"+hashMapRowKey);
//                //log.info("hbase中取得数据="+hashMap);
//            }catch (Exception e){
//                e.printStackTrace();
//                log.info("hbase 数据异常");
//            }
//            return hashMap;
//
//        });
//        return list1;
//    }









}
