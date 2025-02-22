package com.example.news.mapper;

import com.example.news.dto.MessageDTO;
import com.example.news.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message toEntity(MessageDTO newsDTO);

    MessageDTO toDto(Message news);


}
