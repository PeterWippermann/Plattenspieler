package de.wit.bibinfo.plattenspieler.controller.api;

import de.wit.bibinfo.plattenspieler.domain.ReleasesDto;
import de.wit.bibinfo.plattenspieler.services.ReleasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 *
 */
@Controller
@Path("/api")
public class ReleasesController {

    /**
     *
     */
    private final ReleasesService releasesService;

    /**
     *
     * @param releasesService
     */
    @Autowired
    public ReleasesController(ReleasesService releasesService) {
        this.releasesService = releasesService;
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/Releases")
    @Produces(APPLICATION_JSON)
    public List<ReleasesDto> getReleases() {
        return this.releasesService.getReleases();
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/Releases/{id}")
    @Produces(APPLICATION_JSON)
    public ReleasesDto getRelease(@PathParam("id") String id) {return this.releasesService.getRelease(id);}
}
