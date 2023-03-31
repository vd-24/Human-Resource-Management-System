package com.masai.DTO;

public class DepartmentImpl implements Department{
	
	String deptId;
	String deptName;
	
	public DepartmentImpl(String deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	@Override
	public String getDeptId() {
		return deptId;
	}

	@Override
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getDeptName() {
		return deptName;
	}

	@Override
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department ID : " + deptId + "   Department Name : " + deptName;
	}
	
	
	
}
