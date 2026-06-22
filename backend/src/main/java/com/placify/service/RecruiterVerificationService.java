package com.placify.service;

import java.util.List;

import com.placify.entity.User;

public interface RecruiterVerificationService {

    List<User> getPendingRecruiters();

    void approveRecruiter(Long recruiterId);

    void rejectRecruiter(Long recruiterId);
}