package Farmer.StatesBob;

import Farmer.Bob;
import Farmer.GlobalStates.BobBathroom;
import Farmer.Messages.Message;
import Farmer.State;

import java.util.Random;

public class BobGlobalState implements State<Bob> {

    private static BobGlobalState instance = null;

    private BobGlobalState(){

    }

    public static BobGlobalState getInstance(){
        if(instance == null){
            instance = new BobGlobalState();
        }
        return instance;
    }

    @Override
    public void enter(Bob bob){

    }

    @Override
    public void execute(Bob bob){
        Random r = new Random();
        int rand = r.nextInt(10);

        if(rand == 1){
            bob.getStateMachine().changeState(BobBathroom.getInstance());
        }

    }

    @Override
    public void exit(Bob bob){

    }

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
