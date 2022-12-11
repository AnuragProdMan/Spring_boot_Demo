package com.example.jpa.learn.learning.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class WrongHeaderResponse {

    LocalDateTime timeStamp;
    String message;
}
