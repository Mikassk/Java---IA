package ghosts.equipe03;

import ghosts.equipe03.Message.Entity;
import ghosts.equipe03.JessieGhostStates.Walking;
import pacman.Game;
import pacman.Move;

public class JessieGhost extends Entity {

    public StateMachine<JessieGhost> getStateMachine(){return stateMachine;}

    public JessieGhost(){
        super("Jessie");

        stateMachine = new StateMachine<JessieGhost>(this);
        stateMachine.setCurrentState(Walking.getInstance());
    }

    public Move chooseMove(Game g, int ghostIndex){

        gameG = g;
        ghostIndexG = ghostIndex;

        stateMachine.getCurrentState().execute(this);

        return moveG.get(moveIndex);
    }

}
