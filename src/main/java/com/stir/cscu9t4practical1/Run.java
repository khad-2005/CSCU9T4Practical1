package com.stir.cscu9t4practical1;
public class Run extends TrainingSession {
    public Run(String n, int d, int m, int y, int h, int min, int s, float dist,Integer Re,Integer R) {
        super(n, d, m, y, h, min, s, dist,Re,R);
    }

    public String getEntry() {
        return getName() + " ran " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec() + " on " + getDay() + "/" + getMonth() + "/" + getYear() + "/" + "with Repetitions of"+ "/" +getRepetitions()+ "/" +" and with a Recovery of"+ "/" +getRecovery()+ "\n";
    }
}

