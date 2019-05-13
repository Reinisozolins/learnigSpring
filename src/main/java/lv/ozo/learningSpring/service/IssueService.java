package lv.ozo.learningSpring.service;

import lv.ozo.learningSpring.entity.IssueReport;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    List<IssueReport> getAllIssues();
    List<IssueReport> getPrivateIssues();
    List<IssueReport> getPublicIssues();
    Optional<IssueReport> getIssueById(Long id);
    void save(IssueReport issueReport);
    void delete (IssueReport issueReport);
    void update (IssueReport issueReport);
}