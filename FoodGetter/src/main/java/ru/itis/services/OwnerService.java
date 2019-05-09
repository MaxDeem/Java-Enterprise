package ru.itis.services;

import ru.itis.models.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getAllOwners(Long id);
    Owner getOneOwner(Long id);
    void createShop(Owner owner);
    void editOwner(Owner owner);
}
