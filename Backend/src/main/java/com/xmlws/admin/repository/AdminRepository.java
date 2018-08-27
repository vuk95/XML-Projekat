package com.xmlws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xmlws.admin.backend.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
