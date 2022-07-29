package uk.ac.manchester.dhs.commonstorage.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import uk.ac.manchester.dhs.commonstorage.domain.CommonDocument;
import uk.ac.manchester.dhs.commonstorage.repository.CommonDocumentRepository;
import uk.ac.manchester.dhs.commonstorage.util.ResponseUtil;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * REST controller for managing {@link uk.ac.manchester.dhs.commonstorage.domain.CommonDocument}.
 */
@RestController
@RequestMapping("/api/common-document-storage")
@Transactional
public class CommonDocumentResource {

  private final Logger log = LoggerFactory.getLogger(
    CommonDocumentResource.class
  );

  private final CommonDocumentRepository commonDocumentRepository;

  public CommonDocumentResource(
    CommonDocumentRepository commonDocumentRepository
  ) {
    this.commonDocumentRepository = commonDocumentRepository;
  }

  /**
   * {@code POST  /common-documents} : Create a new commonDocument.
   *
   * @param commonDocument the commonDocument to create.
   * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new commonDocument, or with status {@code 400 (Bad Request)} if the commonDocument has already an ID.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PostMapping("/common-documents")
  public ResponseEntity<CommonDocument> createCommonDocument(
    @Valid @RequestBody CommonDocument commonDocument
  ) throws URISyntaxException {
    log.debug("REST request to save CommonDocument : {}", commonDocument);
    if (commonDocument.getId() != null) {
      throw new IllegalArgumentException(
        "A new commonDocument cannot already have an ID"
      );
    }
    CommonDocument result = commonDocumentRepository.save(commonDocument);
    return ResponseEntity
      .created(new URI("/api/common-documents/" + result.getId()))
      .body(result);
  }

  /**
   * {@code PUT  /common-documents/:id} : Updates an existing commonDocument.
   *
   * @param id the id of the commonDocument to save.
   * @param commonDocument the commonDocument to update.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated commonDocument,
   * or with status {@code 400 (Bad Request)} if the commonDocument is not valid,
   * or with status {@code 500 (Internal Server Error)} if the commonDocument couldn't be updated.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PutMapping("/common-documents/{id}")
  public ResponseEntity<CommonDocument> updateCommonDocument(
    @PathVariable(value = "id", required = false) final Long id,
    @Valid @RequestBody CommonDocument commonDocument
  ) throws URISyntaxException {
    log.debug(
      "REST request to update CommonDocument : {}, {}",
      id,
      commonDocument
    );
    if (commonDocument.getId() == null) {
      throw new IllegalArgumentException("Invalid id");
    }
    if (!Objects.equals(id, commonDocument.getId())) {
      throw new IllegalArgumentException(
        "Invalid ID"
      );
    }

    if (!commonDocumentRepository.existsById(id)) {
      throw new IllegalArgumentException(
        "Entity not found"
      );
    }

    CommonDocument result = commonDocumentRepository.save(commonDocument);
    return ResponseEntity
      .ok()
      .body(result);
  }

  /**
   * {@code PATCH  /common-documents/:id} : Partial updates given fields of an existing commonDocument, field will ignore if it is null
   *
   * @param id the id of the commonDocument to save.
   * @param commonDocument the commonDocument to update.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated commonDocument,
   * or with status {@code 400 (Bad Request)} if the commonDocument is not valid,
   * or with status {@code 404 (Not Found)} if the commonDocument is not found,
   * or with status {@code 500 (Internal Server Error)} if the commonDocument couldn't be updated.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PatchMapping(
    value = "/common-documents/{id}",
    consumes = { "application/json", "application/merge-patch+json" }
  )
  public ResponseEntity<CommonDocument> partialUpdateCommonDocument(
    @PathVariable(value = "id", required = false) final Long id,
    @NotNull @RequestBody CommonDocument commonDocument
  ) throws URISyntaxException {
    log.debug(
      "REST request to partial update CommonDocument partially : {}, {}",
      id,
      commonDocument
    );
    if (commonDocument.getId() == null) {
      throw new IllegalArgumentException("Invalid id");
    }
    if (!Objects.equals(id, commonDocument.getId())) {
      throw new IllegalArgumentException(
        "Invalid ID"
      );
    }

    if (!commonDocumentRepository.existsById(id)) {
      throw new IllegalArgumentException(
        "Entity not found"
      );
    }

    Optional<CommonDocument> result = commonDocumentRepository
      .findById(commonDocument.getId())
      .map(existingCommonDocument -> {
        if (commonDocument.getType() != null) {
          existingCommonDocument.setType(commonDocument.getType());
        }
        if (commonDocument.getContent() != null) {
          existingCommonDocument.setContent(commonDocument.getContent());
        }
        if (commonDocument.getCreateTime() != null) {
          existingCommonDocument.setCreateTime(commonDocument.getCreateTime());
        }
        if (commonDocument.getUpdateTime() != null) {
          existingCommonDocument.setUpdateTime(commonDocument.getUpdateTime());
        }

        return existingCommonDocument;
      })
      .map(commonDocumentRepository::save);

    return ResponseUtil.wrapOrNotFound(
      result
    );
  }

  /**
   * {@code GET  /common-documents} : get all the commonDocuments.
   *
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of commonDocuments in body.
   */
  @GetMapping("/common-documents")
  public List<CommonDocument> getAllCommonDocuments() {
    log.debug("REST request to get all CommonDocuments");
    return commonDocumentRepository.findAll();
  }

  /**
   * {@code GET  /common-documents/:id} : get the "id" commonDocument.
   *
   * @param id the id of the commonDocument to retrieve.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the commonDocument, or with status {@code 404 (Not Found)}.
   */
  @GetMapping("/common-documents/{id}")
  public ResponseEntity<CommonDocument> getCommonDocument(
    @PathVariable Long id
  ) {
    log.debug("REST request to get CommonDocument : {}", id);
    Optional<CommonDocument> commonDocument = commonDocumentRepository.findById(
      id
    );
    return ResponseUtil.wrapOrNotFound(commonDocument);
  }

  @GetMapping("/common-documents/type/{type}")
  public ResponseEntity<List<CommonDocument>> getCommonDocument(
          @PathVariable String type
  ) {
    log.debug("REST request to get CommonDocument by type : {}", type);
    List<CommonDocument> commonDocuments = commonDocumentRepository.findByType(
            type
    );
    return ResponseEntity.ok(commonDocuments);
  }

  /**
   * {@code DELETE  /common-documents/:id} : delete the "id" commonDocument.
   *
   * @param id the id of the commonDocument to delete.
   * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
   */
  @DeleteMapping("/common-documents/{id}")
  public ResponseEntity<Void> deleteCommonDocument(@PathVariable Long id) {
    log.debug("REST request to delete CommonDocument : {}", id);
    commonDocumentRepository.deleteById(id);
    return ResponseEntity
      .noContent()
      .build();
  }
}
