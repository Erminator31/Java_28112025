package h05.equipment;

import org.jetbrains.annotations.NotNull;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * A battery is a type of equipment that defines the lifetime of an entity.
 *
 * @author Nhan Huynh, Nico Schnieders
 */
public class Battery implements Equipment {

    /**
     * Constructs a new {@link Battery} instance.
     */
    public Battery() {
    }

    /**
     * Increases the durability of this battery by the specified value.
     *
     * @param value the value to increase the durability by
     */
    @StudentImplementationRequired("H5.2.2")
    public void increaseDurability(double value) {
        org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.2.2 - remove if implemented
    }

    @StudentImplementationRequired("H5.2")
    @Override
    public @NotNull String getName() {
        return org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.2 - remove if implemented
    }

    @StudentImplementationRequired("H5.2.1")
    @Override
    public @NotNull EquipmentCondition getCondition() {
        return org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.2.1 - remove if implemented;
    }

    @Override
    public boolean isUsable() {
        return false;
    }

    @Override
    public boolean isTool() {
        return false;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public double getDurability() {
        return org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.1 - remove if implemented
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void setDurability(double durability) {
        org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.1 - remove if implemented
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void reduceDurability(double amount) {
        org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.1 - remove if implemented
    }
}
