package Farmer.StatesBilly;

import Farmer.FarmerBilly;

public abstract class StateMachineBilly {

    public abstract void Enter(FarmerBilly farmer);
    public abstract void Run(FarmerBilly farmer);
    public abstract void Exit(FarmerBilly farmer);

}