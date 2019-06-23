package com.example.demo;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletRequest;

/**
 * @author yanghaiyu
 */
public class MD5Sign {

    public static String md5(String inStr) {
        try {
            String encodeMd5= DigestUtils.md5DigestAsHex(inStr.getBytes("UTF-8"));
            return encodeMd5;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误");
        }
    }


    public static String sign(Map<String, Object> params, String appSecret) {
        StringBuilder valueSb = new StringBuilder();

        // 将参数以参数名的字典升序排序
        Map<String, Object> sortParams = new TreeMap<String, Object>(params);
        Set<Entry<String, Object>> entrys = sortParams.entrySet();
        // 遍历排序的字典,并拼接value1+value2......格式
        for (Entry<String, Object> entry : entrys) {
            valueSb.append(entry.getKey()).append("=");
            valueSb.append(entry.getValue()).append("&");
        }
        valueSb.append("key=").append(appSecret);
        params.put("key", appSecret);
      //  params.remove("appSecret");
        return md5(valueSb.toString());
    }
//"appKey=0easy888&pageNo=1&pageSize=10&type=1&xid=0dc8281b891040b4bc9415b28a6e0b3c00660602&key=db426a9829e4b49a0dcac7b4162da6b6"

    public static boolean verify(String appSecret, HashMap<String, Object> paramsMap) throws Exception {

        String sign = (String) paramsMap.get("sign");
        if (sign == null) {
            throw new Exception(URLEncoder.encode("请求中没有带签名", "UTF-8"));
        }
//        if (request.getParameter("timestamp") == null) {
//            throw new Exception(URLEncoder.encode("请求中没有带时间戳", "UTF-8"));
//        }

        HashMap<String, String> params = new HashMap<String, String>();

        // 获取url参数
        @SuppressWarnings("unchecked")
        Enumeration<String> enu = (Enumeration<String>) paramsMap.keySet();
        while (enu.hasMoreElements()) {
            String paramName = enu.nextElement().trim();
            if (!paramName.equals("sign")) {
                // 拼接参数值字符串并进行utf-8解码，防止中文乱码产生
                params.put(paramName, URLDecoder.decode((String)paramsMap.get(paramName), "UTF-8"));
            }
        }

        params.put("appSecret", appSecret);

        // 将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<String, String>(params);
        Set<Entry<String, String>> entrys = sortParams.entrySet();

        // 遍历排序的字典,并拼接value1+value2......格式
        StringBuilder values = new StringBuilder();
        for (Entry<String, String> entry : entrys) {
            values.append(entry.getValue());
        }

        String mysign = md5(values.toString());
        if (mysign.equals(sign)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args)throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("xid","0dc8281b891040b4bc9415b28a6e0b3c00660602");
        map.put("type","1");

        map.put("pageSize","10");

        map.put("pageNo","1");

        map.put("appKey","0easy888");



        String result=MD5Sign.sign(map,"db426a9829e4b49a0dcac7b4162da6b6");
        System.out.println(result);
        map.put("sign","9ac932e4664554f7b58fbdd4e705f0cc");
        boolean flag= MD5Sign.verify("121212",map);

        System.out.println(flag);
    }


}
