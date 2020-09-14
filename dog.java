import java.util.Random;

public class dog{
    //create flea array on construction
    //create other details on construction
    flea fleaPop[];
    boolean friendly = false;


    public dog(){
        fleaPop = new flea[101];
        if((int)((Math.random() * 2)) == 1){
            friendly = true;
        }


    }


    public void doAction() {
        int key = (int)((Math.random() * 5) + 1);
        switch(key){
            case 1:
                tailwag();
                break;
            case 2:
                play();
                break;
            case 3:
                bark();
                break;
            case 4:
                beg();
                break;
            case 5:
                shake();
                break;
            default:
                bark();
                break;
        }
    }

    public int tailwag(){
        System.out.println("");
        return fleaJump((int)((Math.random() * 101)));
    }
    public int play() {
        System.out.println("");
        return fleaJump((int)((Math.random() * 101)));
    }
    public void bark(){
        System.out.println("");
    }
    public void beg(){
        System.out.println("");
    }
    public void shake(){
        System.out.println("");
    }

    public int fleaJump(int i){
        return fleaPop[i].gender;
    }
}
