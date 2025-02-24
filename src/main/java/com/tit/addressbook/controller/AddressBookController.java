package com.tit.addressbook.controller;


import com.tit.addressbook.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    // GET all contacts
    @GetMapping
    public ResponseEntity<Map<Long, String>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    // GET contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable Long id) {
        String contact = addressBookService.getContactById(id);
        return (contact != null) ? ResponseEntity.ok(contact) : ResponseEntity.notFound().build();
    }

    // POST - Add new contact
    @PostMapping
    public ResponseEntity<String> addContact(@RequestParam Long id, @RequestParam String name) {
        addressBookService.addContact(id, name);
        return ResponseEntity.ok("Contact added: " + name);
    }

    // PUT - Update contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestParam String name) {
        boolean updated = addressBookService.updateContact(id, name);
        return updated ? ResponseEntity.ok("Contact updated to: " + name) : ResponseEntity.notFound().build();
    }

    // DELETE - Remove contact by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        boolean deleted = addressBookService.deleteContact(id);
        return deleted ? ResponseEntity.ok("Contact deleted") : ResponseEntity.notFound().build();
    }
}
