package br.com.facil.creche.microservice.creche.service;

import br.com.facil.creche.microservice.creche.dto.CrecheDTO;

import java.util.List;

public interface CrecheService {
    CrecheDTO update(CrecheDTO creche);

    int delete(long id);

    CrecheDTO create(CrecheDTO creche);

    List<CrecheDTO> listAllByLocation();

    CrecheDTO getDetail(long id);
}
