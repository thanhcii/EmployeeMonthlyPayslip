package com.pixeltrice.springbootimportcsvfileapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "developer_tutorial")
//@SQLDelete(sql = "DELETE FROM developer_tutorial")

public class DeveloperTutorial {

	
	  ////////////
	  //IncomeTax
	  ////////////
	  
	
	  /* Make unique id. 
	   * Contain bug: Data duplicated when exporting !!!
	  @Id  
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
	  private long id;
	  */
		
	  @Id
	  /* Make id to Firstname
	   * Contain bug: Don't get data when having duplicate firstname
	   */
	  @Column(name = "firstname")
	  private String firstname;	  

	  @Column(name = "lastname")
	  private String lastname;

	  @Column(name = "annualsalary")
	  private Long annualsalary;

	  @Column(name = "superrate")
	  private String superrate;
	  
	  @Column(name = "paymentdate")
	  private String paymentdate;

	  public DeveloperTutorial() {

	  }

	  public DeveloperTutorial( String firstname, String lastname, Long annualsalary, String superrate, String paymentdate) {
		this.firstname = firstname;
	    this.lastname = lastname;
	    this.annualsalary = annualsalary;
	    this.superrate = superrate;
	    this.paymentdate = paymentdate;
	  }	  

	  public String getFirstname() {
	    return firstname;
	  }

	  public void setFirstname(String firstname) {
	    this.firstname = firstname;
	  }

	  public String getLastname() {
	    return lastname;
	  }

	  public void setLastname(String lastname) {
	    this.lastname = lastname;
	  }

	  public Long getAnnualsalary() {
	    return annualsalary;
	  }

	  public void setAnnualsalary(Long annualsalary) {
	    this.annualsalary = annualsalary;
	  }  


	  public String getSuperrate() {
	    return superrate;
	  }

	  public void setSuperrate(String superrate) {
	    this.superrate = superrate;
	  }
	  
	  public String getPaymentdate() {
		    return paymentdate;
		  }

	  public void setPaymentdate(String paymentdate) {
		    this.paymentdate = paymentdate;
		  }

	  @Override
	  public String toString() {
	    return "Tutorial [firstname=" + firstname + ", lastname=" + lastname + ", annualsalary=" + annualsalary + ", superrate=" + superrate + ", paymentdate=" + paymentdate + "]";
	  }
	  
	  
	  
	}
