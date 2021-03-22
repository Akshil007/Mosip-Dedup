package com.pe.mosip.service;
import no.priv.garshol.duke.*;

import no.priv.garshol.duke.Record;
import no.priv.garshol.duke.matchers.ClassDatabaseMatchListener;
import no.priv.garshol.duke.matchers.PrintMatchListener;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class duke_implementation{
    public ArrayList<String> identify() throws IOException, SAXException {
        Configuration config = ConfigLoader.load("src/main/resources/duke_cfg.xml");
        Processor proc = new Processor(config);
        InMemoryClassDatabase inMemoryClassDatabase=new InMemoryClassDatabase();
        ClassDatabaseMatchListener classDatabaseMatchListener=new ClassDatabaseMatchListener(config,inMemoryClassDatabase);
        proc.addMatchListener(classDatabaseMatchListener);

        showdata(config);
        proc.link();
        System.out.println("Information=" + inMemoryClassDatabase.getClassCount());
        Iterator<Collection<String>> i=inMemoryClassDatabase.getClasses();
        ArrayList<String> list=new ArrayList<>();
        while(i.hasNext())
        {
            list.addAll((ArrayList<String>) i.next());
            for(String s:list)
            {
                System.out.println(s);
            }
        }
        list.remove(0);
        proc.close();
        return list;
//        PrintMatchListener printMatchListener = new PrintMatchListener(true, true, true, true, config.getProperties(), true);
//        proc.addMatchListener(printMatchListener);
//
//        showdata(config);
//        proc.link();
//        System.out.println("Information=" + printMatchListener.getMatchCount());
//        proc.close();
    }
    private static void showdata(Configuration config) {
        List<Property> props = config.getProperties();
        List<DataSource> sources = new ArrayList();
        sources.addAll(config.getDataSources());
        sources.addAll(config.getDataSources(1));
        sources.addAll(config.getDataSources(2));

        for (DataSource src : sources) {
            RecordIterator it = src.getRecords();
            while (it.hasNext()) {
                Record r = (Record) it.next();
                PrintMatchListener.prettyPrint(r, props);
                System.out.println("");
            }
            it.close();
        }
    }
}
