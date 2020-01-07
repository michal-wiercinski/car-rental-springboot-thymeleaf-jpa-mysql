package mira.dbproject.carrental.domain.dto;

public class CarModelDto {

  private Long id;
  private String name;
  private BrandDto brandDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BrandDto getBrandDto() {
    return brandDto;
  }

  public void setBrandDto(BrandDto brandDto) {
    this.brandDto = brandDto;
  }
}
