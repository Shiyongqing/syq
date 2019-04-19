package com.gome.retail.shop.online.storage.web.app;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.dubbo.common.json.JSONObject;
import com.gome.retail.shop.online.storage.model.DtoKcdd;
import com.gome.retail.shop.online.storage.model.DtoSkuStorageDecReq;
import com.gome.retail.shop.online.storage.model.DtoSkuStorageDecResp;

import java.util.*;
/**

**/
public class Tests {

    // 测试 java值引用和对象引用
    /**
     * @Author   基本类型，特殊类型（String）是作为值传递，原有的值不会改变。 对象是引用传递，如果被修改，值会改变 immutable的类 类改为final或者单个参数改为final 不可被修改
     * @Description
     * @Date 18:22 2019/4/7
     * @Param [str, m, dates, ta]
     * @return void
     * @Version 1.0
     **/
    public static void str(String str,int m, Dates dates,TA ta,TB tb){
        ta=new TA("tt");
            str="mm";
            m=10;
            dates.setCount(10);
            dates.setItemA("bbbb");
            ta.setMsss("mpp");
            tb=new TB("ms");
    }

    public static void main(String agrgs[]) throws Exception {
        String string="cmmd";
        int ms=9;
        Dates dates= new Dates();
        dates.setCount(3);
        dates.setItemA("ccccc");
        TA ta=new TA("ms");
        ta.setMsss("mmaa");

        TB tb=new TB("tb");
        str(string,ms, dates,ta,tb);
        System.out.println(string);
        System.out.println(ms);
        System.out.println(dates);
        System.out.println(ta.getStr());
        System.out.println(ta.getMsss());

        System.out.println(tb.getStr());


    }


}

//此类作为作为引用对象 参数不可被修改
final class TA{
    private final String str;
    private String msss;
    public TA(){
        str = null;
    }
    public TA(String str){
        this.str=str;
    }

    public String getStr(){
        return str;
    }

    public String getMsss() {
        return msss;
    }

    public void setMsss(String msss) {
        this.msss = msss;
    }
}


// 此类作为引用对象的str属性不可被修改
 class TB{
    private final String str;

    public TB(){
        str = null;
    }
    public TB(String str){
        this.str=str;
    }

    public String getStr(){
        return str;
    }

}
 class Dates{
    private String itemA;

    private String itemB;

    private  Integer count;

    private Integer[] counts;

    public String getItemA() {
        return itemA;
    }

    public void setItemA(String itemA) {
        this.itemA = itemA;
    }

    public String getItemB() {
        return itemB;
    }

    public void setItemB(String itemB) {
        this.itemB = itemB;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount( Integer count) {
        this.count = count;
    }

    public Integer[] getCounts() {
        return counts;
    }

    public void setCounts(Integer[] counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "itemA='" + itemA + '\'' +
                ", itemB='" + itemB + '\'' +
                ", count=" + count +
                ", counts=" + Arrays.toString(counts) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dates dates = (Dates) obj;
        return Objects.equals(itemA, dates.itemA) ;
    }
}


//排序 Collections Collections.sort

class ComparatorStock implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        DtoSkuStorageDecResp d1;
        DtoSkuStorageDecResp d2;
        if(o1 instanceof  DtoSkuStorageDecResp && o2 instanceof DtoSkuStorageDecResp){
            d1= (DtoSkuStorageDecResp) o1;
            d2= (DtoSkuStorageDecResp) o2;
            return Integer.valueOf(d1.getInxDecReq()).compareTo(d2.getInxDecReq());
        }


        return 0;
    }
}



打印结果：
cmmd
9
Dates{itemA='bbbb', itemB='null', count=10, counts=null}
ms
mmaa
tb
