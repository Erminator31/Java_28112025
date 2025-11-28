package h05.mineable;

import h05.equipment.Tool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * Represents a tree that can be mined using tools.
 *
 * @author Nhan Huynh, Nico Schnieders
 */
public class Tree implements Mineable {

    /**
     * Die aktuelle Haltbarkeit des Baums.
     */
    private double durability;

    /**
     * Constructs a new {@link Tree} instance.
     */
    public Tree() {
        // Baum startet mit voller Haltbarkeit.
        setDurability(100);
    }

    @StudentImplementationRequired("H5.3")
    @Override
    public @NotNull MiningProgress getProgress() {
        // 0 => fertig, 100 => unberührt, dazwischen => Abbau läuft.
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
    public @NotNull String getName() {
        // Gibt den Klassennamen als eindeutige Kennung zurück.
        return getClass().getSimpleName();
    }

    @StudentImplementationRequired("H5.3")
    @Override
    public boolean onMined(@Nullable Tool tool) {
        // Bestimmt die abzuziehende Haltbarkeit je nach Werkzeug.
        double reduction = 0;

        if (tool == null) {
            // Ohne Werkzeug: fester Abbauwert.
            reduction = 7.5;
        } else if (tool instanceof h05.equipment.Axe) {
            // Axt: vierfache Werkzeugstärke.
            reduction = 4 * tool.getMiningPower();
        } else if (tool instanceof h05.equipment.Pickaxe) {
            // Spitzhacke: dreifache Werkzeugstärke.
            reduction = 3 * tool.getMiningPower();
        }

        // Reduziert die Haltbarkeit um den berechneten Wert.
        reduceDurability(reduction);

        // Gibt zurück, ob der Baum vollständig abgebaut ist.
        return getDurability() == 0;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public double getDurability() {
        // Liefert die aktuelle Haltbarkeit.
        return durability;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void setDurability(double durability) {
        // Klemmt den Wert in den erlaubten Bereich [0, 100].
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
        // Reduziert die Haltbarkeit mithilfe des Setters für konsistente Validierung.
        setDurability(getDurability() - amount);
    }
}
