package ghosts.equipe03;
import ghosts.equipe03.ZornikGhostStates.Walking;
import ghosts.equipe03.Message.Entity;
import pacman.Game;
import pacman.Move;

public class ZornikGhost extends Entity {


    public StateMachine<ZornikGhost> getStateMachine(){return stateMachine;}

    public ZornikGhost(){
        super("Zornik");

        stateMachine = new StateMachine<ZornikGhost>(this);
        stateMachine.setCurrentState(Walking.getInstance());
    }
    public Move chooseMove(Game g, int ghostIndex){


        gameG = g;
        ghostIndexG = ghostIndex;

        stateMachine.getCurrentState().execute(this);

        return moveG.get(moveIndex);
    }

}
