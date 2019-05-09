package ru.itis.services;

import org.springframework.stereotype.Service;
import ru.itis.models.Owner;
import ru.itis.repos.OwnerRepository;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getAllOwners(Long id) {
        return ownerRepository.findByStatus(id);
    }
    @Override
    public Owner getOneOwner(Long id) {
        return ownerRepository.findById(id);
    }
    @Override
    public void createShop(Owner owner) {
        ownerRepository.addShop(owner);
    }
    @Override
    public void editOwner(Owner owner) {
        ownerRepository.updateOwner(owner);
    }
}
