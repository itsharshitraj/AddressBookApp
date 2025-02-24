package com.tit.addressbook.service;


import com.tit.addressbook.model.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    private final List<Address> addressBook = new ArrayList<>();

    public List<Address> getAllAddresses() {
        return addressBook;
    }

    public Optional<Address> getAddressById(Long id) {
        return addressBook.stream()
                .filter(address -> address.getId().equals(id))
                .findFirst();
    }

    public void addAddress(Address address) {
        if (address.getId() == null) {
            // 🔹 Generate ID manually (auto-increment simulation)
            long newId = addressBook.size() + 1;
            address.setId(newId);
        }
        addressBook.add(address);
    }

    public boolean updateAddress(Long id, Address updatedAddress) {
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getId().equals(id)) {
                addressBook.set(i, updatedAddress);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAddress(Long id) {
        return addressBook.removeIf(address -> address.getId().equals(id));
    }

}
