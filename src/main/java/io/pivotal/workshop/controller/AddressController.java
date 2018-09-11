package io.pivotal.workshop.controller;

import io.pivotal.workshop.domain.Address;
import io.pivotal.workshop.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {

    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("amazoncommerce/address")
    public Address createAddress(@RequestBody Address address) {
        Address addressSaved = addressService.save(address);
        return addressSaved;
    }

    @PostMapping("amazoncommerce/address/load")
    public Address createAddress() {
        Address address = new Address((long)3, "Trumbul", "10637", "Evergreen Park", "IL", "60655", "USA");
        Address addressSaved = addressService.save(address);
        return addressSaved;
    }

    @GetMapping("amazoncommerce/address/{addressId}")
    public Address get(@PathVariable("addressId") Long addressId) {
        Optional<Address> addressRetreieved = addressService.getAddress(addressId);
        Address address = addressRetreieved.get();
        return address;
    }

    @PutMapping("amazoncommerce/address/{addressId}")
    public Address updateAddress(@RequestBody Address address) {
        Address addressUpdated = addressService.save(address);
        return addressUpdated;
    }

    @DeleteMapping("amazoncommerce/address/{addressId}")
    public ResponseEntity<?> delete(@PathVariable("addressId") long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok().body("Address deletion successful");
    }
}
