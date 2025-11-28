package h05.mineable;

import h05.equipment.Tool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * Represents a rock that can be mined using tools.
 *
 * @author Nhan Huynh, Nico Schnieders
 */
public class Rock implements Mineable {

    /**
     * Die aktuelle Haltbarkeit des Steins.
     */
    private double durability;

    /**
     * Constructs a new {@link Rock} instance.
     */
    public Rock() {
        // Rock startet mit voller Haltbarkeit.
        setDurability(100);
    }

    @StudentImplementationRequired("H5.3")
    @Override
    public @NotNull String getName() {
        // Liefert den Klassennamen als eindeutige Bezeichnung.
        return getClass().getSimpleName();
    }

    @StudentImplementationRequired("H5.3")
    @Override
    public @NotNull MiningProgress getProgress() {
        // 0 -> fertig, 100 -> unberührt, dazwischen -> wird abgebaut.
        if (getDurability() == 0) {
            return MiningProgress.COMPLETED;
        }
        if (getDurability() < 100 && getDurability() >= 1) {
            return MiningProgress.IN_PROGRESS;
        }
        return MiningProgress.UNSTARTED;
    }

    @StudentImplementationRequired("H5.3")
    @Override
    public boolean onMined(@Nullable Tool tool) {
        // Berechnet die Haltbarkeitsreduktion abhängig vom verwendeten Werkzeug.
        double reduction = 0;

        if (tool == null) {
            // Ohne Werkzeug: fester Abzug.
            reduction = 5;
        } else if (tool instanceof h05.equipment.Axe) {
            // Axt: Faktor 1,5 auf die Werkzeugstärke.
            reduction = 1.5 * tool.getMiningPower();
        } else if (tool instanceof h05.equipment.Pickaxe) {
            // Spitzhacke: doppelter Faktor auf die Werkzeugstärke.
            reduction = 2 * tool.getMiningPower();
        }

        // Trägt die Reduktion auf die Haltbarkeit auf.
        reduceDurability(reduction);

        // Gibt zurück, ob der Stein vollständig abgebaut wurde.
        return getDurability() == 0;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public double getDurability() {
        // Gibt die aktuelle Haltbarkeit zurück.
        return durability;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void setDurability(double durability) {
        // Klemmt die Haltbarkeit in den Bereich [0, 100].
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
        // Reduziert die Haltbarkeit sicher über den Setter.
        setDurability(getDurability() - amount);
    }
}
