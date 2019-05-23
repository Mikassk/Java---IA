package Farmer.GlobalStates;

import Farmer.Bob;
import Farmer.Messages.Message;
import Farmer.State;

public class BobBathroom implements State<Bob> {

    private static BobBathroom instance = null;

    private BobBathroom(){

    }

    public static BobBathroom getInstance(){
        if(instance == null){
            instance = new BobBathroom();
        }
        return instance;
    }

    public void enter(Bob bob){

    }

    public void execute(Bob bob){
        System.out.println("Hora do banheiro do Bob...\n");
        bob.getStateMachine().revertToPreviousState();
    }

    public void exit(Bob bob){

    }

    @Override
    public boolean onMessage(Bob bob, Message msg){
        return false;
    }

}
