package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class RequestData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column
	private String requestTitle;
	
	@Column
	private Date messageDate;
	
	@Column(unique=true)
	private String link;
	
	@ManyToOne(cascade={CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinColumn(name="account_id")
	private Account account;
	
	@OneToMany(mappedBy="requestData", cascade={CascadeType.PERSIST})
	private Set<FoundEvents> events = new HashSet<FoundEvents>();
	
	public RequestData(){
		
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getRequestTitle() {
		return requestTitle;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}


	public Date getMessageDate() {
		return messageDate;
	}


	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}


	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	
	
	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Set<FoundEvents> getEvents() {
		return events;
	}
	

	public void setEvents(Set<FoundEvents> events) {
		this.events = events;
	}
	
	public void addFoundEvent(FoundEvents foundEvent){
		events.add(foundEvent);
		foundEvent.setRequestData(this);
	}
	
	
}
