package com.premt.springframeworkpetclinic.bootstrap;

import com.premt.springframeworkpetclinic.model.Owner;
import com.premt.springframeworkpetclinic.model.PetType;
import com.premt.springframeworkpetclinic.model.Vet;
import com.premt.springframeworkpetclinic.service.OwnerService;
import com.premt.springframeworkpetclinic.service.PetTypeService;
import com.premt.springframeworkpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.save(cat);

        Owner owner1 =  new Owner();
        owner1.setFirstName("Premtim");
        owner1.setLastName("Farizi");
        
        ownerService.save(owner1);
        
        Owner owner2 =  new Owner();
        owner2.setFirstName("Hamdi");
        owner2.setLastName("Gashi");
        
        ownerService.save(owner2);

        System.out.println("Owners loaded!!!");

        Vet vet =  new Vet();
        vet.setFirstName("Dr. Afrim");
        vet.setLastName("Mjeku");

        vetService.save(vet);

        Vet vet2 =  new Vet();
        vet2.setFirstName("Dr. Fetah");
        vet2.setLastName("Doktori");

        vetService.save(vet2);

        System.out.println("Vet loaded!!");
        
    }
}
