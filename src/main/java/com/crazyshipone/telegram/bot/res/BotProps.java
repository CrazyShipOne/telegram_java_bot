package com.crazyshipone.telegram.bot.res;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "bot")
public class BotProps {
    private String name;
    private String token;
}
