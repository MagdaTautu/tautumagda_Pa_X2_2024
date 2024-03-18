package org.example;

abstract class Attraction implements Comparable<Attraction> {
    protected String name;

    public Attraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Attraction other) {
        if (!name.isEmpty())
            return this.name.compareTo(other.name);
        else return 0;
    }
}
