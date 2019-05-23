package Farmer.StatesBilly;

import Farmer.Billy;
import Farmer.Messages.Message;
import Farmer.State;

public class Walk implements State<Billy> {

    private static Walk instance = null;

    private Walk(){

    }

    public static Walk getInstance(){
        if(instance == null){
            instance = new Walk();
        }
        return instance;
    }

    @Override
    public void enter(Billy billy){
        System.out.println("Andar é trabalho, não é?\n");
    }

    @Override
    public void execute(Billy billy){
        System.out.println("Andando pela fazenda...");
        billy.decreaseBoredom();
        System.out.printf("Tédio: %d\n", billy.tedio);

        if(billy.anotherThing()){
            billy.nextAction = billy.whatToDo();
            if(billy.nextAction == 0){
                System.out.println("Preguiça demais pra fazer outra coisa...\n");
            }
            else{
                billy.getStateMachine().changeState(Look.getInstance());
            }
        }
    }

    @Override
    public void exit(Billy billy){
        System.out.println("Do nada para o nada...\n");
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
