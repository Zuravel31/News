package com.example.news.service;

import com.example.news.client.MessageClient;
import com.example.news.dto.MessageDTO;
import com.example.news.entity.Message;
import com.example.news.mapper.MessageMapper;
import com.example.news.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessaginServiceImpl implements MessaginService {

    private final MessageRepository repository;

    private final MessageClient client;

    private final MessageMapper mapper;


    @Override
    public void fetchAndSaveNews() {
        List<MessageDTO> newsDTO = client.getNews();
        List<Message> news = newsDTO.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
        repository.saveAll(news);
    }

    @Override
    public void fetchAndSaveALLNews() {
        List<MessageDTO> newsDTO = client.getAllNews();
        List<Message> news = newsDTO.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
        repository.saveAll(news);
    }

    @Override
    public void fetchAndSaveToDay() {
        List<MessageDTO> newsDTO = client.getToDayNews();
        List<Message> news = newsDTO.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
        repository.saveAll(news);
    }

    @Override
    public void fetchAndSaveYesterday() {
        List<MessageDTO> newsDTO = client.getYesterdayNews();
        List<Message> news = newsDTO.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
        repository.saveAll(news);
    }

    @Override
    public void fetchAndSaveKeyWord() {
        List<MessageDTO> newsDTO = client.getKeyWordNews();
        List<Message> news = newsDTO.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
        repository.saveAll(news);
    }
}