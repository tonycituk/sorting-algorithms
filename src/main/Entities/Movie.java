package main.Entities;

/** 
 * Class to store the movie
 * 
 * @author Tonymartin15
*/
public class Movie {

    private String title;
    private int duration;
    private int budget;
    private float rate;
    private int ID;

    public Movie(int ID, String title, int duration, int budget, float rate) {
        this.title = title;
        this.duration = duration;
        this.budget = budget;
        this.rate = rate;
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String toString(){
        return this.title;
    }

}