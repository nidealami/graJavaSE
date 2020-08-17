package services;

import domain.Direction;
import domain.Player;

public class MoveCommand implements Command {

    private Direction direction;
    private Player player;

    public MoveCommand(Direction direction, Player player) {
        this.direction = direction;
        this.player = player;
    }

    @Override
    public String execute() {
        String result;
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            result = player.getCurrentLocationDescription();
        } else {
            result = "nie możesz isc tedy";
        }

        return result;
    }
}
