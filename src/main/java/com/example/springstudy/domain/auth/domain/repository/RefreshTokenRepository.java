package com.example.springstudy.domain.auth.domain.repository;

import com.example.springstudy.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
