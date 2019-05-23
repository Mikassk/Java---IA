package Farmer.GlobalStates;

import Farmer.Billy;
import Farmer.Messages.Message;
import Farmer.State;

public class BillyBathroom implements State<Billy> {

    private static BillyBathroom instance = null;

    private BillyBathroom(){

    }

    public static BillyBathroom getInstance(){
        if(instance == null){
            instance = new BillyBathroom();
        }
        return instance;
    }

    public void enter(Billy billy){

    }

    public void execute(Billy billy){
        System.out.println("Hora do banheiro do Billy...\n");
        billy.getStateMachine().revertToPreviousState();
    }

    public void exit(Billy billy){

    }

    public boolean onMessage(Billy billy, Message msg){
        return false;
    }

}
