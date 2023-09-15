package com.BookMyShow.BookMyShowApp.Controllers;

import com.BookMyShow.BookMyShowApp.Repositories.PaymentRepository;
import com.BookMyShow.BookMyShowApp.Services.PaymentServices;
import com.BookMyShow.BookMyShowApp.dto.PaymentRequestDto;
import com.BookMyShow.BookMyShowApp.dto.PaymentResponseDto;
import com.BookMyShow.BookMyShowApp.models.Payment;
import com.BookMyShow.BookMyShowApp.models.ResponseStatus;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PaymentController {
    private PaymentRepository paymentRepository;
    private PaymentServices paymentServices;

    public PaymentResponseDto makePayment(PaymentRequestDto paymentRequestDto){
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentRequestDto.getId());
        PaymentResponseDto response = new PaymentResponseDto();

        if(optionalPayment.isEmpty()){
            Payment payment = paymentServices.makePayment(paymentRequestDto.getRefId(),
                    paymentRequestDto.getAmount(), paymentRequestDto.getPaymentProvider() );
            response.setResponseStatus(ResponseStatus.SUCCESS);

            return response;
        }
        throw  new RuntimeException("Payment already done");
    }
}
