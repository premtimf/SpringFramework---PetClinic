package com.premt.springframeworkpetclinic.bootstrap;

import com.premt.springframeworkpetclinic.model.*;
import com.premt.springframeworkpetclinic.service.OwnerService;
import com.premt.springframeworkpetclinic.service.PetTypeService;
import com.premt.springframeworkpetclinic.service.SpecialtyService;
import com.premt.springframeworkpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 =  new Owner();
        owner1.setFirstName("Premtim");
        owner1.setLastName("Farizi");
        owner1.setAddress("123, Milwuakee");
        owner1.setCity("San Antonio");
        owner1.setTelephone("041234512");

        Pet premtsPet = new Pet();
        premtsPet.setPetType(savedDog);
        premtsPet.setOwner(owner1);
        premtsPet.setBirthDate(LocalDate.now());
        premtsPet.setName("DoggyDog");

        owner1.getPets().add(premtsPet);

        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setFirstName("Hamdi");
        owner2.setLastName("Gashi");
        owner2.setAddress("Sadik Zeneli");
        owner2.setCity("Prishtina");
        owner2.setTelephone("045123123");

        Pet hamdisPet = new Pet();
        hamdisPet.setPetType(savedCat);
        hamdisPet.setOwner(owner2);
        hamdisPet.setBirthDate(LocalDate.now());
        hamdisPet.setName("Maya");

        owner2.getPets().add(hamdisPet);

        ownerService.save(owner2);

        System.out.println("Owners loaded!!!");

        Vet vet =  new Vet();
        vet.setFirstName("Dr. Afrim");
        vet.setLastName("Mjeku");
        vet.getSpecialties().add(savedSurgery);
        vetService.save(vet);

        Vet vet2 =  new Vet();
        vet2.setFirstName("Dr. Fetah");
        vet2.setLastName("Doktori");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Vet loaded!!");
    }
}
