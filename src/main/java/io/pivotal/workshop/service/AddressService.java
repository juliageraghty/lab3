package io.pivotal.workshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.workshop.domain.Address;
import io.pivotal.workshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        super();
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        Address addressSaved = addressRepository.save(address);
        return addressSaved;
    }

    public Optional<Address> getAddress(Long addressId) {
        return addressRepository.findById(addressId);
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

}
