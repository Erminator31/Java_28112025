package h05.equipment;

/**
 * Eine Axt als Werkzeug mit geringerer Abbaukraft.
 */
public class Axe implements Tool {

    /**
     * Die aktuelle Haltbarkeit der Axt.
     */
    private double durability;

    /**
     * Die Mining-Power der Axt.
     */
    private final double miningPower;

    /**
     * Erstellt eine neue Axt mit voreingestellter Stärke und voller Haltbarkeit.
     */
    public Axe() {
        this.miningPower = 5;
        setDurability(100);
    }

    @Override
    public double getMiningPower() {
        // Gibt die Stärke zum Abbauen zurück.
        return miningPower;
    }

    @Override
    public String getName() {
        // Der Name entspricht dem Klassennamen.
        return getClass().getSimpleName();
    }

    @Override
    public EquipmentCondition getCondition() {
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
    public double getDurability() {
        return durability;
    }

    @Override
    public void setDurability(double durability) {
        // Klemmt die Haltbarkeit auf den Bereich [0, 100].
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
        // Reduziert die Haltbarkeit und stellt über den Setter das Clamping sicher.
        setDurability(getDurability() - amount);
    }
}
