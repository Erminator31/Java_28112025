package h05;

import fopbot.Direction;
import fopbot.World;
import h05.base.entity.Gear;
import h05.base.entity.Loot;
import h05.base.game.GameLoopBase;
import h05.entity.MineBot;
import h05.entity.Repairer;
import h05.entity.TeleportRepairBot;
import h05.equipment.Axe;
import h05.equipment.Pickaxe;
import h05.equipment.Powerbank;
import h05.equipment.TelephotoLens;
import h05.equipment.WallBreaker;
import h05.mineable.Rock;
import h05.mineable.Tree;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * The game loop for simulating the MineBot world.
 *
 * @author Nhan Huynh, Nico Schnieders
 */
public class GameLoop extends GameLoopBase {

    /**
     * Constructs a new {@link GameLoop} instance for simulating the MineBot world.
     */
    @DoNotTouch
    public GameLoop() {
    }

    @StudentImplementationRequired("H5.6")
    @Override
    protected void setupWorld() {
        // Wände platzieren, um die Mine wie in der Vorlage aufzubauen.
        // Horizontale Barrieren
        World.placeHorizontalWall(0, 2);
        World.placeHorizontalWall(1, 2);
        World.placeHorizontalWall(2, 2);
        World.placeHorizontalWall(3, 2);
        World.placeHorizontalWall(4, 2);
        World.placeHorizontalWall(5, 2);
        World.placeHorizontalWall(1, 5);
        World.placeHorizontalWall(2, 5);
        World.placeHorizontalWall(3, 5);
        World.placeHorizontalWall(4, 5);

        // Vertikale Barrieren
        World.placeVerticalWall(2, 1);
        World.placeVerticalWall(2, 2);
        World.placeVerticalWall(2, 3);
        World.placeVerticalWall(2, 4);
        World.placeVerticalWall(5, 0);
        World.placeVerticalWall(5, 1);
        World.placeVerticalWall(5, 2);
        World.placeVerticalWall(5, 3);

        // Ausrüstung gemäß Abbildung platzieren.
        World.getGlobalWorld().placeFieldEntity(new Gear(1, 4, new Powerbank(50)));
        World.getGlobalWorld().placeFieldEntity(new Gear(5, 4, new TelephotoLens(2)));
        World.getGlobalWorld().placeFieldEntity(new Gear(3, 1, new WallBreaker()));
        World.getGlobalWorld().placeFieldEntity(new Gear(2, 0, new Axe()));
        World.getGlobalWorld().placeFieldEntity(new Gear(4, 0, new Pickaxe()));

        // Rohstoffe in der Mine verteilen.
        World.getGlobalWorld().placeFieldEntity(new Loot(6, 2, new Tree()));
        World.getGlobalWorld().placeFieldEntity(new Loot(0, 6, new Rock()));
    }

    @StudentImplementationRequired("H5.6")
    @Override
    protected void initRobots() {
        // MineBot (blauer Roboter) mit Blick nach Osten erstellen.
        MineBot mineBot = new MineBot(1, 1, getGameSettings());
        while (mineBot.getDirection() != Direction.RIGHT) {
            mineBot.turnLeft();
        }

        // Repairer (roter Roboter) mit wählbarem Scan-Radius platzieren.
        TeleportRepairBot repairer = new TeleportRepairBot(5, 5, getGameSettings(), 3);
        while (repairer.getDirection() != Direction.LEFT) {
            repairer.turnLeft();
        }
    }
}
