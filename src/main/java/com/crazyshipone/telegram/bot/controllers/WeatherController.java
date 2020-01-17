package com.crazyshipone.telegram.bot.controllers;

import com.alibaba.fastjson.JSONObject;
import com.crazyshipone.telegram.bot.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{locale}")
    public JSONObject getWeather(@PathVariable String locale){
        return weatherService.getWeather(locale);
    }
}
