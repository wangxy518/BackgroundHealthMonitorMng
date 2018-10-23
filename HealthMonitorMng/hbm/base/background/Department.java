package HealthMonitorMng.hbm.base.background;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model generated by MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7660371350941721668L;
	// Fields

	private String id;
	private Department pDepartment;
	private String pid;
	private String name;
	private Date createTime;
	private Set departmentUsers = new HashSet(0);
	private Set departments = new HashSet(0);

	public Department() {

	}

	/** minimal constructor */
	public Department(String departmentID) {
		this.id = departmentID;
	}

	public Department(String id, Department pDepartment, String name,
			Set departmentUsers, Set departments) {
		this.id = id;
		this.pDepartment = pDepartment;
		this.name = name;
		this.departmentUsers = departmentUsers;
		this.departments = departments;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the departments
	 */
	public Set getDepartments() {
		return departments;
	}

	/**
	 * @param departments
	 *            the departments to set
	 */
	public void setDepartments(Set departments) {
		this.departments = departments;
	}

	/**
	 * @return the pDepartment
	 */
	public Department getpDepartment() {
		return pDepartment;
	}

	/**
	 * @param pDepartment
	 *            the pDepartment to set
	 */
	public void setpDepartment(Department pDepartment) {
		this.pDepartment = pDepartment;
	}

	/**
	 * @return the departmentUsers
	 */
	public Set getDepartmentUsers() {
		return departmentUsers;
	}

	/**
	 * @param departmentUsers
	 *            the departmentUsers to set
	 */
	public void setDepartmentUsers(Set departmentUsers) {
		this.departmentUsers = departmentUsers;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}