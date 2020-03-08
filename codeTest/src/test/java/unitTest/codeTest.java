package unitTest;


import NineKeySpell.Entity.NumberMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static NineKeySpell.Method.RecursionMethod.makeupLetters;

/**
 * junit测试
 */

/**
 * Bug:刚开始测试的时候不能输入
 * 解决方法：在pom文件把<scope>test</scope>去掉即可
 */
public class codeTest extends NumberMap {

    @Test
    public void unitTesting() {
        System.out.println("请输入数字0-9");
        Scanner input = new Scanner(System.in);//输入 23
        //设置数字为空字符串
        String numbers = "";
        //利用while循环和正则表达式判断输入内容的合法性
        while(true){
            //next()遇到空格键停止吸取
            numbers=input.next();
            //匹配（0-99）
            if(!numbers.matches("[0-9]{1,2}")){
                System.out.println("输入不合法！只能输入0-99的数字,请重新输入：");
            }else{
                break;
            }
        }
        //用StringBulider便于拼接，拼接输入的数字
        StringBuilder arrInput = new StringBuilder("Input:arr[] = {");
        //将输入的数字用空字符串分割成数组
        String[] arrString = numbers.split("");
        //创建一个集合来装数字映射的字母数组
        List<String[]> dataList = new ArrayList<>();

        for (int i = 0; i < arrString.length ; i++) {
            //遍历拼接arrString数组的数字元素
            arrInput.append(arrString[i]);
            //如果不是拼接到最后一个元素，再用,隔开
            if(i<arrString.length-1){
                arrInput.append(",");
            }
            //再将多个list中的数据都添加到同一个集合作为数据源
            List<String> lettersList = (List<String>) numberMap.get(arrString[i]);
            //有数据强转为数组
            if(lettersList.size()>0){
                String[] arrLetter = (String[]) lettersList.toArray();
                //每一个数组当成一个元素，即输入数字所对应的字母数组
                dataList.add(arrLetter);
            }
        }
        //拼接回来
        arrInput.append("}");
        //递归实现多数组排列组合，并返回最终的排列集合
        List<String[]> resultList = makeupLetters(dataList,0,null);
        //打印输入内容
        System.out.println(arrInput.toString());
        System.out.print("Output:");
        //打印输出排列组合，把最终集合的数组元素遍历
        //resultList{[A,D],[A,E],[A,F],[B,D],[B,E],[B,F],[C,D],[C,E],[C,F]}
        for (int i = 0; i < resultList.size() ; i++) {
            String[] letterArr = resultList.get(i);
            System.out.print(" ");
            //letterArr就是resultList中的每一个元素，即一个数组，再遍历输出数组的元素
            for (String s : letterArr){
                System.out.print(s);
            }
        }
    }
}
