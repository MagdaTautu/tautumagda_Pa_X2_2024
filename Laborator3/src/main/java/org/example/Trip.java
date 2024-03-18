package org.example;
import java.util.List;

class Trip {
    private String cityName;
    private String periodOfTime;
    private List<Attraction> attractions;

    public Trip(String cityName, String periodOfTime, List<Attraction> attractions) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = attractions;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }
}
