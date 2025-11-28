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
     * Constructs a new {@link Tree} instance.
     */
    public Tree() {
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
        return org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.3 - remove if implemented
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void setDurability(double durability) {
        org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.3 - remove if implemented
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void reduceDurability(double amount) {
        org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.3 - remove if implemented
    }
}
