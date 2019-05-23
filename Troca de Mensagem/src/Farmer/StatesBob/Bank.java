package Farmer.StatesBob;

import Farmer.Bob;
import Farmer.Messages.Message;
import Farmer.State;

public class Bank implements State<Bob>{

    private static Bank instance = null;

    private Bank(){

    }

    public static Bank getInstance(){
        if(instance == null){
            instance = new Bank();
        }
        return instance;
    }

    @Override
    public void enter(Bob bob){
        System.out.println("Indo depositar dinheiro...\n");
    }

    @Override
    public void execute(Bob bob){
        System.out.println("Depositando...");
        bob.addGoldInBank();
        System.out.printf("Bolso: %d, Banco: %d\n", bob.bolso, bob.ouro);

        if(bob.tired()){
            bob.getStateMachine().changeState(Home.getInstance());
        }
        else{
            bob.getStateMachine().changeState(Mine.getInstance());
        }
    }

    @Override
    public void exit(Bob bob){
        System.out.println("Depositei!\n");
    }

    @Override
    public boolean onMessage(Bob bob, Message msg){
        return false;
    }

}
