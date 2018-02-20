package c4q.com.final_prep.modelclasses;

/**
 * Created by D on 2/18/18.
 */

public class Name {

    private String title;
    private String first;
    private String last;

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFullName(){
      return  title + " "+ first+ " "+ last;
    }
}
