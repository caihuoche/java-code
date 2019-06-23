package com.example.demo;

import com.alibaba.fastjson.JSON;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: Andrew
 * @create: 2019-03-15 19:50
 **/
public class MD5Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            }
            else {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
            }
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
    };

    //设置签名
    public String getSignature(Map<String, String> map){
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<String, String> me :map.entrySet()){
            sb.append(me.getKey()).append("=").append(me.getValue()).append("&");
        }
        sb.append("key=").append("xxxxxxxxxxxxxxxxxxxx");
        return MD5Util.MD5Encode(sb.toString(), null);
    }

    public static void main(String[] args) {

        MD5Util util = new MD5Util();

        Map<String, String> map = new TreeMap<String, String>();
        map.put("xid","0dc8281b891040b4bc9415b28a6e0b3c00660602");
        map.put("type","1");

        map.put("pageSize","10");

        map.put("pageNo","1");

        map.put("appKey","0easy888");

      /*  //要发送给用户的模板信息
        TreeMap<String, String> josnMap = new TreeMap<String,String>();
        josnMap.put("name", "zhangsan");
        String jsonData = JSON.toJSONString(josnMap);
        //封装组装签名
        Map<String, String> map = new TreeMap<String,String>();
        String timestamp = System.currentTimeMillis()/1000+"";
        map.put("json", jsonData);
        map.put("mobile", "18142219400");
        map.put("templateCode", "SMS_74665033");
        map.put("timestamp",timestamp);*/
        String signature = util.getSignature(map).toUpperCase();//字母转成大写
        System.out.printf("si" +signature);
    }


}
