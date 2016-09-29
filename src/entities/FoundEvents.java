package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class FoundEvents {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="tech_id")
	private Tech tech;

	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="source_id")
	private Source source;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="requestdata_id")
	private RequestData requestData;
	
	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
	
	public Tech getTech() {
		return tech;
	}

	public void setTech(Tech tech) {
		this.tech = tech;
	}

		
	public RequestData getRequestData() {
		return requestData;
	}

	public void setRequestData(RequestData requestData) {
		this.requestData = requestData;
	}

	public FoundEvents(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	
}
