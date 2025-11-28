package h05.equipment;

import h05.entity.Miner;
import org.jetbrains.annotations.NotNull;

/**
 * Eine TelephotoLens erweitert die Sichtweite der Kamera eines Miners einmalig.
 */
public class TelephotoLens implements UsableEquipment {

    /**
     * Wert, um den die Sichtweite der Kamera erhöht wird.
     */
    private final int rangeEnhancement;

    /**
     * Die aktuelle Haltbarkeit der Linse.
     */
    private double durability;

    /**
     * Erstellt eine neue TelephotoLens mit der angegebenen Reichweitenverstärkung.
     *
     * @param rangeEnhancement zu addierender Sichtweitenwert
     */
    public TelephotoLens(int rangeEnhancement) {
        this.rangeEnhancement = rangeEnhancement;
        // Startet mit voller Haltbarkeit.
        setDurability(100);
    }

    /**
     * Liefert den Sichtweitenzuwachs der Linse zurück.
     *
     * @return der zusätzliche Sichtweitenwert
     */
    public int getRangeEnhancement() {
        return rangeEnhancement;
    }

    @Override
    public void use(@NotNull Miner miner) {
        // Nur nutzbar, wenn die Linse noch nicht kaputt ist.
        if (getCondition() == EquipmentCondition.BROKEN) {
            return;
        }

        // Erhöht die Sichtweite der Kamera des Miners.
        miner.getCamera().setVisibilityRange(miner.getCamera().getVisibilityRange() + getRangeEnhancement());
        // Nach einmaliger Nutzung ist die Linse verbraucht.
        setDurability(0);
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
