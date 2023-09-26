package ru.bondarev.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.email.entity.Email;


public interface EmailRepository extends JpaRepository<Email, Long> {

}
