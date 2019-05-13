package lv.ozo.learningSpring.service;

import lv.ozo.learningSpring.entity.IssueReport;
import lv.ozo.learningSpring.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class RestrictedIssueService implements IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<IssueReport> getAllIssues() {
        return getPublicIssues();
    }

    @Override
    public List<IssueReport> getPrivateIssues() {
        throw new RuntimeException("You are not allowed to see these issues!");
    }

    @Override
    public List<IssueReport> getPublicIssues() {
        return issueRepository.findAllByMarkedAsPrivate(false);
    }

    @Override
    public Optional<IssueReport> getIssueById(Long id) {
        return issueRepository.findById(id);
    }

    @Override
    public void save(IssueReport issueReport) {
        issueRepository.save(issueReport);
    }

    @Override
    public void delete(IssueReport issueReport) {
        issueRepository.delete(issueReport);
    }

    @Override
    public void update(IssueReport issueReport) {
        issueRepository.save(issueReport);
    }
}
