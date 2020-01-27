package br.com.facil.creche.microservice.creche.service;

import br.com.facil.creche.microservice.creche.dto.CrecheDTO;
import br.com.facil.creche.microservice.creche.dto.CrecheLightDTO;

import java.util.List;

public interface CrecheService {
    CrecheDTO update(CrecheDTO creche);

    void delete(long id);

    CrecheDTO create(CrecheDTO creche);

    List<CrecheLightDTO> listAll();

    CrecheDTO getDetail(long id);
}
