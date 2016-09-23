package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class foundEvents {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int techId;
	private Date eventDate;
	private String link;
	private String title;
}
