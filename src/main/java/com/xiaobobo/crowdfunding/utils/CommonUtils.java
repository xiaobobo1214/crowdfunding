package com.xiaobobo.crowdfunding.utils;

import java.util.List;
import java.util.UUID;

public class CommonUtils {


    /**
     * 获取32位id
     * @return
     */
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }



    //========================判断是否为空==============================//

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str) || "null".equals(str))
            return true;
        else
            return false;
    }

    public static boolean isNotEmpty(String str) {
        if (str == null || "".equals(str) || "null".equals(str))
            return false;
        else
            return true;
    }

    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0)
            return true;
        else
            return false;
    }

    public static boolean isNotEmpty(List list) {
        if (list == null || list.size() == 0)
            return false;
        else
            return true;
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null)
            return true;
        else
            return false;
    }

    public static boolean isNotEmpty(Object obj) {
        if (obj == null)
            return false;
        else
            return true;
    }

}
