package com.crazyshipone.telegram.bot.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.crazyshipone.telegram.bot.res.BotProps;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Data
public class BotService extends TelegramLongPollingBot {
    @Autowired
    private BotProps botProps;
    @Autowired
    private WeatherService weatherService;
    private static Logger logger = LoggerFactory.getLogger(BotService.class);

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText())
        {
            String message = update.getMessage().getText();

            String retmessage = JSON.toJSONString(weatherService.getWeather(message), SerializerFeature.PrettyFormat);
            try{
                SendMessage send = new SendMessage().setChatId(update.getMessage().getChatId()).setText(retmessage);
                execute(send);
            }
            catch (Exception ex)
            {
                logger.error("{}",ex);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botProps.getName();
    }

    @Override
    public String getBotToken() {
        return botProps.getToken();
    }
}
