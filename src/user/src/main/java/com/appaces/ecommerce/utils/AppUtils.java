package com.appaces.ecommerce.utils;

import java.util.function.Consumer;

public class AppUtils {
    public static <T>  void updateField(Consumer<T> setter, T newValue, T currentValue) {
        if (newValue != null) {
            setter.accept(newValue);
        }
    }
}
