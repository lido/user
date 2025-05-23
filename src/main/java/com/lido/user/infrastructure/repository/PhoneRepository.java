package com.lido.user.infrastructure.repository;

import com.lido.user.infrastructure.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository  extends JpaRepository<Phone, Long> { }
