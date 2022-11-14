package uk.ac.manchester.dhs.commonstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.manchester.dhs.commonstorage.domain.CommonUserInput;

/**
 * Spring Data SQL repository for the CommonUserInput entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommonUserInputRepository
  extends JpaRepository<CommonUserInput, Long> {}
