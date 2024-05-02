package com.stir.cscu9t4practical1;
import java.util.*;
public abstract class TrainingSession {
    private String name;
    private Calendar dateAndTime;
    private float distance;
    private String terrain; 
    private String tempo;
    private Integer Repetitions;
    private Integer Recovery;
    private String Where;

    public TrainingSession(String n, int d, int m, int y, int h, int min, int s, float dist) {
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y, m - 1, d, h, min, s);
        dateAndTime = inst;
        distance = dist;
    }

    public TrainingSession(String n, int d, int m, int y, int h, int min, int s, float dist,String t, String tem) {
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y, m - 1, d, h, min, s);
        dateAndTime = inst;
        distance = dist;
        terrain = t; 
        tempo = tem;
    }

    public TrainingSession(String n, int d, int m, int y, int h, int min, int s, float dist,Integer Re, Integer R) {
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y, m - 1, d, h, min, s);
        dateAndTime = inst;
        distance = dist;
        Repetitions = Re; 
        Recovery = R;
    }

    public TrainingSession(String n, int d, int m, int y, int h, int min, int s, float dist,String W) {
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y, m - 1, d, h, min, s);
        dateAndTime = inst;
        distance = dist;
        Where = W;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return dateAndTime.get(Calendar.DATE);
    }

    public int getMonth() {
        return dateAndTime.get(Calendar.MONTH) + 1;
    }

    public int getYear() {
        return dateAndTime.get(Calendar.YEAR);
    }

    public int getHour() {
        return dateAndTime.get(Calendar.HOUR);
    }

    public int getMin() {
        return dateAndTime.get(Calendar.MINUTE);
    }

    public int getSec() {
        return dateAndTime.get(Calendar.SECOND);
    }

    public float getDistance() {
        return distance;
    }

    public String getTerrain() { 
        return terrain;
    }

    public String getTempo() { 
        return tempo;
    }

    public Integer getRepetitions() {
        return Repetitions;
    }

    public Integer getRecovery() {
        return Recovery;
    }

    public String getWhere() {
        return Where;
    }

    public abstract String getEntry();
}