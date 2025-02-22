package com.example.news.service;

import com.example.news.dto.MessageDTO;
import com.example.news.entity.Message;
import com.example.news.job.TelegramBot;
import com.example.news.mapper.MessageMapper;
import com.example.news.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TelegremServiceImpl implements TelegremService {

    private final MessageMapper mapper;

    private final TelegramBot bot;

    private final MessageRepository repository;

    public void sendMessagesToTelegram() {
        List<Message> messages = repository.findAll();
        List<MessageDTO> messageDTOS = messages.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        for (MessageDTO messageDTO : messageDTOS) {
            String message = formatMessage(messageDTO);
            bot.sendMessage("NewsWorldEkonomicBot", message);
        }
    }

    private String formatMessage(MessageDTO messageDTO) {
        return String.format(
                " **Time:** %s\n" +
                        " **Keywords:** %s\n" +
                        " **Text:** %s",
                messageDTO.getTime(),
                messageDTO.getKeywords(),
                messageDTO.getText()
        );
    }
}