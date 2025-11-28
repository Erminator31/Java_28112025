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
        return org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.3 - remove if implemented
    }

    @StudentImplementationRequired("H5.3")
    @Override
    public @NotNull String getName() {
        return org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.3 - remove if implemented
    }

    @StudentImplementationRequired("H5.3")
    @Override
    public boolean onMined(@Nullable Tool tool) {
        return org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.3 - remove if implemented
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
