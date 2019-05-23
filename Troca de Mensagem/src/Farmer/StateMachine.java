package Farmer;

import Farmer.Messages.Message;

public class StateMachine<Farmer>{

    private Farmer myOwner;

    private State<Farmer> estadoAtual;

    private State<Farmer> estadoAnterior;

    private State<Farmer> estadoGlobal;

    public StateMachine(Farmer owner){

        myOwner = owner;
        estadoAtual = null;
        estadoAnterior = null;
        estadoGlobal = null;

    }

    public void setCurrentState(State<Farmer> f){
        estadoAtual = f;
    }

    public void setGlobalState(State<Farmer> f){
        estadoGlobal = f;
    }

    public void setPreviousState(State<Farmer> f){
        estadoAnterior = f;
    }

    public void update(){
        if(estadoGlobal != null){
            estadoGlobal.execute(myOwner);
        }

        if(estadoAtual != null){
            estadoAtual.execute(myOwner);
        }
    }

    public void changeState(State<Farmer> novoEstado){
        estadoAnterior = estadoAtual;
        estadoAtual.exit(myOwner);
        estadoAtual = novoEstado;
        estadoAtual.enter(myOwner);
    }

    public void revertToPreviousState(){
        changeState(estadoAnterior);
    }

    public State<Farmer> getCurrentState(){
        return estadoAtual;
    }

    public State<Farmer> getGlobalState(){
        return estadoGlobal;
    }

    public State<Farmer> getPreviousState(){
        return estadoAnterior;
    }

    public boolean handleMessage(Message msg){
        if(estadoAtual.onMessage(myOwner, msg)){
            return true;
        }
        if(estadoGlobal != null && estadoGlobal.onMessage(myOwner, msg)){
            return true;
        }
        return false;
    }

}
