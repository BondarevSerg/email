package ru.bondarev.email.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionDTO implements Serializable {


    private Long userId;

    private Long orderId;

    private String userEmail;

    private boolean orderStatus;
}
