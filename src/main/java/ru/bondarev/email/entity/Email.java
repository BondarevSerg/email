package ru.bondarev.email.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "emailsent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Email {

    /**
     * id отправления
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "orderid")
    private Long orderId;

    @Column(name = "useremail")
    private String userEmail;

    @Column(name = "orderstatus", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean orderStatus;

    @Column(name = "emailstatus", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean emailStatus;

}
