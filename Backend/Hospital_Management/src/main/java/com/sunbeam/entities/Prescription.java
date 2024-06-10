package com.sunbeam.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="prescription")
@Entity
public class Prescription {


	@Column(name="prc_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescriptionId;
	
	@Column(name="prc_date")
	@Temporal(TemporalType.DATE)
	private Date prescriptionDate;
	
	@Column(name="medicines")
	private String medicines;
	
	@Column
	private double fees;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="p_id")
	private Patient patient;


	public Prescription() {
		super();
	}


	public Prescription(int prescriptionId, Date prescriptionDate, String medicines, double fees, Patient patient) {
		super();
		this.prescriptionId = prescriptionId;
		this.prescriptionDate = prescriptionDate;
		this.medicines = medicines;
		this.fees = fees;
		this.patient = patient;
	}


	public int getPrescriptionId() {
		return prescriptionId;
	}


	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}


	public Date getPrescriptionDate() {
		return prescriptionDate;
	}


	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}


	public String getMedicines() {
		return medicines;
	}


	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}


	public double getFees() {
		return fees;
	}


	public void setFees(double fees) {
		this.fees = fees;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", prescriptionDate=" + prescriptionDate
				+ ", medicines=" + medicines + ", fees=" + fees + ", patient=" + patient + "]";
	}
	
	
	
	
}
