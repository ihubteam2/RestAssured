package Utils;

import java.io.File;

public class PayLoad {



    public static File postUser(){
        String localDir = System.getProperty("user.dir");
        File file = new File(localDir+"/src/test/java/Data/data.json");
        return file;
    }
}
