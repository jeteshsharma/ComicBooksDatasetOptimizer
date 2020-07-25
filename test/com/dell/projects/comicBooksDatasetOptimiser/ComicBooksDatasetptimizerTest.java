package com.dell.projects.comicBooksDatasetOptimiser;

import com.dell.projects.comicBooksDatasetOptimiser.services.EntityManagement;
import com.dell.projects.comicBooksDatasetOptimiser.services.Parse;
import com.dell.projects.comicBooksDatasetOptimiser.services.ProvideFileReadBuffer;
import com.dell.projects.comicBooksDatasetOptimiser.services.ProvideMaps;
import com.dell.projects.comicBooksDatasetOptimiser.utilities.SessionManagement;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

public class ComicBooksDatasetptimizerTest {

    @Test
    public  void test(){
        EntityManagement em=new EntityManagement();

        ProvideFileReadBuffer readerService=new ProvideFileReadBuffer();

        String fileAddress="/home/jetesh/Documents/comic_characters_dataset";

        Parse parseService=new Parse(readerService.getReader(fileAddress));


        SessionManagement sessionManagement =new SessionManagement();

        sessionManagement.setupSessionFactory();

        Session session = sessionManagement.getSession();


        ProvideMaps provideMapsService=new ProvideMaps();


        String[] entityValues=null;


        while((entityValues=parseService.parseSingleLine())!=null){
            em.persistEntities(em.createEntityObjects(entityValues),session,
                    provideMapsService.getHashMaps());

        }


        sessionManagement.flushSession(session);

        readerService.close();




    }


}
