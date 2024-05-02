package com.stir.cscu9t4practical1;
public class Cycle extends TrainingSession {
    public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist,String t, String tem) {
        super(n, d, m, y, h, min, s, dist,t,tem);
    }

    public String getEntry() {
        return getName() + " cycled " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec() + " on " + getDay() + "/" + getMonth() + "/" + getYear() + "/" + "on the terrain"+ "/" +getTerrain()+ "/" +"with a tempo of"+ "/" +getTempo()+"\n";
    }
}
