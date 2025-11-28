package h05.equipment;

import org.jetbrains.annotations.NotNull;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * A camera is a type of equipment that defines the vision of an entity.
 *
 * @author Nhan Huynh, Nico Schnieders
 */
public class Camera implements Equipment {

    /**
     * The default visibility range of the camera.
     */
    @DoNotTouch
    public static final int DEFAULT_VISIBILITY_RANGE = 1;

    @DoNotTouch
    private int visibilityRange;

    /**
     * Die aktuelle Haltbarkeit der Kamera.
     */
    private double durability;

    /**
     * Constructs a new {@link Camera} instance with the specified visibility range.
     *
     * @param visibilityRange the visibility range of the camera, must be at least 1
     */
    @DoNotTouch
    public Camera(int visibilityRange) {
        // Initialisiert die Sichtweite über den Setter, damit die Validierung greift.
        setVisibilityRange(visibilityRange);
        this.visibilityRange = visibilityRange;
        // Kamera startet immer mit voller Haltbarkeit.
        setDurability(100);
    }

    /**
     * Constructs a new {@link Camera} instance with the default visibility range of {@value DEFAULT_VISIBILITY_RANGE}.
     */
    @DoNotTouch
    public Camera() {
        this(DEFAULT_VISIBILITY_RANGE);
    }

    /**
     * Returns the visibility range of this camera, which defines how far an entity attached to this camera can see.
     *
     * @return the visibility range of this camera
     */
    @StudentImplementationRequired("H5.2.2")
    public int getVisibilityRange() {
        // Gibt die aktuelle Sichtweite zurück.
        return visibilityRange;
    }

    /**
     * Sets the visibility range of this camera, which defines how far an entity attached to this camera can see.
     *
     * <p>The visibility range must be at least 1. If a value less than 1 is provided, it will be set to 1.
     *
     * @param visibilityRange the new visibility range for this camera
     */
    @StudentImplementationRequired("H5.2.2")
    public void setVisibilityRange(int visibilityRange) {
        // Sichtweite darf minimal 1 sein.
        this.visibilityRange = Math.max(1, visibilityRange);
    }

    @Override
    @StudentImplementationRequired("H5.2")
    public @NotNull String getName() {
        // Klassennamen als eindeutigen Ausrüstungsnamen zurückgeben.
        return getClass().getSimpleName();
    }

    @StudentImplementationRequired("H5.2.1")
    @Override
    public @NotNull EquipmentCondition getCondition() {
        // Bestimmt den Zustand anhand der Haltbarkeit.
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
    @DoNotTouch
    public boolean isUsable() {
        return false;
    }

    @Override
    @DoNotTouch
    public boolean isTool() {
        return false;
    }

    @Override
    @StudentImplementationRequired("H5.1")
    public double getDurability() {
        // Liefert die aktuelle Haltbarkeit zurück.
        return durability;
    }

    @Override
    @StudentImplementationRequired("H5.1")
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
    @StudentImplementationRequired("H5.1")
    public void reduceDurability(double amount) {
        // Reduziert die Haltbarkeit und validiert anschließend über den Setter.
        setDurability(getDurability() - amount);
    }
}
