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