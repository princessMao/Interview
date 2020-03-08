package NineKeySpell.Method;

import java.util.ArrayList;
import java.util.List;


/**
 * 递归方法
 */
public class RecursionMethod {

    /**
     * 封装递归方法
     * @param dataList 多数组的数据源集合
     * @param index 当前递归的数组在集合中的索引位置(无非就两种情况，0和1)
     * @param resultList 返回的排列结果集合
     * @return
     */

   public static List<String[]> makeupLetters(List<String[]> dataList, int index, List<String[]> resultList){

        if(index==dataList.size()){
            return resultList;
        }
        //结果集合的第一个集合
        List<String[]> resultList0 = new ArrayList<>();
        if(index==0){//第一列数组默认有多少个字母就添加多少个排列数据
            //取dataList的第一个数组
            String[] dataArr = dataList.get(0);
            //把第一个数组的元素添加到第一个集合resultList0中
            for(String s : dataArr){
                resultList0.add(new String[]{s});
            }
        }else{
            //取数据源集合的第二个数组
            String[] dataArr = dataList.get(index);
            //把第二个数组的元素添加到第二个集合resultList中
            for(String[] dataArr0: resultList){
                for(String s : dataArr){
                    //复制数组并扩充新元素
                    String[] dataArrCopy = new String[dataArr0.length+1];
                    /**
                     * Object src : 原数组
                     * int srcPos : 从元数据的起始位置开始
                     * Object dest : 目标数组
                     * int destPos : 目标数组的开始起始位置
                     * int length  : 要copy的数组的长度
                     */
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length-1]=s;
                    //追加到结果集
                    resultList0.add(dataArrCopy);
                }
            }
        }
        //每递归一次集合索引位置加1，直到遍历完最后一个数组才返回最终的排列结果集合
        return makeupLetters(dataList,++index,resultList0);



    }
}
