package Farmer.StatesBilly;

import Farmer.Billy;
import Farmer.GlobalStates.BillyBathroom;
import Farmer.Messages.Message;
import Farmer.State;

import java.util.Random;

public class BillyGlobalState implements State<Billy>{

    private static BillyGlobalState instance = null;

    private BillyGlobalState(){

    }

    public static BillyGlobalState getInstance(){
        if(instance == null){
            instance = new BillyGlobalState();
        }
        return instance;
    }

    @Override
    public void enter(Billy billy){

    }

    @Override
    public void execute(Billy billy){
        Random r = new Random();
        int rand = r.nextInt(10);

        if(rand == 1){
            billy.getStateMachine().changeState(BillyBathroom.getInstance());
        }

    }

    @Override
    public void exit(Billy billy){

    }

    public boolean onMessage(Billy billy, Message msg){
        if(msg.getMessage().compareTo("GetToWork!") == 0){
            billy.getStateMachine().changeState(FakeWork.getInstance());
            return true;
        }
        else{
            return false;
        }
    }

}
