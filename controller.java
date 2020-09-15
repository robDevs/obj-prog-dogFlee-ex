import java.util.*;

public class controller {

    public void createDogs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many dogs should be managed? ");
        int iDogCount = sc.nextInt();
        System.out.println("How many cycles of activity should all the dogs go through? ");
        sc = new Scanner(System.in);
        int iCycles = sc.nextInt();

        dog[] dogs = new dog[iDogCount]; // create array of dog objects from user input count

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

        for (int i = 0; i < iCycles; i++) {
            System.out.println("\nCycle #" + (i+1) + ":\n");
            for (int j = 0; j < iDogCount; j++) {
                System.out.println("Dog #" + j + ":");
                dogs[j].doAction();

                System.out.println("Flea count: " + dogs[j].countFlea()); // not the most efficient but this will set the flea fleaCount variable to the correct count on first iteration. if I don't leave this in for all iterations the determination of which dogs flea status has changed does not work correctly just below. i am not yet sure why.

                if (dogs[j].hasCountChanged() && i != 0) { // if i == 0 then we are on the first cycle which means that the count of all new dogs has gone from 0 to some number
                    System.out.println("Flea count has changed from previous iteration: " + dogs[j].countFlea());
                }

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