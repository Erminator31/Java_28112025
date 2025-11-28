package h05.entity;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.RobotFamily;
import h05.Durable;
import h05.base.game.GameSettings;
import h05.equipment.Equipment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import java.awt.Point;

/**
 * A skeleton implementation of the {@link Durable} interface used to simplify the implementation of
 * repair bot in the world which only differ in the way they move to the repair location.
 *
 * @author Nhan Huynh, Nico Schnieders
 */
@DoNotTouch
public abstract class AbstractRepairBot extends Robot implements Repairer {

    /**
     * The game settings of this repair bot, which provides access to the world and other entities.
     */
    @DoNotTouch
    private final @NotNull GameSettings settings;

    /**
     * The radius of this repair bot, which determines how far it can scan for entities to repair.
     */
    @DoNotTouch
    private final int radius;

    /**
     * Constructs a new {@link AbstractRepairBot} instance with the specified position, game settings, and radius.
     *
     * @param x        the x-coordinate of the repair bot
     * @param y        the y-coordinate of the repair bot
     * @param settings the game settings of this repair bot, which provides access to the world and other entities
     * @param radius   the radius of this repair bot, which determines how far it can scan for entities to repair
     */
    @DoNotTouch
    public AbstractRepairBot(int x, int y, @NotNull GameSettings settings, int radius) {
        super(x, y, Direction.UP, 0, RobotFamily.SQUARE_RED);
        this.settings = settings;
        this.radius = radius;
    }

    @DoNotTouch
    @Override
    public @NotNull GameSettings getGameSettings() {
        return settings;
    }

    @DoNotTouch
    @Override
    public int getRadius() {
        return radius;
    }

    @StudentImplementationRequired("H5.5")
    @Override
    public @Nullable Point scan() {
        // Umliegende Felder innerhalb des Radius nach einem Miner absuchen (Manhattan-Abstand).
        for (int dx = -getRadius(); dx <= getRadius(); dx++) {
            for (int dy = -getRadius(); dy <= getRadius(); dy++) {
                if (Math.abs(dx) + Math.abs(dy) > getRadius()) {
                    continue;
                }

                int targetX = getX() + dx;
                int targetY = getY() + dy;
                Miner miner = settings.getMinerAt(targetX, targetY);
                if (miner != null) {
                    return new Point(targetX, targetY);
                }
            }
        }

        // Kein Miner im Suchradius gefunden.
        return null;
    }

    @StudentImplementationRequired("H5.5")
    @Override
    public void repair(@NotNull Point point) {
        // Zum angegebenen Punkt bewegen.
        move(point);

        // Miner an der Zielposition bestimmen; existiert keiner, endet die Reparatur.
        Miner miner = settings.getMinerAt(point.x, point.y);
        if (miner == null) {
            return;
        }

        // Kaputte Batterie bzw. Kamera durch neue Exemplare ersetzen.
        if (miner.isBatteryBroken()) {
            miner.equip(new h05.equipment.Battery());
        }
        if (miner.isCameraBroken()) {
            miner.equip(new h05.equipment.Camera());
        }

        // Weitere kaputte Ausrüstung entfernen (ausgenommen Batterie und Kamera an Index 0 bzw. 1).
        Equipment[] equipments = miner.getEquipments();
        for (int i = 2; i < equipments.length && equipments[i] != null; i++) {
            if (equipments[i].getCondition() == h05.equipment.EquipmentCondition.BROKEN) {
                miner.unequip(i - 2);
            }
        }
    }

    /**
     * Moves this repair bot to the specified point in the world.
     *
     * @param point the point to move to
     */
    @DoNotTouch
    protected abstract void move(@NotNull Point point);
}
