package com.crazyshipone.telegram.bot.services;

import com.alibaba.fastjson.JSONObject;
import com.crazyshipone.telegram.bot.res.HefengProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private HttpService httpService;
    @Autowired
    private HefengProps hefengProps;

    public JSONObject getWeather(String locale){
        String url = hefengProps.getApiurl()+"location="+locale+"&key="+ hefengProps.getKey();
        JSONObject result = httpService.sendGetRequest(url,null);
        return result;
    }
}
