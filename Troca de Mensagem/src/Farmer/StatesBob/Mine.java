package Farmer.StatesBob;

import Farmer.Bob;
import Farmer.Messages.Message;
import Farmer.State;

public class Mine implements State<Bob>{

    private static Mine instance = null;

    private Mine(){

    }

    public static Mine getInstance(){
        if(instance == null){
            instance = new Mine();
        }
        return instance;
    }

    @Override
    public void enter(Bob bob){
        System.out.println("Indo minerar...\n");
    }

    @Override
    public void execute(Bob bob){
        System.out.println("Minerando...");
        bob.addGoldInPocket();
        System.out.printf("Bolso: %d\n", bob.bolso);

        bob.increaseFatigue(2);
        bob.increaseThirsty(1);

        if(bob.pocketsFull()){
            bob.getStateMachine().changeState(Bank.getInstance());
        }
        if(bob.isThirsty()){
            bob.getStateMachine().changeState(Drink.getInstance());
        }
    }

    @Override
    public void exit(Bob bob){
        System.out.println("Pausa para outra coisa...\n");
    }

    @Override
    public boolean onMessage(Bob bob, Message msg){
        return false;
    }

}
