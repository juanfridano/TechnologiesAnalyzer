package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Tech {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String techName;
	
	@OneToMany(mappedBy="tech", cascade={CascadeType.PERSIST})
	private Set<FoundEvents> events = new HashSet<FoundEvents>();
	
	public Tech(){
		
	}
	
	public Set<FoundEvents> getEvents() {
		return events;
	}
	public void setEvents(Set<FoundEvents> events) {
		this.events = events;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}

	public void addFoundEvent(FoundEvents foundEvent){
		events.add(foundEvent);
		foundEvent.setTech(this);
	}
	
	
}
