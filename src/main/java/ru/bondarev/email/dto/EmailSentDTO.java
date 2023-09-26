package ru.bondarev.email.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class EmailSentDTO implements Serializable {

    private Long userId;

    private Long orderId;

    private String userEmail;

    private boolean orderStatus;

    private boolean emailStatus;
}
