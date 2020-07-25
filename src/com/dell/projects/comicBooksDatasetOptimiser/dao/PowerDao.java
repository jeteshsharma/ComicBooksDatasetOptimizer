package com.dell.projects.comicBooksDatasetOptimiser.dao;

import com.dell.projects.comicBooksDatasetOptimiser.entity.Power;
import javassist.NotFoundException;
import org.hibernate.Session;

public class PowerDao extends Dao<Power>{

    public Power read(Session session, Power power, long id) throws NotFoundException {
        String className="Power";
        return super.readSingle(session, power, id, className);
    }
}
