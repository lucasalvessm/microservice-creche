package br.com.facil.creche.microservice.creche.repository;

import br.com.facil.creche.microservice.creche.po.Creche;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrecheRepository extends CrudRepository<Creche, Long> {
}
