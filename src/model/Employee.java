package model;

public class Employee 
{

	private String name,userName,password;
	protected Integer empCode; // code for deciding the hierarchy of the employee
	private Integer id;
	// 0 for normal employee,1 for sales clerk , 2 for manager, 3 for owner
	public Employee()
	{
		this.empCode=0;
	}
	
	public Employee(String name,String userName, String password,Integer id, Integer empCode)
	{
		this.name=name;
		this.id=id;
		this.password=password;
		this.userName=userName;
		this.empCode=empCode;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
