package lv.ozo.learningSpring.service;

import lv.ozo.learningSpring.entity.IssueReport;
import lv.ozo.learningSpring.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultIssueService implements IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<IssueReport> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public List<IssueReport> getPrivateIssues() {
        return issueRepository.findAllByMarkedAsPrivate(true);
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