package com.mustafa.hmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="job_advertisment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="quantity_open_position")
	private int quantityOpenPosition;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="is_activate")
	private boolean isActivate;	
	
	@Column(name="created_at")
	private Date createdAt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
}
