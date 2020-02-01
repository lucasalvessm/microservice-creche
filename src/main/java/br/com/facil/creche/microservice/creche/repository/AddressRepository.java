package br.com.facil.creche.microservice.creche.repository;

import br.com.facil.creche.microservice.creche.po.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
