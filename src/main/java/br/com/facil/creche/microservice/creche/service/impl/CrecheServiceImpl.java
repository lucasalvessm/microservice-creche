package br.com.facil.creche.microservice.creche.service.impl;

import br.com.facil.creche.microservice.creche.dto.CreateRequest;
import br.com.facil.creche.microservice.creche.dto.CrecheResponse;
import br.com.facil.creche.microservice.creche.dto.ListResponse;
import br.com.facil.creche.microservice.creche.dto.UpdateRequest;
import br.com.facil.creche.microservice.creche.po.Address;
import br.com.facil.creche.microservice.creche.po.Creche;
import br.com.facil.creche.microservice.creche.po.Image;
import br.com.facil.creche.microservice.creche.repository.CrecheRepository;
import br.com.facil.creche.microservice.creche.service.CrecheService;
import br.com.facil.creche.microservice.creche.util.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
    @Transactional
    public CrecheResponse create(CreateRequest creche) {
        var crecheToSave = (Creche) ClassMapper.copyProperties(new Creche(), creche);

        if (creche.getAddressInfo() != null)
            crecheToSave.setAddress((Address) ClassMapper.copyProperties(new Address(), creche.getAddressInfo()));

        if (creche.getImages() != null)
            crecheToSave
                    .setImageList(creche
                            .getImages()
                            .stream()
                            .map(image -> new Image(image))
                            .collect(Collectors.toList()));

        var crecheSaved = crecheRepository.save(crecheToSave);
        return (CrecheResponse) ClassMapper.copyProperties(new CrecheResponse(), crecheSaved);
    }

    @Override
    public List<ListResponse> listAll() {
        var crecheList = new ArrayList<ListResponse>();
        crecheRepository
                .findAll()
                .iterator()
                .forEachRemaining(creche ->
                        crecheList.add((ListResponse) ClassMapper.copyProperties(new ListResponse(), creche)));
        return crecheList;
    }

    @Override
    public CrecheResponse getDetail(long id) {
        var creche = crecheRepository.findById(id).orElseThrow(NoSuchElementException::new);
        var crecheResponse = (CrecheResponse) ClassMapper.copyProperties(new CrecheResponse(), creche);

        if (creche.getAddress() != null)
            crecheResponse.setAddressInfo((br.com.facil.creche.microservice.creche.dto.Address)
                    ClassMapper.copyProperties(new br.com.facil.creche.microservice.creche.dto.Address(), creche.getAddress()));

        if (creche.getImageList() != null)
            crecheResponse
                    .setImages(creche
                            .getImageList()
                            .stream()
                            .map(image -> image.getImageBase64())
                            .collect(Collectors.toList()));

        return crecheResponse;
    }
}
