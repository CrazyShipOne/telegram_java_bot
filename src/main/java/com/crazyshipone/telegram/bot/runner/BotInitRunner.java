package com.crazyshipone.telegram.bot.runner;

import com.crazyshipone.telegram.bot.services.BotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@Component
public class BotInitRunner implements CommandLineRunner {

    @Autowired
    private BotService botService;
    private static Logger logger = LoggerFactory.getLogger(BotInitRunner.class);

    @Override
    public void run(String... args) throws Exception {
        System.getProperties().put("socksProxySet","true");
        System.getProperties().put("socksProxyHost","localhost");
        System.getProperties().put("socksProxyPort","1080");
        TelegramBotsApi api = new TelegramBotsApi();
        try{
            api.registerBot(botService);
        }
        catch (Exception ex)
        {
            logger.warn("{}",ex);
        }
    }
}
