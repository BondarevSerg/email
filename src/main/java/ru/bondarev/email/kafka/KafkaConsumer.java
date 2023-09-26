package ru.bondarev.email.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.bondarev.email.dto.TransactionDTO;
import ru.bondarev.email.entity.Email;
import ru.bondarev.email.repository.EmailRepository;

/**
 * слушаем топик, статус почтового отправления true, сохраняем в БД
 */
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final EmailRepository emailRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "order_confirmed", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(TransactionDTO transactionDTO){

        var emailSent=Email.builder()
                .userId(transactionDTO.getUserId())
                .orderId(transactionDTO.getOrderId())
                .userEmail(transactionDTO.getUserEmail())
                .orderStatus(transactionDTO.isOrderStatus())
                .emailStatus(true)
                .build();
       emailRepository.save(emailSent);

        LOGGER.info(String.format("Json message recieved -> %s",emailSent.toString()));
        System.out.println(emailSent);


    }
}
