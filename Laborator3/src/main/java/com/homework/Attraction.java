package com.homework;
/**
 * Clasa abstractă care reprezintă o atracție turistică.
 * Implementează interfața Comparable pentru a permite sortarea atracțiilor după nume.
 */
abstract class Attraction implements Comparable<Attraction> {
    /**
     * Numele atracției.
     */
    protected String name;
    /**
     * Constructor pentru inițializarea numelui atracției.
     *
     * @param nume Numele atracției.
     */
    public Attraction(String name) {
        this.name = name;
    }
    /**
     * Metodă pentru a obține numele atracției.
     *
     * @return Numele atracției.
     */
    public String getName() {
        return name;
    }
    /**
     * Compară această atracție cu o altă atracție în funcție de nume.
     *
     * @param other O altă atracție cu care se compară.
     * @return Un număr negativ, zero sau un număr pozitiv dacă această atracție este mai mică, egală sau mai mare decât cealaltă atracție.
     */
    @Override
    public int compareTo(Attraction other) {
        if (!name.isEmpty())
            return this.name.compareTo(other.name);
        else return 0;
    }
}
