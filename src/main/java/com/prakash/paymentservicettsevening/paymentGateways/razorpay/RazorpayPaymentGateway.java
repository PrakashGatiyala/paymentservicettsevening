package com.prakash.paymentservicettsevening.paymentGateways.razorpay;

import com.prakash.paymentservicettsevening.paymentGateways.PaymentGateway;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import com.razorpay.RazorpayException;

@Service
public class RazorpayPaymentGateway implements PaymentGateway {
    @Value("${razorpay.secret.keyid}")
    private String razorpayKeyId;
    @Value("${razorpay.secret.keysecret}")
    private String razorpayKeySecret;
    @Override
    public String generatePaymentLink(Long amount, String orderId) throws RazorpayException {

        RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        //paymentLinkRequest.put("expire_by",1691097057);
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","+919000090000");
        customer.put("contact","Gaurav Kumar");
        customer.put("email","gaurav.kumar@example.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://scaler.com");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.get("short_url");
    }
}
