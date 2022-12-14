package uk.ac.manchester.dhs.commonstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.manchester.dhs.commonstorage.domain.CommonDocument;

import java.util.List;

/**
 * Spring Data SQL repository for the CommonDocument entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommonDocumentRepository
  extends JpaRepository<CommonDocument, Long> {
    List<CommonDocument> findByType(String type);
}
