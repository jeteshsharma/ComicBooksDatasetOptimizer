package com.dell.projects.comicBooksDatasetOptimiser.dao;

import com.dell.projects.comicBooksDatasetOptimiser.entity.ComicCharacter;
import javassist.NotFoundException;
import org.hibernate.Session;

public class ComicCharacterDao extends Dao<ComicCharacter>{

    public ComicCharacter read(Session session, ComicCharacter comicCharacter, long id) throws NotFoundException {
        String className="ComicCharacter";
        return super.readSingle(session, comicCharacter, id,className);
    }
}
