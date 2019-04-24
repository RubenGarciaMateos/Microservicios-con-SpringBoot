package com.example.demo.api;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Contact;
import com.example.demo.service.ContactService;

@RestController
public class ContacsApi {
	
	@Autowired
	ContactService contactService;
	
	// Inyecta mapper de Dozer
	@Autowired
	Mapper mapper;
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
    public Contact getById(){
        return new Contact(1L, "John", "Doe", "+57 311 222 3344", "john@sinbugs.com");
    }
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public ContactResponse updateOrSave(@RequestBody @Valid ContactRequest contactRequest){
		// Mapeo request dto ==> entity
		Contact contact = mapper.map(contactRequest, Contact.class);
		
		// Invoca l[ogica de negocio
		Contact updatedContact = contactService.save(contact);
		
		ContactResponse contactResponse = mapper.map(updatedContact, ContactResponse.class);
		
	    return contactResponse;
	    
	}
	
	@RequestMapping(value="/getContact/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable Integer id){
	    return contactService.obtainContact(id);
	}
}
