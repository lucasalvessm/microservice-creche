package br.com.facil.creche.microservice.creche.service.impl;

import br.com.facil.creche.microservice.creche.dto.CreateRequest;
import br.com.facil.creche.microservice.creche.dto.CrecheResponse;
import br.com.facil.creche.microservice.creche.dto.ListResponse;
import br.com.facil.creche.microservice.creche.dto.UpdateRequest;
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

    public static final String COULD_NOT_FIND_ANY_RESOURCE_FOR_THIS_ID = "Could not find any resource for this id";

    @Autowired
    private CrecheRepository crecheRepository;

    @Override
    public CrecheResponse update(UpdateRequest creche) {
        if (!crecheRepository.existsById(creche.getId()))
            throw new NoSuchElementException(COULD_NOT_FIND_ANY_RESOURCE_FOR_THIS_ID);
        var crecheToUpdate = (Creche) ClassMapper.copyProperties(new Creche(), creche);
        return (CrecheResponse) ClassMapper
                .copyProperties(new CrecheResponse(), crecheRepository.save(crecheToUpdate));
    }

    @Override
    public void delete(long id) {
        if (!crecheRepository.existsById(id))
            throw new NoSuchElementException(COULD_NOT_FIND_ANY_RESOURCE_FOR_THIS_ID);

        crecheRepository.deleteById(id);
    }

    @Override
    public CrecheResponse create(CreateRequest creche) {
        var crecheSaved = crecheRepository.save((Creche) ClassMapper.copyProperties(new Creche(), creche));
        return (CrecheResponse) ClassMapper.copyProperties(new CrecheResponse(), crecheSaved);
    }

    @Override
    public List<ListResponse> listAll() {
        var crecheList = (List<Creche>) crecheRepository.findAll();
        return crecheList
                .stream()
                .map(creche -> (ListResponse) ClassMapper.copyProperties(new ListResponse(), creche))
                .collect(Collectors.toList());
    }

    @Override
    public CrecheResponse getDetail(long id) {
        var creche = crecheRepository.findById(id);
        return (CrecheResponse) ClassMapper.copyProperties(new CrecheResponse(), creche.orElseThrow(NoSuchElementException::new));
    }
}
