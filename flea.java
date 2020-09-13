import java.util.Random;
public class flea {
    //create vars for gender and a random int generator. 
    private int gender;
    Random rand; 

    private boolean removed;

    public flea(){
        //randomly assign gender. 
        //doesn't really matter if 1 = male or 0 = male since we just care about if there is an opposite gender. 
        rand = new Random();

        removed = false;

        gender = rand.nextInt(1);
    }

    //just return the gender.
    public int jump() {
        return gender;
    }

    //setter functoins. 
    public void set_gender(int gender) {
        this.gender = gender;
    }

    public void set_removed(boolean removed) {
        this.removed = removed;
    }

    //getter functions
    public int get_gender() {
        return gender;
    }
    
    public boolean get_removed() {
        return removed;
    }
}
