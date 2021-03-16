package cn.linstudy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.util.FileUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

public class OpenApiUtil {

    //远程服务地址
    public static final String URL = "https://way.jd.com/JDAI/ocr_business?appkey=73712ba79fd37b1adc70c42789ca13c4";

    /**
     * 发送请求工具类
     * @param file
     * @return
     * @throws IOException
     */
    public static JSONObject sendRequest(File file) throws IOException {
        //RestTemplate是Spring提供的用于发起HTTP请求的工具类，提供了多种便捷访问远程Http服务的方法
        RestTemplate restTemplate = new RestTemplate();
        //创建头信息对象
        HttpHeaders headers = new HttpHeaders();
        //设置提交方式为multipart/form-data
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //把文件的byte数组传入到对象中，封装请求数据
        HttpEntity<byte[]> httpEntity = new HttpEntity<>(FileUtil.readAsByteArray(file),headers);
        //发起POST请求到远程服务器，携带数据，并指定返回结果为string类型
        String result = restTemplate.postForObject(URL, httpEntity, String.class);
        //把字符串转为JSONObject对象，方便获取数据
        return JSON.parseObject(result);
    }


}
