package models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
@Entity(name = "City")
public class City {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String Name;
    @Column(length = 20)
    @NotNull(message = "country cannot be null or empty.")
    private String Country ;
    @NotNull(message = "Airports cannot be empty.")
    private List<String> Airports;
    
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public List<String> getAirports() {
		return Airports;
	}
	public void setAirports(List<String> airports) {
		Airports = airports;
	}
  

}
