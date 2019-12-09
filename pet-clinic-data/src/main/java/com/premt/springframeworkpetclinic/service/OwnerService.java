package com.premt.springframeworkpetclinic.service;

import com.premt.springframeworkpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName (String lastName);

}
