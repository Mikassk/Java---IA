import Farmer.Billy;
import Farmer.Bob;

public class Main{

    public static void main(String[] args) throws InterruptedException{

        Bob bob = new Bob();
        Billy billy = new Billy();

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            billy.update();
            bob.update();
        }

    }

}
