package com.crazyshipone.telegram.bot.res;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hefeng")
@Data
public class HefengProps {

    private String apiurl;
    private String key;
}
