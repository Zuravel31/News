package com.example.news.client;

import com.example.news.dto.MessageDTO;
import com.example.news.entity.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "parserServise", url = "http://localhost:8080/news")
public interface MessageClient {

  @GetMapping("/news")
  List<MessageDTO> getNews();

  @GetMapping("/all")
  List<MessageDTO> getAllNews();

  @GetMapping("/today")
  List<MessageDTO> getToDayNews();

  @GetMapping("/yesterday")
  List<MessageDTO> getYesterdayNews();

  @GetMapping("/keyword")
  List<MessageDTO> getKeyWordNews();

}

