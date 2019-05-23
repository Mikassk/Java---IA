package Farmer;
import Companhia.CompanhiaDeGraos;
import Farmer.States.StateMachine;


import java.util.Random;

public class Farmer {

    private StateMachine m_currentState;

    private int Thirst = 0;

    private int Pocket = 0;

    private int Wealthy = 0;

    private int Fadige = 0;

    private int Whacked = 0;

    private String Name;

    public Farmer(String name, StateMachine initialState){
        Name = name;
        ChangeState(initialState);
    }

    public void Run(){
        m_currentState.Run(this);
        if (Whacked > 30){
            System.out.println("Farmer " + Name + " trabalhou demais e morreu!");
            CompanhiaDeGraos.getInstance().FarmerIsDead(this);
        }
    }

    public void ChangeState(StateMachine next){
        if (m_currentState != null){
            m_currentState.Exit(this);
        }
        m_currentState = next;
        m_currentState.Enter(this);
    }

    public boolean IsSatisfied(){
        return Thirst <= 0;
    }

    public boolean IsThirsty(){
        return Thirst > 20;
    }

    public void Mine(){
        Fadige++;
        Thirst++;
        Whacked++;
        Random random = new Random();
        if (random.nextInt(10) < 1){
            Pocket++;
            System.out.printf("Farmer " + Name + " Achou uma pepita! bolsos em %d\n", Pocket);
        }else {
            System.out.printf("Farmer " + Name + " Mineirou e não conseguiu nada!\n");
        }

    }

    public boolean PocketsFull(){
        return Pocket >= 5;
    }

    public void DepositGold(){
        Wealthy += Pocket;
        Pocket = 0;
        System.out.printf("Farmer " + Name + " Depositei muita grana! Agora no banco eu tenho %d\n", Wealthy);
    }

    public boolean IsWealthy(){
        return Wealthy > 10;
    }

    public void BuyDrink(){
        Wealthy--;
        Thirst--;
        System.out.printf("Farmer " + Name + " Tomando suquinho... sede em %d\n", Thirst);
    }

    public void Rest(){
        Fadige--;
        System.out.printf("Farmer " + Name + " Dormindo... fadiga em %d\n", Fadige);
    }

    public boolean IsRested(){
        return Fadige <= 0;
    }

    public String getName(){
        return Name;
    }


}
