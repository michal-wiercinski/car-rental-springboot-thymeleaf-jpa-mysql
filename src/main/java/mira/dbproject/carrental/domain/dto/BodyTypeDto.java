package mira.dbproject.carrental.domain.dto;

public class BodyTypeDto {

  private Long id;
  private String typeName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}