package com.tit.addressbook.service;


import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddressBookService {
    private final Map<Long, String> addressBook = new HashMap<>();

    public Map<Long, String> getAllContacts() {
        return addressBook;
    }

    public String getContactById(Long id) {
        return addressBook.get(id);
    }

    public String addContact(Long id, String name) {
        addressBook.put(id, name);
        return "Contact added: " + name;
    }

    public boolean updateContact(Long id, String name) {
        if (addressBook.containsKey(id)) {
            addressBook.put(id, name);
            return true;
        }
       return false;
    }

    public boolean deleteContact(Long id) {
        return addressBook.remove(id) != null;
    }
}
