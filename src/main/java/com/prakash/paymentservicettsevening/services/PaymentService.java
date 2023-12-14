package com.prakash.paymentservicettsevening.services;

import com.prakash.paymentservicettsevening.paymentGateways.PaymentGateway;
import com.prakash.paymentservicettsevening.paymentGateways.razorpay.RazorpayPaymentGateway;
import com.prakash.paymentservicettsevening.paymentGateways.stripe.StripePaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
//   private PaymentGateway paymentGateway;
   private PaymentGateway paymentGateway;
    public PaymentService(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway){
//        this.paymentGateway= razorpayPaymentGateway;
        this.paymentGateway=stripePaymentGateway;
    }
    public String createPaymentLink(Long orderId) throws StripeException, RazorpayException {
        // Email of customer
        // phone number of customer
        // amount of order
      //  Order order = restClient.get(localhost:9090/ordeers/{OrderId])
        // userId  = order.getusrID();
        // User user = restClient.get(localhost:9000/users/{usersId])
        // String email = user.getEmail()
        // String Phone = user.getPhone()
        // Long amount = order.getTotalAmound();
        //PaymentGateway paymentGateway = new StripePaymentGateway();

        return paymentGateway.generatePaymentLink(10000L, String.valueOf(orderId));

    }
}
