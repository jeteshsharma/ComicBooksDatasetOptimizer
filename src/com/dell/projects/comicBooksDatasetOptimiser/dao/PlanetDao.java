package com.dell.projects.comicBooksDatasetOptimiser.dao;

import com.dell.projects.comicBooksDatasetOptimiser.entity.Planet;
import javassist.NotFoundException;
import org.hibernate.Session;

public class PlanetDao extends Dao<Planet> {

    public Planet read(Session session, Planet planet, long id) throws NotFoundException {
        String className="Planet";
        return super.readSingle(session, planet, id, className);
    }
}
