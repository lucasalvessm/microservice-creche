package br.com.facil.creche.microservice.creche.service.impl;

import br.com.facil.creche.microservice.creche.dto.CrecheDTO;
import br.com.facil.creche.microservice.creche.dto.CrecheLightDTO;
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
    public CrecheDTO update(CrecheDTO creche) {
        return null;
    }

    @Override
    public void delete(long id) {
        if (crecheRepository.existsById(id))
            throw new NoSuchElementException("Could not find any resource for this id");

        crecheRepository.deleteById(id);
    }

    @Override
    public CrecheDTO create(CrecheDTO creche) {
        Creche crecheSaved = crecheRepository.save((Creche) ClassMapper.copyProperties(new Creche(), creche));
        return (CrecheDTO) ClassMapper.copyProperties(new CrecheDTO(), crecheSaved);
    }

    @Override
    public List<CrecheLightDTO> listAll() {
        List<Creche> crecheList = (List<Creche>) crecheRepository.findAll();
        return crecheList
                .stream()
                .map(creche -> (CrecheLightDTO) ClassMapper.copyProperties(new CrecheLightDTO(), creche))
                .collect(Collectors.toList());
    }

    @Override
    public CrecheDTO getDetail(long id) {
        Optional<Creche> creche = crecheRepository.findById(id);
        return (CrecheDTO) ClassMapper.copyProperties(new CrecheDTO(), creche.orElseThrow());
    }
}
