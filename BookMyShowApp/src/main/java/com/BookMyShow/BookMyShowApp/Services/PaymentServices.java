package com.BookMyShow.BookMyShowApp.Services;

import com.BookMyShow.BookMyShowApp.Repositories.BookingRepository;
import com.BookMyShow.BookMyShowApp.Repositories.PaymentRepository;
import com.BookMyShow.BookMyShowApp.Repositories.ShowRepository;
import com.BookMyShow.BookMyShowApp.Repositories.ShowSeatRepository;
import com.BookMyShow.BookMyShowApp.models.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service @Getter @Setter
public class PaymentServices {
    private PaymentRepository paymentRepository;

    public PaymentServices(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    /*
Steps to do payment

1.  get amount to be paid
2.  choose PaymentProvider
3.  transfer amount and get refId from payment Provider to confirm the payment made
4.  if payment succeeded change status to success, else status failed
5.  make payment status change in database
6.  make booking status confirmed
 */

    public Payment makePayment(Long refId,int amount,PaymentProvider paymentProvider) {



       Payment payment = new Payment();
       payment.setPaymentStatus(PaymentStatus.IN_PROGRESS);
       payment.setPaymentProvider(paymentProvider);
       payment.setAmount(amount);
       payment.setCreatedAt(new Date());
       payment.setLastModifiedAt(new Date());
       payment.setReferenceId(refId);

       return paymentRepository.save(payment);
    }
}
