// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<TrainingSession> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<TrainingSession>();
    } //constructor
    
    // add a record to the list
   public void addEntry(TrainingSession e){
       tr.add(e);    
   } // addClass
   
   // look up the TrainingSession of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<TrainingSession> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          TrainingSession current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }

   public String findAllEntriesByDate(int d, int m, int y) {
    ListIterator<TrainingSession> iter = tr.listIterator();
    String result = "";
    while (iter.hasNext()) {
        TrainingSession current = iter.next();
        if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
            result += current.getEntry();
        }
    }
    return result;
}

public String lookupEntries(int d, int m, int y) {
    ListIterator<TrainingSession> iter = tr.listIterator();
    StringBuilder result = new StringBuilder("Sorry couldn't find anything for this date");
    while (iter.hasNext()) {
        TrainingSession current = iter.next();
        if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
            result = new StringBuilder(current.getEntry());
        }
    }
    return result.toString();
}
   
} // TrainingRecord
