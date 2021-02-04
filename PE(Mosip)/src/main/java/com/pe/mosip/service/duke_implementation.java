package com.pe.mosip.service;
//import com.mysql.cj.util.TestUtils;
import no.priv.garshol.duke.*;
import no.priv.garshol.duke.Record;
import no.priv.garshol.duke.matchers.PrintMatchListener;
//import no.priv.garshol.duke.utils.TestUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.priv.garshol.duke.Duke;

public class duke_implementation {
    public static void main(String[] argv) throws Exception {
            Configuration config = ConfigLoader.load("src/main/resources/duke_cfg.xml");
            Processor proc = new Processor(config);
           // Duke duke=new Duke();

            // System.out.println(proc);

        proc.addMatchListener(new PrintMatchListener(true, true, true, true,
                    config.getProperties(),
                    true));

//        System.out.println(config.isDeduplicationMode());
        showdata(config);
            proc.link();
            proc.close();
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
                Record r = it.next();
                PrintMatchListener.prettyPrint(r, props);
                System.out.println("");
            }
            it.close();
        }
    }
}
