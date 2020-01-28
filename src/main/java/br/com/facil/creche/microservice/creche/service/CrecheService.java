package br.com.facil.creche.microservice.creche.service;

import br.com.facil.creche.microservice.creche.dto.*;

import java.util.List;

public interface CrecheService {
    CrecheResponse update(UpdateRequest creche);

    void delete(long id);

    CrecheResponse create(CreateRequest creche);

    List<ListResponse> listAll();

    CrecheResponse getDetail(long id);
}
