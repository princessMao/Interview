package NineKeySpell.Entity;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 初始化数据
 */
public class NumberMap {

    public static HashMap numberMap = new HashMap();
    /**
     * 利用HashMap来存储数字和字母的映射关系
     * key为数字，value是List集合，存放字母
     * 静态代码块在类加载的时候就执行，且在构造方法之前执行，主要是避免有些重复功能的代码浪费资源。
     * 注意这里用静态代码块，若是用方法的话，test会报空指针异常
     */

    static  {
        //0,1不映射任何字母，
        numberMap.put("0", Arrays.asList(""));
        numberMap.put("1", Arrays.asList(""));

        numberMap.put("2", Arrays.asList("A", "B", "C"));
        numberMap.put("3", Arrays.asList("D", "E", "F"));
        numberMap.put("4", Arrays.asList("G", "H", "I"));
        numberMap.put("5", Arrays.asList("J", "K", "L"));
        numberMap.put("6", Arrays.asList("M", "N", "O"));
        numberMap.put("7", Arrays.asList("P", "Q", "R", "S"));
        numberMap.put("8", Arrays.asList("T", "U", "V"));
        numberMap.put("9", Arrays.asList("W", "X", "Y", "Z"));

    }

}
