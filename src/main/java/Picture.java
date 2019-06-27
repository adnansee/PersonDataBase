import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Picture {


    public static void main(String[] args) {






    }
    private static byte[] getPictureFromUrl(String location){

    Path p = Paths.get(location);
    byte[] bytes = null;
    try{
        bytes = Files.readAllBytes(p);

    } catch (IOException e) {
        e.printStackTrace();
    }


        return bytes;
    }





}
