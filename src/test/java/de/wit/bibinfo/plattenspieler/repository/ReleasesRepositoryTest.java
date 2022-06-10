package de.wit.bibinfo.plattenspieler.repository;

import de.wit.bibinfo.plattenspieler.model.entities.Releases;
import de.wit.bibinfo.plattenspieler.repositories.ReleasesRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReleasesRepositoryTest {

    @Autowired
    public ReleasesRepository releasesRepository;
    private static String releasesCat;

    @Test
    @Order(1)
    void saveRelease() {
        Releases releases = new Releases();
        releases.setArtist("Pagan Altar");
        releases.setTitle("The Lords of Hypocrisy");
        releases.setReleasedate("31.10.2004");
        releases.setLength("50:19");
        releases.setTracks(9);
        releases.setCatalog("TEMPLE-015 DLP");
        releases.setPlayed(0);

        this.releasesRepository.save(releases);
        releasesCat = releases.getCatalog();
    }

    @Test
    @Order(2)
    void updateRelease() {
        Optional<Releases> releases = this.releasesRepository.findByCatalog(releasesCat);

        Releases releasesUpdate = releases.get();
        releasesUpdate.setGenre("Doom");
        releasesUpdate.setLabel("Temple of Mystery");
        this.releasesRepository.save(releasesUpdate);
    }

    @Test
    @Order(3)
    void deleteRelease() {
        Optional<Releases> releases = this.releasesRepository.findByCatalog(releasesCat);
        assertThat(releases).isPresent();

        Releases releasesDelete = releases.get();
        this.releasesRepository.delete(releasesDelete);


    }
}
