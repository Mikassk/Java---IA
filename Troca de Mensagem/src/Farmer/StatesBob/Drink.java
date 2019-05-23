package Farmer.StatesBob;

import Farmer.Bob;
import Farmer.Messages.Message;
import Farmer.State;

public class Drink implements State<Bob>{

    private static Drink instance = null;

    private Drink(){

    }

    public static Drink getInstance(){
        if(instance == null){
            instance = new Drink();
        }
        return instance;
    }

    @Override
    public void enter(Bob bob){
        System.out.println("Indo beber algo...\n");
    }

    @Override
    public void execute(Bob bob){
        System.out.println("Bebendo...");
        bob.decreaseThirsty(5);
        System.out.printf("Sede: %d\n", bob.sede);

        if(bob.notThirsty()){
            bob.getStateMachine().changeState(Mine.getInstance());
        }
    }

    @Override
    public void exit(Bob bob){
        System.out.println("De volta ao trabalho...\n");
    }

    @Override
    public boolean onMessage(Bob bob, Message msg){
        return false;
    }

}
