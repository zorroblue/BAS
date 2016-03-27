package model;

public class Employee 
{

	private String name,employeeUserName,employeePassword;
	private Integer employeeID;
	protected Integer empCode; // code for deciding the hierarchy of the employee
	// 0 for normal employee,1 for sales clerk , 2 for manager, 3 for owner
	Employee()
	{
		this.empCode=0;
	}
	public void updateStock()
	{
		//to add implementation
		//TODO
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	
	
	
}
