package com.appaces.ecommerce.utils.exceptions;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
