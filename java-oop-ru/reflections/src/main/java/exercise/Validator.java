package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Object obj) {
        List<String> result = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            field.setAccessible(true);
            try {
                if (notNull != null & field.get(obj) == null) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            field.setAccessible(true);
            try {
                if (notNull != null & field.get(obj) == null) {
                    result.compute(field.getName(), (k, list) -> list != null ? list : new ArrayList<>()).add("can not be null");
                    //result.get(field.getName()).add("can not be null");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            MinLength minLength = field.getAnnotation(MinLength.class);
            try {
                if (minLength != null) {
                    if (field.get(obj).toString().length() < minLength.minLength()) {
                        result.compute(field.getName(), (k, list) -> list != null ? list : new ArrayList<>()).add("length less than " + minLength.minLength());
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
// END
