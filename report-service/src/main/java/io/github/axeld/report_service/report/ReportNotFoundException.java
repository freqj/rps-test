package io.github.axeld.report_service.report;

public class ReportNotFoundException extends RuntimeException {

    public ReportNotFoundException(Long id) {
        super("Report not found: id=" + id);
    }
}
