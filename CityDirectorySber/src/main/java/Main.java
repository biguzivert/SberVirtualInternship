import model.City;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/data.csv";
        Path path = Paths.get(filePath);
        ArrayList<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(path);
            scanner.useDelimiter("\\n");
            while(scanner.hasNext()){
                City city = new City();
                String[] cityInfo = scanner.next().split(";");
                city.setName(cityInfo[1]);
                city.setRegion(cityInfo[2]);
                city.setDistrict(cityInfo[3]);
                city.setPopulation(Integer.parseInt(cityInfo[4]));
                city.setFoundation(cityInfo[5]);
                cities.add(city);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println(cities.toString());
    }
}
