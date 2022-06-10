package de.wit.bibinfo.plattenspieler.repositories;

import de.wit.bibinfo.plattenspieler.model.entities.Releases;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 */
public interface ReleasesRepository extends CrudRepository<Releases, String> {

    Optional<Releases> findByCatalog(String catalog);
}
