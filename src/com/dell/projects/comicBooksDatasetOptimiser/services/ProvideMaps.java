package com.dell.projects.comicBooksDatasetOptimiser.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvideMaps {

    private Map<String, Object> categoryMap;

    private Map<String, Object> planetMap;

    private Map<String, Object> powerMap;

    private List<Map<String,Object>> mapList;

    public ProvideMaps(){
        categoryMap=new HashMap<String,Object>();

        mapList.add(categoryMap);

        planetMap=new HashMap<String,Object>();

        mapList.add(planetMap);

        powerMap=new HashMap<String, Object>();

        mapList.add(powerMap);

    }

    public List<Map<String,Object>> getHashMaps(){
    return mapList;
    }

}
