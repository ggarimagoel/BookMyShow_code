package com.BookMyShow.BookMyShowApp.Repositories;

import com.BookMyShow.BookMyShowApp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Override
    Optional<Payment> findById(Long aLong);

    @Override
    Payment save(Payment payment);
}
