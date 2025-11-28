package h05.equipment;

import fopbot.Wall;
import h05.base.game.GameSettings;
import h05.entity.Miner;
import org.jetbrains.annotations.NotNull;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * Usable equipment that allows the miner entity to break walls in the world.
 *
 * @author Nhan Huynh, Nico Schnieders
 */
public class WallBreaker implements UsableEquipment {

    /**
     * Die aktuelle Haltbarkeit des Wandbrechers.
     */
    private double durability;

    /**
     * Constructs a new {@link WallBreaker} instance.
     */
    public WallBreaker() {
        // Startet mit maximaler Haltbarkeit.
        setDurability(100);
    }

    @StudentImplementationRequired("H5.2.5")
    @Override
    public void use(@NotNull Miner miner) {
        // Führt keine Aktion aus, wenn der Wandbrecher kaputt ist.
        if (getCondition() == EquipmentCondition.BROKEN) {
            return;
        }

        // Ermittelt die Koordinaten und Ausrichtung der Wand direkt vor dem Miner.
        int wallX = miner.getX();
        int wallY = miner.getY();
        boolean horizontal;

        switch (miner.getDirection()) {
            case UP:
                // Horizontal liegende Wand oberhalb des aktuellen Feldes.
                horizontal = true;
                break;
            case DOWN:
                // Horizontal liegende Wand unterhalb des aktuellen Feldes.
                wallY--;
                horizontal = true;
                break;
            case RIGHT:
                // Vertikale Wand rechts neben dem aktuellen Feld.
                horizontal = false;
                break;
            case LEFT:
                // Vertikale Wand links neben dem aktuellen Feld.
                wallX--;
                horizontal = false;
                break;
            default:
                // Keine bekannte Blickrichtung -> keine Aktion.
                return;
        }

        // Entfernt die Wand, falls an der ermittelten Stelle eine existiert.
        GameSettings settings = miner.getGameSettings();
        Wall frontWall = settings.getWallAt(wallX, wallY, horizontal);

        if (frontWall != null) {
            settings.removeEntity(frontWall);
        }
    }

    @StudentImplementationRequired("H5.2")
    @Override
    public @NotNull String getName() {
        // Der Name entspricht dem Klassennamen.
        return getClass().getSimpleName();
    }

    @StudentImplementationRequired("H5.2.1")
    @Override
    public @NotNull EquipmentCondition getCondition() {
        // Leitet den Zustand aus der aktuellen Haltbarkeit ab.
        double currentDurability = getDurability();

        if (currentDurability >= 81) {
            return EquipmentCondition.NEW;
        } else if (currentDurability >= 41) {
            return EquipmentCondition.USED;
        } else if (currentDurability >= 1) {
            return EquipmentCondition.DAMAGED;
        }

        return EquipmentCondition.BROKEN;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public double getDurability() {
        // Gibt die Haltbarkeit zurück.
        return durability;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void setDurability(double durability) {
        // Klemmt den Wert auf den erlaubten Bereich [0, 100].
        if (durability < 0) {
            this.durability = 0;
        } else if (durability > 100) {
            this.durability = 100;
        } else {
            this.durability = durability;
        }
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void reduceDurability(double amount) {
        // Verringert die Haltbarkeit über den Setter, damit die Klammerung greift.
        setDurability(getDurability() - amount);
    }
}
