package Companhia;

import Farmer.*;
import Farmer.States.*;
import Farmer.StatesBilly.*;

import java.util.ArrayList;

public class CompanhiaDeGraos {

    private static CompanhiaDeGraos instance = null;

    private CompanhiaDeGraos(){
    }

    public static CompanhiaDeGraos getInstance(){
        return instance != null ? instance : (instance = new CompanhiaDeGraos());
    }

    private ArrayList<Farmer> m_workers = new ArrayList<Farmer>();
    private ArrayList<Farmer> m_deadWorkers = new ArrayList<Farmer>();

    public void FarmerIsDead(Farmer farmer){
        m_deadWorkers.add(farmer);
    }


    public void Run() throws InterruptedException {

        m_workers.add(new Farmer("Jozoal", QuenchThirst.getInstance()));
        m_workers.add(new Farmer("Creito", GoHomeAndSleepTilRested.getInstance()));
        m_workers.add(new Farmer("Bob", EnterMineAndDigForNugget.getInstance()));
        m_workers.add(new Farmer("Conrado", VisitBankAndDepositGold.getInstance()));

        FarmerBilly farmerBilly = new FarmerBilly(LookAtSky.getInstance());

        while (true) {
            Thread.sleep(1000);
            m_workers.forEach(farmer -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                farmer.Run();
                farmerBilly.Run();
            });

            while (!m_deadWorkers.isEmpty()) {
                Farmer dead = m_deadWorkers.get(0);
                m_workers.remove(dead);
                m_deadWorkers.remove(dead);
            }
        }
    }
}
