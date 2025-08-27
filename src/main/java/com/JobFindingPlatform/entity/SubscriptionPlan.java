package com.JobFindingPlatform.entity;


import com.JobFindingPlatform.ENUM.PlanName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlanName planName;

    private Double price;

    private String currency;
    private Long durationMinutes;

    private String features;
}