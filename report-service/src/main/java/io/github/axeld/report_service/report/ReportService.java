package io.github.axeld.report_service.report;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final ReportRepository reportRepository;

    @Transactional
    public Report create(Report report) {
        report.setId(null);
        return reportRepository.save(report);
    }

    public Report getById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new ReportNotFoundException(id));
    }
    @Cacheable(value="reports", key="'all'")
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Transactional
    public Report update(Long id, Report changes) {
        Report report = getById(id);
        report.setTitle(changes.getTitle());
        report.setDescription(changes.getDescription());
        return reportRepository.save(report);
    }

    @Transactional
    public void delete(Long id) {
        if (!reportRepository.existsById(id)) {
            throw new ReportNotFoundException(id);
        }
        reportRepository.deleteById(id);
    }
}
