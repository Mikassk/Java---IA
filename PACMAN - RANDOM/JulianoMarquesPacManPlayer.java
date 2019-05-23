package player;

import pacman.*;

import java.util.List;
import java.util.Random;

public class JulianoMarquesPacManPlayer implements PacManPlayer{

    Random random = new Random();

    public Move chooseMove(Game game){
        List<Move> legalMoves = game.getLegalPacManMoves();
        return legalMoves.get(random.nextInt(legalMoves.size()));
    }

}
