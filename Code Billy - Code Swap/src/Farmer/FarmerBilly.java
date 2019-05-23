package Farmer;

import Companhia.CompanhiaDeGraos;
import Farmer.StatesBilly.StateMachineBilly;

import java.util.Random;

public class FarmerBilly {

    private StateMachineBilly m_currentState;

    public int tedio=0;

    public int next;

    public FarmerBilly(StateMachineBilly initialState){
        ChangeState(initialState);
    }

    public void Run(){
        m_currentState.Run(this);
    }

    public void ChangeState(StateMachineBilly next){
        if (m_currentState != null){
            m_currentState.Exit(this);
        }
        m_currentState = next;
        m_currentState.Enter(this);
    }

    public int Randomi(){
        Random rand = new Random();
        return rand.nextInt(4);
    }

}
