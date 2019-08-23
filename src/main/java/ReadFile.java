import java.io.File;
import java.net.URL;

public class ReadFile {

    String fileName = null;

    public ReadFile(String fileName){
        this.fileName= fileName;
    }

    File getFileFromResources(){
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);

        System.out.println("Resource '" + fileName + "' is found at : " + resource);
        System.out.println("");

        try {
            return new File(resource.getFile());
        } catch (Exception e){
            System.out.println(e);
        }

        return  null;
    }

}
