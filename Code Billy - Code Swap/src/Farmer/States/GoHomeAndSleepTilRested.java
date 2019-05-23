package Farmer.States;

import Farmer.Farmer;

public class GoHomeAndSleepTilRested extends StateMachine {

    private GoHomeAndSleepTilRested(){ }

    private static GoHomeAndSleepTilRested m_instance = null;

    public static GoHomeAndSleepTilRested getInstance(){
        return m_instance != null ? m_instance : (m_instance = new GoHomeAndSleepTilRested());
    }

    @Override
    public void Enter(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() + " Indo TORAR");
    }

    @Override
    public void Run(Farmer farmer) {
        farmer.Rest();
        if (farmer.IsRested()){
            farmer.ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(Farmer farmer) {
        System.out.println("Farmer " + farmer.getName() + " ALVORADAAAAAAAA");
    }
}
