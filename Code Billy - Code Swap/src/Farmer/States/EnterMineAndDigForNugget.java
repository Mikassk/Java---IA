package Farmer.States;

import Farmer.Farmer;

public class EnterMineAndDigForNugget extends StateMachine{

    private EnterMineAndDigForNugget(){ }

    private static EnterMineAndDigForNugget m_instance = null;

    public static EnterMineAndDigForNugget getInstance(){
        return m_instance != null ? m_instance : (m_instance = new EnterMineAndDigForNugget());
    }

    @Override
    public void Enter(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() +" Indo TRAMPAR");
    }

    @Override
    public void Run(Farmer farmer){
        farmer.Mine();
        if (farmer.PocketsFull()){
            farmer.ChangeState(VisitBankAndDepositGold.getInstance());
            return;
        }

        if (farmer.IsThirsty()){
            farmer.ChangeState(QuenchThirst.getInstance());
        }
    }

    @Override
    public void Exit(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() + " saindo da FIRMA");
    }
}
