package entities;

import java.util.Date;
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
@Table(name="Source")
public class Source {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String sourceName;
	
	@Column
	private String domain;
	
	@Column
	private Date firstEntryDate;
	
	@OneToMany(mappedBy="source", cascade={CascadeType.PERSIST})
	private Set<FoundEvents> events = new HashSet<FoundEvents>();


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
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Date getFirstEntryDate() {
		return firstEntryDate;
	}
	public void setFirstEntryDate(java.util.Date firstDate) {
		this.firstEntryDate = firstDate;
	}
	
	public void addFoundEvent(FoundEvents foundEvent){
		events.add(foundEvent);
		foundEvent.setSource(this);
	}
	
}
