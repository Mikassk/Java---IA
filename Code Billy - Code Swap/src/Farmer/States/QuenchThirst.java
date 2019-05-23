package Farmer.States;

import Farmer.Farmer;

public class QuenchThirst extends StateMachine {

    private QuenchThirst(){ }

    private static QuenchThirst m_instance = null;

    public static QuenchThirst getInstance(){
        return m_instance != null ? m_instance : (m_instance = new QuenchThirst());
    }
    @Override
    public void Enter(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() + " Indo pro bar bebe cachaçaaaaaaaaaaa");
    }

    @Override
    public void Run(Farmer farmer) {
        farmer.BuyDrink();

        if (farmer.IsSatisfied()){
            farmer.ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() + " Saindo do bar BEM CALIBRADO");
    }
}
