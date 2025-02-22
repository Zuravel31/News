package com.example.news.controller;

import com.example.news.service.MessaginService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/news")
public class MessegeController {

    private final MessaginService service;

}