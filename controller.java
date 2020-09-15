import java.util.*;

public class controller {

    private dog[] dogs;
    private int iDogCount;
    private int iCycles;
    private int iFleaGender;

    public controller() {
        iDogCount = 0;
        iCycles = 0;
        iFleaGender = 0;
    }

    public void createDogs(){ // instantiates dog objects
        Scanner sc = new Scanner(System.in);
        System.out.println("How many dogs should be managed? ");
        iDogCount = sc.nextInt();

        while (iDogCount <= 0) {
            sc = new Scanner(System.in);
            System.out.println("Must be 1 or more dogs. How many dogs should be managed? ");
            iDogCount = sc.nextInt();
        }

        System.out.println("How many cycles of activity should all the dogs go through? ");
        sc = new Scanner(System.in);
        iCycles = sc.nextInt();

        while (iCycles <= 0) {
            sc = new Scanner(System.in);
            System.out.println("Must be 1 or more cycles. How many cycles of activity should all the dogs go through? ");
            iCycles = sc.nextInt();
        }

        dogs = new dog[iDogCount]; // create array of dog objects from user input count

        for (int i = 0; i < iDogCount; i++) { // instantiate each dog object in array
            dogs[i] = new dog();

            String sFriendly; // string will either be "not" or "" to identify whether object's friendly boolean is or isn't

            if (dogs[i].friendly == true) {
                sFriendly = "not ";
            } else {
                sFriendly = "";
            }

            System.out.println("Dog #" + i + " created and is " + sFriendly + "friendly.");
        }


    }

    public void actionOfDogs() { // runs various dog actions over user chosen iterations
        int iRandDog; // used to store a random array index for the dog a flea will jump to

        for (int i = 0; i < iCycles; i++) {
            System.out.println("\n\nCycle #" + (i+1) + ":");
            for (int j = 0; j < iDogCount; j++) {
                System.out.println("\nDog #" + j + ":");
                
                //let's show the flea count before taking action. 
                System.out.println("Flea count before doing anything: " + dogs[j].countFlea()); // not the most efficient but this will set the flea fleaCount variable to the correct count on first iteration.

                int oldCount = dogs[j].countFlea();

                iFleaGender = dogs[j].doAction(); // if doAction() returns a gender then a random dog will have addFlea(iFleaGender) called

                int count = dogs[j].countFlea();

                if(count != oldCount) {
                    System.out.println("Flea count has changed from previous iteration.");
                }
                
                if ((iFleaGender != -1) && (iDogCount > 1)) { // if iFleaGender == -1 then there is no flea jumping and if iDogCount == 1 then there is no dog to jump to
                    iRandDog = (int)((Math.random() * iDogCount));
                    dogs[iRandDog].addFlea(iFleaGender); // random dog that a flea from current dog just jumped to
                    System.out.println("A flea just jumped from this dog (dog #" + j + ") to dog #" + iRandDog + ".");
                }

                System.out.println("Flea count: " + dogs[j].countFlea()); // not the most efficient but this will set the flea fleaCount variable to the correct count on first iteration.

                //if (dogs[j].hasCountChanged() && i != 0) { // if i == 0 then we are on the first cycle which means that the count of all new dogs has gone from 0 to some number
                  //  System.out.println("Flea count has changed from previous iteration.");// + dogs[j].countFlea());
                //}

            }
        }
    }

}


/** sudo sudo code.
 * it's like sudo code but even more lazy.
 * main(args) {
 *      either ask user for how many dogs or take it from command line args.
 *      create array of that size of dogs.
 *
 *
 *      while(user doesn't quit) {
 *              foreach(dog) {
 *                  return = dog[i].doAction();
 *
 *                  if(return != -1) {
 *                          randomly select dog from list.
 *                          dog.addFlea(return);
 *                  }
 *              }
 *          ask if user wants to quit.
 *      }
 * }
 */