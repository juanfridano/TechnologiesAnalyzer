package services;

import java.util.Date;

import entities.RequestData;
import entities.Source;
import entities.Tech;
import services.TechParameterBuilder.TechParameters;

public interface Repository {

	public void persistObject(TechParameters params);
	public Tech getTech(String name);
	public Source getSource(String name, String domain) ;
	public RequestData getRequestData(String requestTitle, Date messageDate, String link, String firma);
	
}
