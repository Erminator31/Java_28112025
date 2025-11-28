package h05.equipment;

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
     * Constructs a new {@link WallBreaker} instance.
     */
    public WallBreaker() {
    }

    @StudentImplementationRequired("H5.2.5")
    @Override
    public void use(@NotNull Miner miner) {
        org.tudalgo.algoutils.student.Student.crash(); // TODO: H5.2.5 - remove if implemented
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
