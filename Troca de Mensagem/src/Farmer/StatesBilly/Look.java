package Farmer.StatesBilly;

import Farmer.Billy;
import Farmer.Messages.Message;
import Farmer.State;

public class Look implements State<Billy>{


    private static Look instance = null;

    private Look(){

    }

    public static Look getInstance(){
        if(instance == null){
            instance = new Look();
        }
        return instance;
    }

    @Override
    public void enter(Billy billy){
        System.out.println("São tantas nuvens...\n");
    }

    @Override
    public void execute(Billy billy){
        System.out.println("Aquela nuvem parece uma galinha...");
        billy.decreaseBoredom();
        System.out.printf("Tédio: %d\n", billy.tedio);

        if(billy.anotherThing()){
            billy.nextAction = billy.whatToDo();
            if(billy.nextAction == 0){
                billy.getStateMachine().changeState(Walk.getInstance());
            }
            else{
                System.out.println("Preguiça demais pra fazer outra coisa...\n");
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
