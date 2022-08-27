package co.com.sofka.model.cyclist.valuesobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Name {
  private String fullName;
  private String fullLastName;
  
  public Name(String fullName, String fullLastName){
    this.fullName = Objects.requireNonNull(fullName);
    this.fullLastName = Objects.requireNonNull(fullLastName);
    if (this.fullName.isBlank()) {
      throw new IllegalArgumentException("The name cannot be empty");
    }
  }

  public String value(){
    return fullName;
  }
}
