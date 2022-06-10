package de.wit.bibinfo.plattenspieler.services;

import de.wit.bibinfo.plattenspieler.domain.ReleasesDto;
import de.wit.bibinfo.plattenspieler.model.entities.Releases;

import java.util.List;
import java.util.Optional;


public interface ReleasesService extends DtoConverterService<ReleasesDto, Releases> {

    ReleasesDto getRelease(String id);

    List<ReleasesDto> getReleases();

    Optional<Releases> saveRelease(ReleasesDto releasesDto);

    void deleteRelease(String catalog);

}
