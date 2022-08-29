package co.com.sofka.model.cyclist.valuesobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
/**
 * [Value object the basic structure of Name object.]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
public class Name {
  private String fullName;
  private String fullLastName;

  /**
   * [Constructor method with all parameters]
   *
   * @param fullName String
   * @param fullLastName String
   */
  public Name(String fullName, String fullLastName){
    this.fullName = Objects.requireNonNull(fullName);
    this.fullLastName = Objects.requireNonNull(fullLastName);
    if (this.fullName.isBlank()) {
      throw new IllegalArgumentException("The name cannot be empty");
    }
  }

  /**
   * @return  a string with the value of the full name
   */
  public String value(){
    return fullName;
  }
}
