package ru.hwak.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ru.hwak.client.dto.RequestDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class BControllerApi {

    private final WebClient bControllerApiWebClient;

    public RequestDto testGet1() {
        return bControllerApiWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/testB").build())
                
                .retrieve()
                .bodyToMono(RequestDto.class)
                .block();
    }

    public RequestDto testPost1(RequestDto requestDto) {
        return bControllerApiWebClient.post()
                .uri(uriBuilder -> uriBuilder.path("/testB").build())
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(RequestDto.class)
                .block();
    }

    public String testPut1(String key, String body) {
        return bControllerApiWebClient.put()
                .uri(uriBuilder -> uriBuilder.path("/testB").build())
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}