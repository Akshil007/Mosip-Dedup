package com.pe.mosip.service;
import com.pe.mosip.bean.Comparison_Result;
import com.pe.mosip.dao.ThreadDao;
import com.pe.mosip.dao.implementation.ThreadDaoimpl;
import no.priv.garshol.duke.*;

import no.priv.garshol.duke.Record;
import no.priv.garshol.duke.matchers.ClassDatabaseMatchListener;
import no.priv.garshol.duke.matchers.PrintMatchListener;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class duke_implementation{
    public ArrayList<Comparison_Result> identify(String ConfigFilePath, String ThreadName) throws IOException, SAXException {
        ThreadDao threadDao = new ThreadDaoimpl();

        Configuration config = ConfigLoader.load(ConfigFilePath);
        Processor proc = new Processor(config);

        //for storing and getting output in memory
        InMemoryClassDatabase inMemoryClassDatabase=new InMemoryClassDatabase();
        ClassDatabaseMatchListener classDatabaseMatchListener=new ClassDatabaseMatchListener(config,inMemoryClassDatabase);
        proc.addMatchListener(classDatabaseMatchListener);

        //for printing output on terminal
        PrintMatchListener printMatchListener = new PrintMatchListener(true, true, true, true, config.getProperties(), true);
        proc.addMatchListener(printMatchListener);

        showdata(config);
        proc.link();
        Iterator<Collection<String>> i=inMemoryClassDatabase.getClasses();
        ArrayList<Comparison_Result> ans=new ArrayList<>();
        while(i.hasNext())
        {
            Comparison_Result comparison_result=new Comparison_Result();
            ArrayList<String> list = (ArrayList<String>) i.next();
            comparison_result.setRecord(threadDao.getRecord(list.get(0), ThreadName));
            list.remove(0);
            comparison_result.setMatching_ids(list);
            ans.add(comparison_result);
        }

        proc.close();

        return ans;
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
