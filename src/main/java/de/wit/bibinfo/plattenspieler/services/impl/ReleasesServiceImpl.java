package de.wit.bibinfo.plattenspieler.services.impl;

import de.wit.bibinfo.plattenspieler.domain.ReleasesDto;
import de.wit.bibinfo.plattenspieler.model.entities.Releases;
import de.wit.bibinfo.plattenspieler.repositories.ReleasesRepository;
import de.wit.bibinfo.plattenspieler.services.ReleasesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 *
 */
@Service
public class ReleasesServiceImpl extends DtoConverter<ReleasesDto, Releases> implements ReleasesService {

    private final ReleasesRepository releasesRepository;

    @Autowired
    public ReleasesServiceImpl(ModelMapper modelMapper, ReleasesRepository releasesRepository) {
        super(modelMapper);
        this.releasesRepository = releasesRepository;
    }

    private ReleasesDto buildReleasesDto(Releases releases) {
        return new ReleasesDto();
    }

    private Releases buildReleases(ReleasesDto releasesDto) {return new Releases();}

    @Override
    public List<ReleasesDto> convertToDto(List<Releases> releases) {
        return this.convertToDto(releases, this::buildReleasesDto);
    }

    @Override
    public ReleasesDto convertToDto(Releases releases) {
        return this.convertToDto(releases, this::buildReleasesDto);
    }

    @Override
    public Releases convertToEntity(ReleasesDto releasesDto) { return this.convertToEntity(releasesDto, this::buildReleases);}

    @Override
    @Transactional
    public ReleasesDto getRelease(String id) {
        return this.releasesRepository.findById(id)
                .map(this::convertToDto)
                .stream().findFirst()
                .orElse(null);
    }

    @Override
    public List<ReleasesDto> getReleases() {
        return StreamSupport.stream(this.releasesRepository.findAll().spliterator(), false)
                .map(this::convertToDto)
                .toList();
    }

    @Override
    @Transactional
    public Optional<Releases> saveRelease(ReleasesDto releasesDto) {
            return Optional.of(this.releasesRepository.save(this.convertToEntity(releasesDto)));
    }

    @Override
    @Transactional
    public void deleteRelease(String catalog) {
        this.releasesRepository.deleteById(catalog);
    }
}

