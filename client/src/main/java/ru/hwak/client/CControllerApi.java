package ru.hwak.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ru.hwak.client.dto.RequestDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class CControllerApi {

    private final WebClient cControllerApiWebClient;

    public RequestDto testGet() {
        return cControllerApiWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/testC").build())
                
                .retrieve()
                .bodyToMono(RequestDto.class)
                .block();
    }

    public RequestDto testPost(RequestDto requestDto) {
        return cControllerApiWebClient.post()
                .uri(uriBuilder -> uriBuilder.path("/testC").build())
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(RequestDto.class)
                .block();
    }

    public String testPut(String key, String body) {
        return cControllerApiWebClient.put()
                .uri(uriBuilder -> uriBuilder.path("/testC").build())
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}