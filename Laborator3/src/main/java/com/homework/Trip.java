package com.homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Clasa care reprezintă o călătorie într-un anumit oraș.
 */
class Trip {
    /**
     * Numele orașului.
     */
    private String cityName;
    /**
     * Perioada de timp a călătoriei.
     */
    private String periodOfTime;
    /**
     * Lista atracțiilor planificate pentru călătorie.
     */
    private List<Attraction> attractions;

    /**
     * Constructor pentru inițializarea călătoriei.
     *
     * @param cityName     Numele orașului.
     * @param periodOfTime Perioada de timp a călătoriei.
     * @param attractions  Lista atracțiilor planificate pentru călătorie.
     */
    public Trip(String cityName, String periodOfTime, List<Attraction> attractions) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = attractions;
    }

    /**
     * Adaugă o atracție în lista de atracții pentru călătorie.
     *
     * @param attraction Atracția de adăugat.
     */
    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    /**
     * Returnează lista de atracții planificate pentru călătorie.
     *
     * @return Lista de atracții planificate pentru călătorie.
     */
    public List<Attraction> getAttractions() {
        return attractions;
    }

    /**
     * Afișează locațiile vizitabile și non-plătibile ale călătoriei, sortate după ora de deschidere.
     */
    public void displayVisitableNonPayableLocations() {
        List<Attraction> visitableNonPayable = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNonPayable.add(attraction);
            }
        }


        for (Attraction attraction : visitableNonPayable) {
            System.out.println(attraction.getName() + " - Orar: ");
            Map<LocalDate, Pair<LocalTime, LocalTime>> timetable = ((Visitable) attraction).getTimetable();
            if (timetable != null && !timetable.isEmpty()) {
                for (Map.Entry<LocalDate, Pair<LocalTime, LocalTime>> entry : timetable.entrySet()) {
                    Pair<LocalTime, LocalTime> timeInterval = entry.getValue();
                    System.out.println("    " + entry.getKey() + ": " + ((Visitable) attraction).getOpeningHour(entry.getKey()));
                }
            } else {
                System.out.println("    Nu există orar disponibil.");
            }
        }
    }
}
