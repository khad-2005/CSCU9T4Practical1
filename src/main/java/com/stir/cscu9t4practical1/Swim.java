package com.stir.cscu9t4practical1;
public class Swim extends TrainingSession {
    public Swim(String n, int d, int m, int y, int h, int min, int s, float dist,String W) {
        super(n, d, m, y, h, min, s, dist,W);
    }

    public String getEntry() {
        return getName() + " swam " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec() + " on " + getDay() + "/" + getMonth() + "/" + getYear() + "/" + "In the"+ "/" +getWhere() + "\n";
    }
}
