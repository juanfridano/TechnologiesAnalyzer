package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Source {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String sourceName;
	private String domain;
	private Date firstEntryDate;
}
