//import com.zc.base.SpringHbaseApplication;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.hadoop.hbase.Cell;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.client.Scan;
//import org.apache.hadoop.hbase.filter.*;
//import org.apache.hadoop.hbase.util.Bytes;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.hadoop.hbase.HbaseTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.*;
//
///**
// * @Auther: zhangcan
// * @Date: 2019/2/27 12:27
// * @Description:
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = SpringHbaseApplication.class)
//public class HbaseTest {
//
//    @Autowired
//    private HbaseTemplate hbaseTemplate;
//
//    /**
//    *@author zhangcan
//    *@Description 阿道夫
//    *@Date 15:57 2019/4/15
//    *@Param []
//    *@return void
//    **/
//    @Test
//    public void testHbase1() throws Exception {
//
//        TreeMap treeMap = this.getListRowBy(2275,"2019-04-07 17:01:12","2019-04-11 17:01:12");
//        treeMap.forEach((k,v)->{
//            System.out.println(k+"="+v);
//        });
//        if(treeMap.size()==0){
//            System.out.println("没有查询到数据");
//        }
//
//    }
//
//    /**
//    *@author zhangcan
//    *@Description  根据车辆id和开始时间,结束时间查询结果
//    *@Date 0:02 2019/4/16
//    *@Param [carId, datetime, endtime]
//    *@return java.util.List<java.util.Map>
//    **/
//    public List<Map> getListRow(Integer carId,String datetime,String endtime){
//        System.out.println("dd");
//        Scan scan = new Scan();
//        String startRow = null;
//        String endRow = null;
//        TreeMap treeMap = this.getStartAndEndRowkey(datetime,endtime);
//        if(treeMap.size()!=0){
//            startRow = treeMap.get(treeMap.firstKey())+"";
//            endRow = treeMap.get(treeMap.lastKey())+"";
//            scan.setStartRow(startRow.getBytes());
//            scan.setStopRow(endRow.getBytes());
//            RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(carId+""));
//            scan.setFilter(rowFilter);
//            List<Map> list = hbaseTemplate.find("Gps_car_id_table",scan,((result, i) -> {
//                List<Cell> cells = result.listCells();
//                Map map = new HashMap<>();
//                cells.forEach(cell -> {
//                    map.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(),
//                            cell.getQualifierLength()),
//                            Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//                });
//                return map;
//            }));
//            return list;
//        }else{
//            System.out.println("没有查到数据");
//            return null;
//        }
//    }
//
//    /**
//     *@author zhangcan
//     *@Description
//     *@Date 14:26 2019/4/16
//     *@Param [carId, datetime, endtime]
//     *@return java.util.List<java.util.HashMap>
//     **/
//    public TreeMap getListRowBy(Integer carId,String datetime,String endtime){
//        Scan scan = new Scan();
//        ArrayList<Filter> listForFilters = new ArrayList<Filter>();
//        SingleColumnValueFilter singleColumnValueFilter1 = new SingleColumnValueFilter("f2".getBytes(),"eventTime".getBytes(),CompareFilter.CompareOp.GREATER_OR_EQUAL,new BinaryComparator(datetime.getBytes()));
//        SingleColumnValueFilter singleColumnValueFilter2 = new SingleColumnValueFilter("f2".getBytes(),"eventTime".getBytes(),CompareFilter.CompareOp.LESS_OR_EQUAL,new BinaryComparator(endtime.getBytes()));
//        RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(StringUtils.reverse(carId+"")));
//        listForFilters.add(singleColumnValueFilter1);
//        listForFilters.add(singleColumnValueFilter2);
//        listForFilters.add(rowFilter);
//        //listForFilters.add(rowFilter);
//        Filter filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL,
//                listForFilters);
//        scan.setFilter(filterList);
//        //用于排序
//        TreeMap treeMap = new TreeMap();
//        List<Map> list1 = hbaseTemplate.find("Gps_car_id_table", scan, (Result result, int i) -> {
//            List<Cell> cells = result.listCells();
//            HashMap hashMap=new HashMap();
//            cells.forEach(cell -> {
//                hashMap.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(),
//                        cell.getQualifierLength()),
//                        Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//            });
//            treeMap.put(hashMap.get("eventTime"),hashMap);
//            return hashMap;
//        });
//        return treeMap;
//    }
//
//
//    /**
//    *@author zhangcan
//    *@Description   根据carid和时间 模糊查询得到 第一个和最后一个 数据的rowkey
//    *@Date 22:06 2019/4/15
//    *@Param [carId, timelong]
//    *@return java.util.List<java.util.HashMap>
//    **/
//    private List<HashMap> getFirstAndLastRowKeyBy(String datetime,String endtime){
//        Scan scan = new Scan();
//        ColumnPrefixFilter columnPrefixFilter = new ColumnPrefixFilter("eventTime".getBytes());
//        ValueFilter valueFilter1 = new ValueFilter(CompareFilter.CompareOp.GREATER_OR_EQUAL,new BinaryComparator(datetime.getBytes()));
//        ValueFilter valueFilter2 = new ValueFilter(CompareFilter.CompareOp.LESS_OR_EQUAL,new BinaryComparator(endtime.getBytes()));
//        scan.setFilter(columnPrefixFilter).setFilter(valueFilter1).setFilter(valueFilter2);
//        List<HashMap> list1 = hbaseTemplate.find("Gps_car_id_table", scan, (Result result, int i) -> {
//            List<Cell> cells = result.listCells();
//            HashMap hashMap=new HashMap();
//            HashMap hashMap1=new HashMap();
//            cells.forEach(cell -> {
//                hashMap.put("rowkey",
//                        Bytes.toString(cell.getRowArray(),cell.getRowOffset(),cell.getRowLength()));
//                hashMap1.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(),
//                        cell.getQualifierLength()),
//                        Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//            });
//            System.out.println(hashMap.toString()+"****"+hashMap1);
//            return hashMap;
//        });
//        return list1;
//    }
//
//
//    public TreeMap getStartAndEndRowkey(String datetime,String endtime){
//        TreeMap treeMap = new TreeMap();
//        if(endtime.compareTo(datetime)<=0){
//            return treeMap;
//        }
//        List<HashMap> hashMaps = this.getFirstAndLastRowKeyBy(datetime,endtime);
//
//        String s1 = null;
//        String s2 = null;
//
//        if(hashMaps.size()>0){
//            s1=hashMaps.get(0).get("rowkey").toString();
//            s2=hashMaps.get(hashMaps.size()-1).get("rowkey").toString();
//        }
//
//        if(StringUtils.isNotBlank(s1)){
//            treeMap.put(s1,s1);
//        }
//        if(StringUtils.isNotBlank(s2)){
//            treeMap.put(s2,s2);
//        }
//        return treeMap;
//    }
//
//    @Test
//    public void testTime(){
//        System.out.println(System.currentTimeMillis());
//
//        TreeMap treeMap = new TreeMap();
//
//        System.out.println(treeMap.size());
//    }
//
//}
