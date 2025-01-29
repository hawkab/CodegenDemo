package ru.hwak.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ru.hwak.client.dto.RequestDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class AControllerApi {

    private final WebClient aControllerApiWebClient;

    public RequestDto testGet2() {
        return aControllerApiWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/testA").build())
                
                .retrieve()
                .bodyToMono(RequestDto.class)
                .block();
    }

    public RequestDto testPost2(RequestDto requestDto) {
        return aControllerApiWebClient.post()
                .uri(uriBuilder -> uriBuilder.path("/testA").build())
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(RequestDto.class)
                .block();
    }

    public String testPut2(String key, String body) {
        return aControllerApiWebClient.put()
                .uri(uriBuilder -> uriBuilder.path("/testA").build())
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}