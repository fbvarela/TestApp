package com.personal.testApp.controller.exceptions;

import lombok.Builder;

@Builder
public record ErrorMessage(
    String message,
    String description
) {
}
