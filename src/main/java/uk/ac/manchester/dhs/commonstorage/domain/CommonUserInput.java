package uk.ac.manchester.dhs.commonstorage.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A CommonUserInput.
 */
@Entity
@Table(name = "common_user_input")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CommonUserInput implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "owner_id")
  private Long ownerId;

  @Column(name = "reference_id")
  private Long referenceId;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "content")
  private String content;

  @Column(name = "extra_detail")
  private String extraDetail;

  @Column(name = "create_time")
  private Instant createTime;

  @Column(name = "update_time")
  private Instant updateTime;

  // jhipster-needle-entity-add-field - JHipster will add fields here

  public Long getId() {
    return this.id;
  }

  public CommonUserInput id(Long id) {
    this.setId(id);
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOwnerId() {
    return this.ownerId;
  }

  public CommonUserInput ownerId(Long ownerId) {
    this.setOwnerId(ownerId);
    return this;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public String getName() {
    return this.name;
  }

  public CommonUserInput name(String name) {
    this.setName(name);
    return this;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return this.type;
  }

  public CommonUserInput type(String type) {
    this.setType(type);
    return this;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContent() {
    return this.content;
  }

  public CommonUserInput content(String content) {
    this.setContent(content);
    return this;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getExtraDetail() {
    return this.extraDetail;
  }

  public CommonUserInput extraDetail(String extraDetail) {
    this.setExtraDetail(extraDetail);
    return this;
  }

  public void setExtraDetail(String extraDetail) {
    this.extraDetail = extraDetail;
  }

  public Instant getCreateTime() {
    return this.createTime;
  }

  public CommonUserInput createTime(Instant createTime) {
    this.setCreateTime(createTime);
    return this;
  }

  public void setCreateTime(Instant createTime) {
    this.createTime = createTime;
  }

  public Instant getUpdateTime() {
    return this.updateTime;
  }

  public CommonUserInput updateTime(Instant updateTime) {
    this.setUpdateTime(updateTime);
    return this;
  }

  public void setUpdateTime(Instant updateTime) {
    this.updateTime = updateTime;
  }

  public Long getReferenceId() {
    return this.referenceId;
  }

  public CommonUserInput referenceId(Long referenceId) {
    this.setReferenceId(referenceId);
    return this;
  }

  public void setReferenceId(Long referenceId) {
    this.referenceId = referenceId;
  }

  // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommonUserInput)) {
      return false;
    }
    return id != null && id.equals(((CommonUserInput) o).id);
  }

  @Override
  public int hashCode() {
    // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    return getClass().hashCode();
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "CommonUserInput{" +
            "id=" + getId() +
            ", ownerId=" + getOwnerId() +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", content='" + getContent() + "'" +
            ", extraDetail='" + getExtraDetail() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", referenceId=" + getReferenceId() +
            "}";
    }
}
