package br.com.facil.creche.microservice.creche.service.impl;

import br.com.facil.creche.microservice.creche.dto.CrecheDTO;
import br.com.facil.creche.microservice.creche.repository.CrecheRepository;
import br.com.facil.creche.microservice.creche.service.CrecheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrecheServiceImpl implements CrecheService {

    @Autowired
    private CrecheRepository crecheRepository;

    @Override
    public CrecheDTO update(CrecheDTO creche) {
        return null;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public CrecheDTO create(CrecheDTO creche) {
        return null;
    }

    @Override
    public List<CrecheDTO> listAllByLocation() {
        return null;
    }

    @Override
    public CrecheDTO getDetail(long id) {
        return null;
    }
}
