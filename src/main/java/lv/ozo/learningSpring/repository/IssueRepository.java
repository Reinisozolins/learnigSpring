package lv.ozo.learningSpring.repository;

import lv.ozo.learningSpring.entity.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<IssueReport, Long> {
    @Query(value = "SELECT i FROM IssueReport i WHERE markedAsPrivate = false")
    List<IssueReport> findAllButPrivate();

    List<IssueReport> findAllByMarkedAsPrivate(boolean markedAsPrivate);

    List<IssueReport> findAllByEmail(String email);
}