package com.tit.addressbook.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private Map<Long, String> addressBook = new HashMap<>();

    // GET all addresses
    @GetMapping
    public ResponseEntity<Map<Long, String>> getAllContacts() {
        return ResponseEntity.ok(addressBook);
    }

    // GET contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable Long id) {
        if (addressBook.containsKey(id)) {
            return ResponseEntity.ok(addressBook.get(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST - Add new contact
    @PostMapping
    public ResponseEntity<String> addContact(@RequestParam Long id, @RequestParam String name) {
        addressBook.put(id, name);
        return ResponseEntity.ok("Contact added: " + name);
    }

    // PUT - Update contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestParam String name) {
        if (addressBook.containsKey(id)) {
            addressBook.put(id, name);
            return ResponseEntity.ok("Contact updated to: " + name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Remove contact by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        if (addressBook.containsKey(id)) {
            addressBook.remove(id);
            return ResponseEntity.ok("Contact deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
