package org.example;

enum clientType {
    REGULAR,
    PREMIUM
}

public class Client {
    private String name;
    private int visitingStartTime;
    private int visitingEndTime;
    private clientType type;
    public Client(String name, int visitingStartTime, int visitingEndTime, clientType type) {
        this.name = name;
        this.visitingStartTime = visitingStartTime;
        this.visitingEndTime = visitingEndTime;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getVisitingStartTime() {
        return visitingStartTime;
    }
    public void setVisitingStartTime(int visitingStartTime) {
        this.visitingStartTime = visitingStartTime;
    }

    public int getVisitingEndTime() {
        return visitingEndTime;
    }
    public void setVisitingEndTime(int visitingEndTime) {
        this.visitingEndTime = visitingEndTime;
    }

    public clientType getType() {
        return type;
    }
    public void setType(clientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", visitingStartTime=" + visitingStartTime +
                ", visitingEndTime=" + visitingEndTime +
                ", type=" + type +
                '}';
    }
}
