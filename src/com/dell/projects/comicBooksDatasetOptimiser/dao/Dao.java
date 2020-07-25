package com.dell.projects.comicBooksDatasetOptimiser.dao;

import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class Dao<T extends Object>{



    public T create(Session session,T t) {
        session.save(t);
        return t;
    }

    public T readSingle(Session session,T t,long id,String className) throws
            NotFoundException {
        String hibernateQuery="FROM "+className+" where "+className+".id="+id;
        Query query = session.createQuery(hibernateQuery);
        return (T)query.getSingleResult();
    }

    public T update(Session session, T t) {
        session.merge(t);
        return null;
    }

    public T Delete(Session session,T t) {
         session.remove(t);
         return t;
    }


}
