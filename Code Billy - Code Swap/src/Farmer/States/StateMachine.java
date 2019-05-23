package Farmer.States;

import Farmer.Farmer;

public abstract class StateMachine {

    public abstract void Enter(Farmer farmer);
    public abstract void Run(Farmer farmer);
    public abstract void Exit(Farmer farmer);

}
