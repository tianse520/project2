package String;

import org.junit.Test;

/**
 * @author tianse
 */
public class StringExer2 {
    /*
    获取两个字符串最大相同子串
    str1 = abcwerthelloyuiodef;str2 = cvhellobnm
     */
    //前提：字符串中只有一个最大相同子串
    public String getMaxSameString(String str1, String str2) {

        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;

            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {

                for (int x = 0, y = length - 1; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }

        }


        return null;
    }


    @Test
    public void testGetMaxSameString(){
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);

    }

}
