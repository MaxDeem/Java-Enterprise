package ru.itis.repos;

import ru.itis.models.Owner;

import java.util.List;

public interface OwnerRepository {
    List<Owner> findAll();
    List<Owner> findByStatus(Long id);
    Owner findById(Long id);
    void addOwner(Owner owner);
    void addShop(Owner owner);
    void updateOwner(Owner owner);
    void deleteById(Long id);

}
