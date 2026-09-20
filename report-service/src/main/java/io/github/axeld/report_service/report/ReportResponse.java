package io.github.axeld.report_service.report;

import java.time.Instant;

public record ReportResponse(
        Long id,
        Long version,
        String title,
        String description,
        Instant createdAt) {

    static ReportResponse from(Report report) {
        return new ReportResponse(
                report.getId(),
                report.getVersion(),
                report.getTitle(),
                report.getDescription(),
                report.getCreatedAt());
    }
}
