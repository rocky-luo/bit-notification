package com.rocky.bit.notification.telegram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by rocky on 18/3/13.
 */
@Component
public class SimpleBot extends TelegramLongPollingBot {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleBot.class);

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return TeleBotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return TeleBotConfig.BOT_TOKEN;
    }

    public void sendChartMsg(Long chartId,String msg) {
        SendMessage message = new SendMessage()
                .setChatId(chartId)
                .setText(msg);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
