package lv.ozo.learningSpring.controller;


import lv.ozo.learningSpring.entity.IssueReport;
import lv.ozo.learningSpring.repository.IssueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issues")
public class IssueRestController {
    private IssueRepository issueRepository;

    public IssueRestController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping
    public List<IssueReport> getIssues() {
        return this.issueRepository.findAllButPrivate();
    }

    @GetMapping("/private")
    public List<IssueReport> getPrivateIssues() {
        return this.issueRepository.findAllByMarkedAsPrivate(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueReport> getIssue(@PathVariable("id") Optional<IssueReport> issueReport) {
        if (!issueReport.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(issueReport.get(), HttpStatus.OK);
    }
}