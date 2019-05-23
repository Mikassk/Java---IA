package Farmer.States;

import Farmer.Farmer;

public class VisitBankAndDepositGold extends StateMachine {

    private VisitBankAndDepositGold(){ }

    private static VisitBankAndDepositGold m_instance = null;

    public static VisitBankAndDepositGold getInstance(){
        return m_instance != null ? m_instance : (m_instance = new VisitBankAndDepositGold());
    }

    @Override

    public void Enter(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() + " Indo pro banco...");
    }

    @Override
    public void Run(Farmer farmer) {
        farmer.DepositGold();
        if (farmer.IsWealthy()){
            farmer.ChangeState(GoHomeAndSleepTilRested.getInstance());
        }
        else{
            farmer.ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() + " saindo do banco...");
    }
}
