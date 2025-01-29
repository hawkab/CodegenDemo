package ru.hwak.controller;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ru.hwak.dto.RequestDto;

/**
 * Контроллер обработки тестовых запросов
 *
 * @author olshansky
 * @since 24.01.2025
 */
@RestController
@RequestMapping("/rule-apply")
@RequiredArgsConstructor
public class RuleController {

    @GetMapping
    public RequestDto testGet() {
        return new RequestDto();
    }

    @PostMapping
    public RequestDto testPost(@RequestBody RequestDto body) {
        return body;
    }

    @PutMapping
    public String testPut(@RequestBody String body, @RequestParam String key) {
        return key + " " + body;
    }
}