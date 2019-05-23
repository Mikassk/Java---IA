package Farmer;

import Farmer.Bob;
import Farmer.Messages.Message;

public interface State<Farmer>{

    public void enter(Farmer f);

    public void execute(Farmer f);

    public void exit(Farmer f);

    public boolean onMessage(Farmer f, Message msg);

}
