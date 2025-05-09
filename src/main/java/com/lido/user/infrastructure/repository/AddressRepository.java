package com.lido.user.infrastructure.repository;

import com.lido.learningspring.infrastructure.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
