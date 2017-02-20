package es.uniovi.asw;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Citizen {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

	@Column(name="FIRST_NAME") private String firstName;
	@Column(name="LAST_NAME") private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthdate;
	
	private String address;
	private String email;
	private String password;
	private String nationality;
	@Column(name="POLLING_STATION")
	private int pollingStation;
	private String dni;

	public Citizen() { }

	public Citizen(String dni, String firstName, String lastName, Date birthdate, String address, String email,
			String nationality, int pollingStation) {
		super();
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.address = address;
		this.email = email;
		this.nationality = nationality;
		this.pollingStation = pollingStation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Long getId() {
		return id;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getDni() {
		return dni;
	}

	public int getPollingStation() {
		return pollingStation;
	}

	public void setPollingStation(int pollingStation) {
		this.pollingStation = pollingStation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
    public String toString() {
        String simpleDate = new SimpleDateFormat("dd/MM/yyyy").format(birthdate);

        return "Name: " + firstName + "; Surname: " + lastName + "; " +
                "Email: " + email + "; Birth date: " + simpleDate + "; " +
                "Address: " + address + "; Nationality: " +
                nationality + "; DNI: " + dni + "; Polling station: " + pollingStation;

    }

	public void setId(Long id) {
		this.id = id;
	}


}
