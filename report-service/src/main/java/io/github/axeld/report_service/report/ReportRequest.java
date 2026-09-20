package io.github.axeld.report_service.report;

import jakarta.validation.constraints.NotBlank;

public record ReportRequest(
        @NotBlank String title,
        String description) {
}
