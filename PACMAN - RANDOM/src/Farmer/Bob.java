package Farmer;

import Farmer.Messages.Entity;
import Farmer.StatesBob.BobGlobalState;
import Farmer.StatesBob.Mine;

public class Bob extends Entity {

    public int bolso;

    public int ouro;

    public int fadiga;

    public int sede;

    public boolean billyWorked;

    public StateMachine<Bob> getStateMachine(){
        return stateMachine;
    }

    public Bob(){

        super("Bob");
        bolso = 0;
        ouro = 0;
        fadiga = 0;
        sede = 0;
        stateMachine = new StateMachine<Bob>(this);
        stateMachine.setCurrentState(Mine.getInstance());
        stateMachine.setGlobalState(BobGlobalState.getInstance());

    }

    public void update(){
        stateMachine.update();
    }

    public void addGoldInPocket(){
        bolso++;
    }

    public void addGoldInBank(){
        ouro += bolso;
        bolso = 0;
    }

    public void increaseFatigue(int value){
        fadiga += value;
    }

    public void decreaseFatigue(int value){
        fadiga -= value;
        if(fadiga < 0)
            fadiga = 0;
    }

    public void increaseThirsty(int value){
        sede += value;
    }

    public void decreaseThirsty(int value){
        sede -= value;
        if(sede < 0)
            sede = 0;
    }

    public boolean pocketsFull(){
        if(bolso >= 20){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isThirsty(){
        if(sede >= 50){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean notThirsty(){
        if(sede <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean tired(){
        if(fadiga >= 50){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean notTired(){
        if(fadiga <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setBillyWorked(boolean value){
        billyWorked = value;
    }

    public void enter(Bob bob){

    }

    public void execute(Bob bob){

    }

    public void exit(Bob bob){

    }

}
