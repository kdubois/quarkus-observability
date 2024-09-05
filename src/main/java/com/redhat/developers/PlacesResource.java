package com.redhat.developers;

import java.util.List;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/places")
public class PlacesResource {

    @Inject
    MeterRegistry registry;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    @Timed
    public List<Place> getPlaces(@QueryParam("month") String month) {
        if (month != null ) {
            return Place.findByMonth(month);
        }
        Log.info("Listing all places");
        return Place.listAll();
    }
}
