package com.prakash.paymentservicettsevening.controllers;

import com.prakash.paymentservicettsevening.dtos.PaymentLinkRequestDto;
import com.prakash.paymentservicettsevening.services.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping("")
    public String createPaymentLink(@RequestBody PaymentLinkRequestDto request) throws StripeException, RazorpayException {
        return paymentService.createPaymentLink(request.getOrderId());
    }
}
