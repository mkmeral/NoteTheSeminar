package org.tevitol.incnet.notethesemianar;

import java.util.concurrent.ExecutionException;

/**
 * Created by mkmer on 30.05.2015.
 */
public class generateForTabs {

    public String[][] parsedJSON(String time) throws ExecutionException, InterruptedException {

        //String data = new GetJSON().execute("/event/list", "time", time).get();

        //return new eventsJSON().execute(data).get();
        String[][] output = new String[10][10];

        output[0] = new String[]{"Seminar1", "Seminar2", "Seminar3", "Seminar4", "Seminar5"};
        output[1] = new String[]{"Ali", "Mehmet", "Ayse", "Anan", "Eben"};
        output[2] = new String[]{"3", "15", "17", "1", "99"};
        output[3] = new String[]{"1", "2", "3", "4", "5"};
        return output;

    }
}
