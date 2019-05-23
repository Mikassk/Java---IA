package Farmer.StatesBob;

import Farmer.Bob;
import Farmer.Messages.Entity;
import Farmer.Messages.EntityManager;
import Farmer.Messages.Message;
import Farmer.Messages.MessageDispatcher;
import Farmer.State;

public class Home implements State<Bob>{

    private static Home instance = null;

    private Home(){

    }

    public static Home getInstance(){
        if(instance == null){
            instance = new Home();
        }
        return instance;
    }

    @Override
    public void enter(Bob bob){
        System.out.println("Indo descansar...\n");
        bob.setBillyWorked(false);

        Entity billy = EntityManager.getInstance().getEntity("Billy");
        MessageDispatcher.getInstance().dispatchMessage(bob, billy, "GetToWork!", null);
    }

    @Override
    public void execute(Bob bob){
        System.out.println("Descansando...");
        bob.decreaseFatigue(5);
        System.out.printf("Fadiga: %d\n", bob.fadiga);

        if(bob.billyWorked && bob.notTired()){
            bob.getStateMachine().changeState(Mine.getInstance());
        }
        else if(bob.notTired()){
            System.out.println("Esperando o Billy terminar de trabalhar...\n");
        }
    }

    @Override
    public void exit(Bob bob){
        System.out.println("De volta ao trabalho...\n");
    }

    @Override
    public boolean onMessage(Bob bob, Message msg){
        if(msg.getMessage().compareToIgnoreCase("JobsDone!") == 0){
            bob.setBillyWorked(true);
            return true;
        }
        else {
            return false;
        }
    }

}
