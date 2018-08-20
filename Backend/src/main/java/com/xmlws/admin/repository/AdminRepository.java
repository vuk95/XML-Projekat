package com.xmlws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xmlws.admin.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
