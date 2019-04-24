package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
