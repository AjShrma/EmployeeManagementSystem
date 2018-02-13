package empClasses;

public abstract class Employee {
	private String firstName;
	private String lastName;
	private String empID;
	private String empType,SIN,sex,email,address,city,province,country,postal,mobile,salary,allowances;
	
	public boolean setPersonalInfo(String firstName,String lastName,String empID,
			String empType, String SIN, String sex, String email, String address, String city, String province, String country, String postal,
			 String mobile) {
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.empID=empID;
		this.empType=empType;
		this.sex=sex;
		this.address=address;
		this.city=city;
		this.province=province;
		this.country=country;
		this.postal=postal;
		this.mobile=mobile;
		this.email=email;
		this.SIN=SIN;
		
		this.salary=Integer.toString(2000);
		return true;
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	

	public String getLastName() {
		return lastName;
	}
	
	
	public String getEmpID() {
		return empID;
	}

	public String getEmpType() {
		return empType;
	}
	
	public String getSalary() {
		return salary;
	}
	

	public String getAddress() {
		return address;
	}
	
	
	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}
	
	

	public String getSex() {
		return sex;
	}
	
	
	public String getProvince() {
		return province;
	}

	public String getSIN() {
		return SIN;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getPostal() {
		return postal;
	}
	
	
	
	
	
	public abstract int setAllowances(); 
	public abstract int getAllowances();

}
