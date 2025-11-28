package h05.equipment;

import h05.entity.Miner;
import org.jetbrains.annotations.NotNull;

/**
 * Eine Powerbank kann von einem Miner genutzt werden, um dessen Batterie aufzuladen.
 * Die Powerbank selbst verbraucht sich dabei und verliert Haltbarkeit.
 */
public class Powerbank implements UsableEquipment {

    /**
     * Die Kapazität der Powerbank.
     */
    private final double capacity;

    /**
     * Die aktuelle Haltbarkeit der Powerbank.
     */
    private double durability;

    /**
     * Erstellt eine neue Powerbank mit der gegebenen Kapazität.
     *
     * @param capacity die maximale Kapazität der Powerbank
     */
    public Powerbank(double capacity) {
        this.capacity = capacity;
        // Startet immer mit voller Haltbarkeit.
        setDurability(100);
    }

    /**
     * Gibt die Kapazität der Powerbank zurück.
     *
     * @return die Kapazität der Powerbank
     */
    public double getCapacity() {
        return capacity;
    }

    @Override
    public void use(@NotNull Miner miner) {
        // Anwendung nur, wenn die Powerbank nicht kaputt ist.
        if (getCondition() == EquipmentCondition.BROKEN) {
            return;
        }

        // Lädt die Batterie des Miners vollständig auf.
        miner.getBattery().setDurability(100);
        // Reduziert die Haltbarkeit der Powerbank um die Hälfte der Kapazität.
        reduceDurability(getCapacity() / 2);
    }

    @Override
    public @NotNull String getName() {
        // Der Name entspricht dem Klassennamen.
        return getClass().getSimpleName();
    }

    @Override
    public @NotNull EquipmentCondition getCondition() {
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
        return true;
    }

    @Override
    public boolean isTool() {
        return false;
    }

    @Override
    public double getDurability() {
        return durability;
    }

    @Override
    public void setDurability(double durability) {
        if (durability < 0) {
            this.durability = 0;
        } else if (durability > 100) {
            this.durability = 100;
        } else {
            this.durability = durability;
        }
    }

    @Override
    public void reduceDurability(double amount) {
        setDurability(getDurability() - amount);
    }
}
