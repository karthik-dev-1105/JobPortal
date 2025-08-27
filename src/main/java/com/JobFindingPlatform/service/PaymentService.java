package com.JobFindingPlatform.service;


import com.JobFindingPlatform.ENUM.PaymentStatus;
import com.JobFindingPlatform.dto.PaymentRequestDTO;
import com.JobFindingPlatform.dto.PaymentResponseDTO;
import com.JobFindingPlatform.entity.Payment;
import com.JobFindingPlatform.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;


    public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {
        Payment pay = new Payment();
        pay.setUserId(dto.getUserId());
        pay.setPlanId(dto.getPlanId());
        pay.setAmount(dto.getAmount());
        pay.setStatus(PaymentStatus.SUCCESS);
        pay.setTransactionId(UUID.randomUUID().toString());
        pay.setLocalDateTime(LocalDateTime.now());

        paymentRepo.save(pay);

        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setTransactionId(pay.getTransactionId());
        response.setPaymentStatus(PaymentStatus.SUCCESS);
        response.setAmount(pay.getAmount());
        return response;
    }

}
