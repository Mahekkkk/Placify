package com.placify.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.placify.entity.User;
import com.placify.enums.Role;
import com.placify.enums.VerificationStatus;
import com.placify.exception.ResourceNotFoundException;
import com.placify.repository.UserRepository;
import com.placify.service.RecruiterVerificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RecruiterVerificationServiceImpl
        implements RecruiterVerificationService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> getPendingRecruiters() {

        return userRepository.findByRoleAndVerificationStatus(
                Role.RECRUITER,
                VerificationStatus.PENDING
        );
    }

    @Override
    public void approveRecruiter(Long recruiterId) {

        User recruiter = userRepository.findById(recruiterId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Recruiter not found"));

        recruiter.setVerificationStatus(
                VerificationStatus.APPROVED);

        userRepository.save(recruiter);
    }

    @Override
    public void rejectRecruiter(Long recruiterId) {

        User recruiter = userRepository.findById(recruiterId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Recruiter not found"));

        recruiter.setVerificationStatus(
                VerificationStatus.REJECTED);

        userRepository.save(recruiter);
    }
}