package com.dell.projects.comicBooksDatasetOptimiser.dao;

import com.dell.projects.comicBooksDatasetOptimiser.entity.Category;
import javassist.NotFoundException;
import org.hibernate.Session;

public class CategoryDao extends Dao<Category>{


    public Category read(Session session, Category category, long id) throws NotFoundException {
        String className="Category";
        return super.readSingle(session, category, id, className);
    }
}
