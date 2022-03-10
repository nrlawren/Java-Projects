// Import the scanner
import java.util.*;

/**
 * In this program we are calculating the planar and spherical distances between two locations,
 * given their latitude and longitude and the planar and spherical formulas
 *
 * @author Nash Lawrence
 */
 public class DistanceCalculator {
    /** create final variables for the Earth radius to be used in the formulas,
     * as well as the constraints for the minimum/maximum degrees longitude and
     * latitude that a location can be 
     */
    public static final double EARTH_RADIUS = 3959; //miles
    public static final double MIN_LATITUDE = -90; //degrees
    public static final double MAX_LATITUDE = 90; //degrees
    public static final double MIN_LONGITUDE = -180; //degrees
    public static final double MAX_LONGITUDE = 180; //degrees
    
    /**
    * Calculates the distance between two points on the earth's surface assuming
    * the spherical earth has been projected to a plane.
    * This method assumes the input values are valid.
    *
    * @param latitude1 latitude of first point in degrees
    * @param longitude1 longitude of first point in degrees
    * @param latitude2 latitude of second point in degrees
    * @param longitude2 longitude of second point in degrees
    * @return planar distance in miles between the two points
    */
    public static double calculatePlanarDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        latitude1 = (latitude1 * (Math.PI/180));
        longitude1 = (longitude1 * (Math.PI/180));
        latitude2 = (latitude2 * (Math.PI/180));
        longitude2 = (longitude2 * (Math.PI/180));
        
        double differenceLatitude = (latitude1 - latitude2);
        double differenceLongitude = (longitude1 - longitude2);
        double averageLatitude = (latitude1 + latitude2)/2;
        double planarDistance;
        planarDistance = (EARTH_RADIUS * ((Math.sqrt(Math.pow(differenceLatitude, 2.0) + ((Math.pow(Math.cos(averageLatitude) * differenceLongitude, 2.0)))))));
        
        return planarDistance;
    }
    
    /**
     * Calculates the spherical distance between two points on the earth's surface.
     * This method assumes the input values are valid.     
     * 
     * @param latitude1 latitude of first point in degrees
     * @param longitude1 longitude of first point in degrees
     * @param latitude2 latitude of second point in degrees
     * @param longitude2 longitude of second point in degrees
     * @return spherical distance in miles between the two points
     */ 
    public static double calculateSphericalDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        latitude1 = (latitude1 * (Math.PI/180));
        longitude1 = (longitude1 * (Math.PI/180));
        latitude2 = (latitude2 * (Math.PI/180));
        longitude2 = (longitude2 * (Math.PI/180));
        
        double longitudeDifference = (longitude1 - longitude2);
        double sphericalDistance;
        sphericalDistance = (EARTH_RADIUS * ((Math.acos(Math.sin(latitude1) * (Math.sin(latitude2)) + (Math.cos(latitude1) * (Math.cos(latitude2) * Math.cos(longitudeDifference)))))));
        
        return sphericalDistance;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double firstLatitude;
        double firstLongitude;
        double secondLatitude;
        double secondLongitude;
        char calculationType;
        
        System.out.print("Location 1 Latitude: ");
        firstLatitude = input.nextDouble();
        
        if ((firstLatitude < MIN_LATITUDE) || (firstLatitude > MAX_LATITUDE)) {
            System.out.println("Invalid latitude");
            System.exit(1);
        }
        
        System.out.print("Location 1 Longitude: ");
        firstLongitude = input.nextDouble();
        
        if ((firstLongitude < MIN_LONGITUDE) || (firstLongitude > MAX_LONGITUDE)) {
            System.out.println("Invalid longitude");
            System.exit(1);
        }
        
        System.out.print("Location 2 Latitude: ");
        secondLatitude = input.nextDouble();
        
        if ((secondLatitude < MIN_LATITUDE) || (secondLatitude > MAX_LATITUDE)) {
            System.out.println("Invalid latitude");
            System.exit(1);
        }
        
        System.out.print("Location 2 Longitude: ");
        secondLongitude = input.nextDouble();
        
        if ((secondLongitude < MIN_LONGITUDE) || (secondLongitude > MAX_LONGITUDE)) {
            System.out.println("Invalid longitude");
            System.exit(1);
        }
        
        System.out.print("Distance Calculation Type (P-lanar, S-pherical): ");
        calculationType = input.next().charAt(0);
        
        if ((calculationType == 'p') || (calculationType == 'P')) {
            System.out.println("");
            System.out.print("Planar Distance: ");
            System.out.printf("%.2f", calculatePlanarDistance(firstLatitude, firstLongitude, secondLatitude, secondLongitude));
            System.out.print(" mi.");
        }
        else if ((calculationType == 's') || (calculationType == 'S')) {
            System.out.println(""); 
            System.out.print("Spherical Distance: ");
            System.out.printf("%.2f", calculateSphericalDistance(firstLatitude, firstLongitude, secondLatitude, secondLongitude));
            System.out.print(" mi.");
        }
        else {
            System.out.println("Invalid type");
            System.exit(1);
        }
        
        
 
    
    
    
    }
    
    
 }
    
       