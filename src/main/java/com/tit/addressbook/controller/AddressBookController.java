package com.tit.addressbook.controller;

import com.tit.addressbook.model.Address;
import com.tit.addressbook.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    // GET all addresses
    @GetMapping
    public ResponseEntity<List<Address>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllAddresses());
    }


    // GET contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getContactById(@PathVariable Long id) {
        Optional<Address> address = addressBookService.getAddressById(id);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST - Add new contact
    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody Address address) {
        addressBookService.addAddress(address);
        return ResponseEntity.ok("Contact added: " + address.getName());
    }

    // PUT - Update contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody Address updatedAddress) {
        boolean updated = addressBookService.updateAddress(id, updatedAddress);
        return updated ? ResponseEntity.ok("Contact updated") : ResponseEntity.notFound().build();
    }
    // DELETE - Remove contact by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        boolean deleted = addressBookService.deleteAddress(id);
        return deleted ? ResponseEntity.ok("Contact deleted") : ResponseEntity.notFound().build();
    }

}
