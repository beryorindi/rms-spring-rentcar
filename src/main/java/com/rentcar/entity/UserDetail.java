package com.rentcar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user_detail")
public class UserDetail 
{	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "user_detail_id")
		private int id;
		@Column(name = "name")
		@NotEmpty(message = "*Please provide your name")
		private String name;
		@Column(name = "last_name")
		@NotEmpty(message = "*Please provide your last name")
		private String lastName;
		@Column(name = "id_card_number")
		private String idCardNumber;
		@Column(name = "address")
		private String address;
		@Column(name = "phone_number")
		private String phoneNumber;
		@OneToOne(cascade= CascadeType.ALL, mappedBy = "userdetail", fetch =FetchType.LAZY)
		private User user;
		
		public UserDetail() {
		}

		public UserDetail(int id, String name, String lastName, String idCardNumber, String address,
				String phoneNumber) {
			this.id = id;
			this.name = name;
			this.lastName = lastName;
			this.idCardNumber = idCardNumber;
			this.address = address;
			this.phoneNumber = phoneNumber;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getIdCardNumber() {
			return idCardNumber;
		}

		public void setIdCardNumber(String idCardNumber) {
			this.idCardNumber = idCardNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
}
