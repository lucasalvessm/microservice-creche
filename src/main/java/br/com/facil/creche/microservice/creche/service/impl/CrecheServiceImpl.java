package br.com.facil.creche.microservice.creche.service.impl;

import br.com.facil.creche.microservice.creche.dto.*;
import br.com.facil.creche.microservice.creche.po.Creche;
import br.com.facil.creche.microservice.creche.repository.CrecheRepository;
import br.com.facil.creche.microservice.creche.service.CrecheService;
import br.com.facil.creche.microservice.creche.util.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrecheServiceImpl implements CrecheService {

    @Autowired
    private CrecheRepository crecheRepository;

    @Override
    public CrecheResponse update(UpdateRequest creche) {
        Creche crecheToUpdate = (Creche) ClassMapper.copyProperties(new Creche(), creche);
        return (CrecheResponse) ClassMapper
                .copyProperties(new CrecheResponse(), crecheRepository.save(crecheToUpdate));
    }

    @Override
    public void delete(long id) {
        if (crecheRepository.existsById(id))
            throw new NoSuchElementException("Could not find any resource for this id");

        crecheRepository.deleteById(id);
    }

    @Override
    public CrecheResponse create(CreateRequest creche) {
        Creche crecheSaved = crecheRepository.save((Creche) ClassMapper.copyProperties(new Creche(), creche));
        return (CrecheResponse) ClassMapper.copyProperties(new CrecheResponse(), crecheSaved);
    }

    @Override
    public List<ListResponse> listAll() {
        List<Creche> crecheList = (List<Creche>) crecheRepository.findAll();
        return crecheList
                .stream()
                .map(creche -> (ListResponse) ClassMapper.copyProperties(new ListResponse(), creche))
                .collect(Collectors.toList());
    }

    @Override
    public CrecheResponse getDetail(long id) {
        Optional<Creche> creche = crecheRepository.findById(id);
        return (CrecheResponse) ClassMapper.copyProperties(new CrecheResponse(), creche.orElseThrow());
    }
}
