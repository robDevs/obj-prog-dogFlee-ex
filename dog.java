import java.util.Random;

public class dog {
    //create flea array on construction and other details on construction
    String descriptor = "";
    private int fleaCount;
    flea[] fleaPop; //fleaPop = flea population
    boolean friendly = true; //as we all know, dogs are friendly by nature
    Random rand = new Random();
    private boolean bCountChanged = false; // instantiates a boolean to keep track of whether the flea count on a dog has changed

    public dog() {
        fleaCount = 0;
        fleaPop = new flea[101];

        for (int i = 0; i < 101; i++) { // instantiate each flea object in array
            fleaPop[i] = new flea();
            fleaPop[i].set_removed(true);
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
                return -11;
        }

    }
    //These 2 functions print text and execute fleaJump()
    public int tailWag(){
        System.out.println("The dog happily wags their tail.");
        if(fleaCount > 0) {
            return fleaJump(pickFlea());
        }
        else return -1;
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
        if(i < 0) return -1;
        fleaCount -= 1;
        int g = fleaPop[i].get_gender();
        fleaPop[i].set_removed(true);
        return g;
    }
    public void fleaBreed(){
        //iterate through fleaPop. if not removed, check gender
        boolean gender0 = false;
        boolean gender1 = false;
        for (int i = 0; i < fleaPop.length; i++){
            if(fleaCount > 100) return;
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
                    fleaPop[i].set_removed(false);
                    fleaCount += 1;
                }
            }
        }
    }
    public int countFlea(){
        //I'm looking for a bug so I just simplified this section. 
        //when adding a flea increase count, 
        //when a flea jumps decrease count. 
        return this.fleaCount; // no need to use "this" here. this is used when a local variable has same name as a var at the higher class scope. 
        /**
         * EG: 
         * public void setNum(int num) {
         *      this.num = num;         //num refers to the var passed to the function. 
         *                              // this.num refers to the var that the class owns. 
         *                              // afaik this because the var owned by the class is not known about by other bits of code at compilation. 
         * 
         * }
         * 
         */
    }

    public boolean hasCountChanged(){
        return bCountChanged;
    }

    public int pickFlea(){
        if(fleaCount == 0) return -1;
        for(int i = 0; i < 101; i++) {
            if(fleaPop[i].get_removed() == false) {
                return i;
            }
        }
        return -1;
    }
    public void addFlea(int gender){
        if(fleaCount > 100) return;
        for (int i = 0; i < fleaPop.length; i++){
            if (fleaPop[i].get_removed()) {
                fleaPop[i] = new flea();
                fleaPop[i].set_gender(gender);
                fleaCount += 1;
                break;
            }
        }
        fleaBreed();
    }
}
