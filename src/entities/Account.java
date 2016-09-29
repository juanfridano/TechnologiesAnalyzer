package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Account {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
	private String firma;
	
	@OneToMany(mappedBy="account", cascade={CascadeType.PERSIST})
	private Set<RequestData> requests = new HashSet<RequestData>();
	
	public Account(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public Set<RequestData> getRequests() {
		return requests;
	}

	public void setRequests(Set<RequestData> requests) {
		this.requests = requests;
	}

	public void addRequestData(RequestData requestData){
		requests.add(requestData);
		requestData.setAccount(this);
	}	
}
