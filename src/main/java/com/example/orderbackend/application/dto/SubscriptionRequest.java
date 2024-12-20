package com.example.orderbackend.application.dto;

import com.example.orderbackend.domain.model.MeetingService;
import com.example.orderbackend.domain.model.Member;
import com.example.orderbackend.domain.model.SubscriptionType;

import java.time.LocalDate;
import java.util.List;

public class SubscriptionRequest {
    private SubscriptionType subscriptionType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Member member;
    private List<MeetingService> meetingServices;

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<MeetingService> getMeetingServices() {
        return meetingServices;
    }

    public void setMeetingServices(List<MeetingService> meetingServices) {
        this.meetingServices = meetingServices;
    }
}
