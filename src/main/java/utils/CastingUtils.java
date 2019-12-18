package utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Utility class to perform casting activities on objects of unknown types.
 */
public class CastingUtils {


    /**
     * Method to perform the casting of objects if the casting is asserted to be safe.
     * @param destinyClass Class to which the casting is desired.
     * @param originalObject Object to be cast.
     * @param <D> Generic type representing type of the class to which the casting is desired.
     * @param <O> Generic type representing the type of the object to be cast.
     * @return Optional object holding either the cast object as requested, or null if the casting was deemed unsafe.
     */
    public static <D,O> Optional<D> safeCast(Class<D> destinyClass, O originalObject) {
        D toReturn = null;

        if (Objects.nonNull(originalObject)) {
            if (originalObject.getClass().equals(destinyClass) || destinyClass.isAssignableFrom(originalObject.getClass())) {
                toReturn = destinyClass.cast(originalObject);
            } else if (originalObject.getClass().isArray()) {
                toReturn = destinyClass.cast(Arrays.asList(originalObject));
            }
        }

        return Optional.ofNullable(toReturn);
    }

}
