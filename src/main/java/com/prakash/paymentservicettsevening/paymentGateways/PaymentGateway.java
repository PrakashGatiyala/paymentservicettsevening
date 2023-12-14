package com.prakash.paymentservicettsevening.paymentGateways;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;


public interface PaymentGateway {
    String generatePaymentLink(Long amount, String orderId) throws StripeException, RazorpayException;
}
