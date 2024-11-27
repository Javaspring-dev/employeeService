package com.example.UserProfile.repository;

import com.example.UserProfile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
