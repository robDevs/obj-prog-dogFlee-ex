import java.util.*;

public class controller {

    public void createDogs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many dogs should be managed? ");
        int iDogCount = sc.nextInt();

        dog[] dogs = new dog[iDogCount]; // array of dog objects from user input count

        for (int i = 0; i < iDogCount; i++) { // instantiate each dog object in array
            dogs[i] = new dog();
        }
        for (int i = 0; i < iDogCount; i++) {
            String sFriendly; // string will either be "not" or "" to identify whether object's friendly boolean is or isn't

            if (dogs[i].friendly == true) {
                sFriendly = "not ";
            }
            else {
                sFriendly = "";
            }

            System.out.println("Dog #" + i + " is " + sFriendly + "friendly.");

            System.out.println("Number of fleas: " + dogs[i].fleaPop.length);
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