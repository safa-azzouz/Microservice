package models;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Table
@Entity(name = "Vol")
public class Vol   {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Num;
    @NotNull(message = "Depature cannot be null or empty.")
    private City Departure;
    @NotNull(message = "Destination cannot be null or empty.")
    private City Destination;
    @Column(length = 20)
    @NotNull(message = "Take-off time cannot be null or empty.")
    private Time T_off;
    @NotNull(message = "Arrival time cannot be null or empty.")
    private Time T_Arrival;
    @NotNull(message = "flight duration cannot be null or empty.")
    private Long duration;
  


    public Vol() {
    }

    public Long getId() {
        return Num;
    }

    public void setId(Long id) {
        this.Num = id;
    }

	public Long getNum() {
		return Num;
	}

	public void setNum(Long num) {
		Num = num;
	}

	public City getDeparture() {
		return Departure;
	}

	public void setDeparture(City departure) {
		Departure = departure;
	}

	public City getDestination() {
		return Destination;
	}

	public void setDestination(City destination) {
		Destination = destination;
	}

	public Time getT_off() {
		return T_off;
	}

	public void setT_off(Time t_off) {
		T_off = t_off;
	}

	public Time getT_Arrival() {
		return T_Arrival;
	}

	public void setT_Arrival(Time t_Arrival) {
		T_Arrival = t_Arrival;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}


}
