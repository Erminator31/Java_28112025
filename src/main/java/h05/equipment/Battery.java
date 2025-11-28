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
     * Die aktuelle Haltbarkeit der Batterie.
     */
    private double durability;

    /**
     * Constructs a new {@link Battery} instance.
     */
    public Battery() {
        // Initialisiert die Batterie immer mit voller Haltbarkeit.
        setDurability(100);
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
        // Ermittelt den Zustand anhand der aktuellen Haltbarkeit.
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
        // Gibt die gekapselte Haltbarkeit zurück.
        return durability;
    }

    @StudentImplementationRequired("H5.1")
    @Override
    public void setDurability(double durability) {
        // Stellt sicher, dass die Haltbarkeit im erlaubten Bereich [0, 100] liegt.
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
        // Verringert die Haltbarkeit um den angegebenen Betrag und klemmt erneut.
        setDurability(getDurability() - amount);
    }
}
