package controller;

import entities.Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StaffManagement {
	private List<Staff> staffList = new ArrayList<>();

	public void addStaff(Staff staff) {
		this.staffList.add(staff);
	}

	public Staff searchById(String key) {
		for (int i = 0; i < staffList.size(); i++) {
			if (staffList.get(i).getId().equals(key) == true)
				return staffList.get(i);
		}
		return null;
	}

	public List<Staff> searchByName(String key) {
		return this.staffList.stream().filter(staff -> staff.getName().contains(key) == true).collect(Collectors.toList());
	}

	public List<Staff> searchByBirth(Date key) {
		return this.staffList.stream().filter(staff -> staff.getDob().equals(key) == true).collect(Collectors.toList());
	}

	public List<Staff> searchByDepartment(String key) {
		return this.staffList.stream().filter(staff -> staff.getInRoom().getName().contains(key) == true).collect(Collectors.toList());
	}

	public void show() {
		System.out.println("Danh sách nhân viên:");
		this.staffList.forEach(staff -> {
			staff.show();
			System.out.println("=================================");
		});
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}
}
