package com.crazyshipone.telegram.bot.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HttpService {
    private static Logger logger = LoggerFactory.getLogger(HttpService.class);

    public JSONObject sendGetRequest(String url, Map<String, String> headers){
        OkHttpClient client = new OkHttpClient();
        Builder requestBuilder = new Request.Builder().url(url);
        if(headers != null) {
            headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
        }
        Call call = client.newCall(requestBuilder.build());
        JSONObject result = null;
        try
        {
            Response response = call.execute();
            result = JSON.parseObject(response.body().string());
        }
        catch (Exception ex)
        {
            logger.info("Send get request error. url="+url+" error:"+ex.getMessage());
        }
        return result;
    }

}
