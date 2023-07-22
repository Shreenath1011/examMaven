import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class ReadFromPropertiesFile {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("C:\\Users\\User\\IntelliJWorkspace\\examMaven\\src\\main\\resources\\application.properties");
            Properties properties = new Properties();
            properties.load(fileReader);
            String name = properties.getProperty("name");
            System.out.println("Name is :" + name);
            String email = properties.getProperty("email");
            System.out.println("Email is :" + email);


            //writing to properties file
            FileWriter fileWriter = new FileWriter("C:\\Users\\User\\IntelliJWorkspace\\examMaven\\src\\main\\resources\\application.properties");
            properties.setProperty("roll", "3");
            properties.setProperty("password", "123");
            properties.store(fileWriter, "Writing back to properties file..");

        }catch( Exception e){
            System.out.println("Erroe::"+ e.getMessage());
        }
    }
}
