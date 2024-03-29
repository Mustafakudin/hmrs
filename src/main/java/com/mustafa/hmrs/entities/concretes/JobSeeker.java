package com.mustafa.hmrs.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity 
@Table(name="job_seekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="user_id" ,referencedColumnName = "id")
public class JobSeeker extends User {
	@Column(name ="first_name")
	private String firstName;
	@Column(name ="last_name")
	private String lastName;
	@Column(name ="national_identity")
	private String nationalIdentity;
	@Column(name ="date_of_birth")
	private Date dateOfBirth;
	

}
