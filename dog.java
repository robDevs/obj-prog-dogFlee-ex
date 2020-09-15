import java.util.Random;

public class dog {
    //create flea array on construction and other details on construction
    String descriptor = "";
    int fleaCount = 0;
    flea[] fleaPop; //fleaPop = flea population
    boolean friendly = true; //as we all know, dogs are friendly by nature
    Random rand = new Random();
    private boolean bCountChanged = false; // instantiates a boolean to keep track of whether the flea count on a dog has changed

    public dog(){
        fleaPop = new flea[101];

        for (int i = 0; i < 101; i++) { // instantiate each flea object in array
            fleaPop[i] = new flea();
        }

        //decide if dog is friendly or not
        if(rand.nextBoolean()){
            friendly = false;
        }
        //decide if there's a starting flea
        if(rand.nextBoolean()){
            //decide starting flea's gender
            if(rand.nextBoolean()){
                addFlea(1);
            }
            else{
                addFlea(0);
            }
        }
    }


    public int doAction() {
        int key = (int)((Math.random() * 5) + 1);
        switch(key){
            case 1:
                return tailWag();
            case 2:
                return play();
            case 3:
                return bark();
            case 4:
                return beg();
            case 5:
                return shake();
            default:
                System.out.println("The dog stares blankly. It knows not what to do.");
                return 0;
        }

    }
    //These 2 functions print text and execute fleaJump()
    public int tailWag(){
        System.out.println("The dog happily wags their tail.");
        return fleaJump(pickFlea());
    }
    public int play() {
        System.out.println("The dog runs off to play with other dogs.");
        return fleaJump(pickFlea());
    }
    //These 3 functions merely print text
    public int bark(){
        System.out.println("The dog barks. *BARK!*");
        return -1;
    }
    public int beg(){
        System.out.println("The dog lies down, begging for food.");
        return -1;
    }
    public int shake(){
        System.out.println("As you reach out your hand, the dog shakes it happily.");
        return -1;
    }
    //fleaJump is the star of the show, selecting a flea to jump, return to controller, and remove itself from the fleaPop
    public int fleaJump(int i){
        int g = fleaPop[i].get_gender();
        fleaPop[i].set_removed(true);
        return g;
    }
    public void fleaBreed(){
        //iterate through fleaPop. if not removed, check gender
        boolean gender0 = false;
        boolean gender1 = false;
        for (int i = 0; i < fleaPop.length; i++){
            if (!fleaPop[i].get_removed()) {
                if (fleaPop[i].get_gender() == 0) {
                    gender0 = true;
                }
                if (fleaPop[i].get_gender() == 1) {
                    gender1 = true;
                }
            }
        }
        //if at least 1 of each gender, iterate through and fill empty slots with new fleas
        if (gender0 && gender1) {
            for (int i = 0; i < fleaPop.length; i++) {
                if (fleaPop[i].get_removed()) {
                    fleaPop[i] = new flea();
                }
            }
        }
    }
    public int countFlea(){
        int ct = 0;
        for (int i = 0; i < fleaPop.length; i++) {
            if (!fleaPop[i].get_removed()){
                ct++;
            }
        }

        if (this.fleaCount != ct) {
            this.fleaCount = ct;
            bCountChanged = true;
        }
        else {
            bCountChanged = false;
        }

        return this.fleaCount;
    }

    public boolean hasCountChanged(){
        return bCountChanged;
    }

    public int pickFlea(){
        int i = 0;
        boolean keepLooking= true;
        while(keepLooking) {
            int pick = rand.nextInt(101);
            if (!fleaPop[pick].get_removed()) {
                i = pick;
                keepLooking = false;
            }
        }
        return i;
    }
    public void addFlea(int gender){
        for (int i = 0; i < fleaPop.length; i++){
            if (fleaPop[i].get_removed()) {
                fleaPop[i] = new flea();
                fleaPop[i].set_gender(gender);
                break;
            }
        }
        fleaBreed();
    }
}
