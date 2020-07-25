package com.dell.projects.comicBooksDatasetOptimiser.services;

import com.dell.projects.comicBooksDatasetOptimiser.dao.*;
import com.dell.projects.comicBooksDatasetOptimiser.entity.Category;
import com.dell.projects.comicBooksDatasetOptimiser.entity.ComicCharacter;
import com.dell.projects.comicBooksDatasetOptimiser.entity.Planet;
import com.dell.projects.comicBooksDatasetOptimiser.entity.Power;
import org.hibernate.Session;

import java.util.*;

public class EntityManagement {

    private Dao dao = new Dao();

    private CategoryDao categoryDao = new CategoryDao();

    private ComicCharacterDao comicCharacterDao = new ComicCharacterDao();

    private PlanetDao planetDao = new PlanetDao();

    private PowerDao powerDao = new PowerDao();


    public List<Object> createEntityObjects(String[] entityValues) {

        List<Object> objectList = new ArrayList<Object>();

        Category category = new Category(entityValues[0]);


        ComicCharacter comicCharacter = new ComicCharacter(entityValues[1],
                entityValues[2].split(","));


        String[] planetNames = entityValues[3].split(",");

        List<Planet> planetObjectList = new ArrayList<Planet>();

        for (int j = 0; j < planetNames.length; j++)
            planetObjectList.add(new Planet(planetNames[j]));

        String[] powerNames = entityValues[4].split(",");

        List<Power> powerObjectList = new ArrayList<Power>();

        for (int j = 0; j < powerNames.length; j++)
            powerObjectList.add(new Power(powerNames[j]));

        objectList.add(category);
        objectList.add(comicCharacter);
        objectList.add(planetObjectList);
        objectList.add(powerObjectList);

        return objectList;

    }

    public void persistEntities(List<Object> objectList, Session session, List<Map<String, Object>> maps) {

        Category category = categoryDao.create(session, (Category) objectList.get(0));


        List<Planet> planetObjectList = (List<Planet>) objectList.get(2);

        Set<Planet> planetObjectset = new HashSet<Planet>();

        for (Planet planet : planetObjectList)
            planetObjectset.add((Planet) drawOrCreate(maps.get(1), planet.getPlanetName(),
                    session, planet));

        List<Power> powerObjectList = (List<Power>) objectList.get(3);

        Set<Power> powerObjectset = new HashSet<Power>();

        for (Power power : powerObjectList)
            powerObjectset.add((Power) drawOrCreate(maps.get(2), power.getPower(),
                    session, power));

        ComicCharacter comicCharacter = (ComicCharacter) objectList.get(1);

        comicCharacter.setCategory(category);

        comicCharacter.setPlanets(planetObjectset);

        comicCharacter.setPowerSet(powerObjectset);

        comicCharacterDao.create(session, comicCharacter);

    }

    public Object drawOrCreate(Map<String, Object> map, String key,
                               Session session, Object object) {
        if (map.containsKey(key))
            return map.get(key);

        else {
            map.put(key, object);
            return dao.create(session, object);
        }


    }


}
