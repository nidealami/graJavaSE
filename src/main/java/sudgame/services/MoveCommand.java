package sudgame.services;

import sudgame.domain.Direction;
import sudgame.domain.Player;

public class MoveCommand implements Command {

    Direction direction;
    Player player;

    public MoveCommand(Direction direction, Player player) {
    this.direction=direction;
    this.player=player;
    }

    @Override
    public String execute() {

        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("nie możesz isc tedy");
        }

        return null;
    }
}
