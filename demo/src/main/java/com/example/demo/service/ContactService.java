package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ContactRepository;
import com.example.demo.dto.Contact;

@Service
public class ContactService {
    @Autowired
    ContactRepository dao;
     
    public Contact save(Contact contact){
       	return dao.saveAndFlush(contact);
    }

	public Contact obtainContact(int id) {
		return dao.getOne((long) id);
	}
}
