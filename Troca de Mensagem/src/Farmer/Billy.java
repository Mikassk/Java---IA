package Farmer;

import Farmer.Messages.Entity;
import Farmer.StatesBilly.BillyGlobalState;
import Farmer.StatesBilly.Look;

import java.util.Random;

public class Billy extends Entity {

    public int tedio;

    public int nextAction;

    public StateMachine<Billy> getStateMachine(){
        return stateMachine;
    }

    public Billy(){
        super("Billy");
        tedio = 10;
        stateMachine = new StateMachine<Billy>(this);
        stateMachine.setCurrentState(Look.getInstance());
        stateMachine.setGlobalState(BillyGlobalState.getInstance());
    }

    public void update(){
        stateMachine.update();
    }

    public void decreaseBoredom(){
        tedio--;
    }

    public boolean anotherThing(){
        if(tedio <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int whatToDo(){
        tedio = 10;
        Random rand = new Random();
        return rand.nextInt(4);
    }

    public void enter(Billy billy){

    }

    public void execute(Billy billy){

    }

    public void exit(Billy billy){

    }

}
