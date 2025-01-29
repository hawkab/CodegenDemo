package ru.hwak.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

/**
 * Формат тестового запроса
 *
 * @author olshansky
 * @since 29.01.2025
 */
@Data
public class RequestDto implements Serializable {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String password;
    private String confirmPassword;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean deleted;
    private UUID mdmId;
    private int countOfUnsuccessfulLogin;
    private BigDecimal amount;
}
