package com.premt.springframeworkpetclinic.service.map;

import com.premt.springframeworkpetclinic.model.Specialty;
import com.premt.springframeworkpetclinic.model.Vet;
import com.premt.springframeworkpetclinic.service.SpecialtyService;
import com.premt.springframeworkpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        //TODO: check if Specialty has id
        if (vet != null) {
            if (vet.getSpecialties() != null) {
                vet.getSpecialties().forEach(specialty -> {
                    if (specialty != null) {
                        if (specialty.getId() == null) {
                            Specialty savedSpecialty = specialtyService.save(specialty);
                            specialty.setId(savedSpecialty.getId());
                        }
                    } else {
                        throw new RuntimeException("Specialty is required");
                    }
                });
            }
            return super.save(vet);
        } else {
            return null;
        }
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
