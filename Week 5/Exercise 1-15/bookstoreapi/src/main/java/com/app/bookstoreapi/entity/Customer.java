package com.app.bookstoreapi.entity;
import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends RepresentationModel<Customer> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="First name cannot be null")
    @Size(min=2,max=50,message = "FirstName should be between 2 and 50 characters")
    private String firstName;
    @Size(max=50,message = "Maximum 50 characters")
    private String middleName;
    @NotNull(message = "Last name cannot be null")
    @Size(min=2,max=50,message="LastName should be between 2 and 50 characters")
    private String lastName;
    @Min(value = 18, message = "Age should be atleast 18")
    private Integer age;
    @JsonIgnore
    private Long number;
    @JsonProperty("number")
    public String getFormattedNumber(){
        return String.format("%d",number);
    }
    @JsonProperty("number")
    public void setFormattedNumber(String number){
        this.number=Long.parseLong(number.replace(",", ""));
    }
    @Version
    private Integer version;
    // @JsonIgnore
    private String username;
    // @JsonIgnore
    @SuppressWarnings("unused")
	private String password;
	public String getPassword() {
		return null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return null;
	}
	public Object getFirstName() {
		return null;
	}
	public void setFirstName(Object firstName2) {
		
	}
	public Object getMiddleName() {
		return null;
	}
	public void setMiddleName(Object middleName2) {
		
	}
	public Object getLastName() {
		return null;
	}
	public void setLastName(Object lastName2) {
		
	}
	public Object getAge() {
		return null;
	}
	public void setAge(Object age2) {
		
	}
	public Object getNumber() {
		return null;
	}
	public void setNumber(Object number2) {
		
	}
	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}
}