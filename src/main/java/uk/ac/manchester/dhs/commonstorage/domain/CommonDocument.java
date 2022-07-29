package uk.ac.manchester.dhs.commonstorage.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A CommonDocument.
 */
@Entity
@Table(name = "common_document")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CommonDocument implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "type", nullable = false)
  private String type;

  @NotNull
  @Column(name = "content", nullable = false)
  private String content;

  @NotNull
  @Column(name = "create_time", nullable = false)
  private Instant createTime;

  @NotNull
  @Column(name = "update_time", nullable = false)
  private Instant updateTime;

  // jhipster-needle-entity-add-field - JHipster will add fields here

  public Long getId() {
    return this.id;
  }

  public CommonDocument id(Long id) {
    this.setId(id);
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public CommonDocument type(String type) {
    this.setType(type);
    return this;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContent() {
    return this.content;
  }

  public CommonDocument content(String content) {
    this.setContent(content);
    return this;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Instant getCreateTime() {
    return this.createTime;
  }

  public CommonDocument createTime(Instant createTime) {
    this.setCreateTime(createTime);
    return this;
  }

  public void setCreateTime(Instant createTime) {
    this.createTime = createTime;
  }

  public Instant getUpdateTime() {
    return this.updateTime;
  }

  public CommonDocument updateTime(Instant updateTime) {
    this.setUpdateTime(updateTime);
    return this;
  }

  public void setUpdateTime(Instant updateTime) {
    this.updateTime = updateTime;
  }

  // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommonDocument)) {
      return false;
    }
    return id != null && id.equals(((CommonDocument) o).id);
  }

  @Override
  public int hashCode() {
    // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    return getClass().hashCode();
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "CommonDocument{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", content='" + getContent() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
