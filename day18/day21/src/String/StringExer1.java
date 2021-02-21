package String;

import org.junit.Test;

/**
 * @author tianse
 */
public class StringExer1 {
    /*
    获取一个字符串在另一个字符串中出现的次数
    比如：获取ab在abkkcadkabkebfkabkskab中出现次数
     */

    /**
     * 获取subStr在mainStr中出现次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){

        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        //方法1的index
        //int index;
        //方式2的index
        int index = 0;
        if(mainLength >= subLength){

            //方式1
//            while((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            //方式2：对1的改进
            while((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }
            return count;
        }else
            return 0;
    }

    @Test
    public void testGetCount(){
    String mainStr = "abkkcadkabkebfkabkskab";
    String subStr = "ab";
    int count = getCount(mainStr,subStr);
        System.out.println(count);
    }
}
