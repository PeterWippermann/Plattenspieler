package de.wit.bibinfo.plattenspieler.services;

import de.wit.bibinfo.plattenspieler.domain.ReleasesDto;
import de.wit.bibinfo.plattenspieler.model.entities.Releases;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReleasesServiceTests {

    @Autowired
    private ReleasesService releasesService;
}
