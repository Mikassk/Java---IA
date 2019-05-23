package Farmer.StatesBilly;

import Farmer.Billy;
import Farmer.Messages.Entity;
import Farmer.Messages.EntityManager;
import Farmer.Messages.Message;
import Farmer.Messages.MessageDispatcher;
import Farmer.State;

import java.util.Random;

public class FakeWork implements State<Billy>{

    private static FakeWork instance = null;

    private FakeWork(){

    }

    public static FakeWork getInstance(){
        if(instance == null){
            instance = new FakeWork();
        }
        return instance;
    }

    public void enter(Billy billy){

    }

    public void execute(Billy billy){
        System.out.println("Acho que vou trabalhar...");
        System.out.println("Na faxenda no caso...\n");

        Random r = new Random();

        int rand = r.nextInt(50);
        if(rand == 1){
            MessageDispatcher.getInstance().dispatchMessage(billy, EntityManager.getInstance().getEntity("Bob"), "JobsDone!", null);
            billy.getStateMachine().changeState(Look.getInstance());
        }
    }

    public void exit(Billy billy){

    }

    public boolean onMessage(Billy billy, Message msg){
        return false;
    }

}
