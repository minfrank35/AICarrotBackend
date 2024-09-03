package com.labscale.test.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID uuid;
    private String nickname;
    private String phoneNumber;
    private boolean phoneVerified;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}