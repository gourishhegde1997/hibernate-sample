package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "locker")
@GenericGenerator(name = "id_gen", strategy = "increment")
public class LockerEntity {
	@Id
	@Column(name = "locker_id")
	@GeneratedValue(generator = "id_gen")
	private Integer lockerId;

	@Column(name = "locker_type")
	private String lockerType;

	private Double rent;

	public Integer getLockerId() {
		return lockerId;
	}

	public void setLockerId(Integer lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerType() {
		return lockerType;
	}

	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public LockerEntity(String lockerType, Double rent) {
		super();
		this.lockerType = lockerType;
		this.rent = rent;
	}

	public LockerEntity() {
		super();
	}

	@Override
	public String toString() {
		return "LockerEntity [lockerId=" + lockerId + ", lockerType=" + lockerType + ", rent=" + rent + "]";
	}
	
}
