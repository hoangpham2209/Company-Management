package entities;

import layout.Demo;
import layout.General;
import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private Manager manager;
	private List<Staff> staffList = new ArrayList<>();

	public Department() {

	}

	public Department(String name, Manager manager) {
		setName(General.formatName(name));
		setManager(manager);
		this.manager.countRoom++;
		addStaff(manager);
	}

	public void addStaff(Staff staff) {
		staffList.add(staff);
		staff.setInRoom(this);
	}

	public void addManager() {
		do {
			System.out.print("Nhập mã nhân viên quản lý: ");
			String id = General.formatId(General.s.nextLine());
			this.manager = (Manager) Demo.staffList.searchById(id);

			if (this.manager.countRoom < 2) {
				this.manager.roomManage[manager.countRoom] = this;
				this.manager.countRoom++;
				addStaff(this.manager);
				break;
			}
			else System.out.printf("Nhân viên %s đã quản lý 2 phòng ban!\n", this.manager.getName());
		} while (this.manager.countRoom == 2);
	}

	public void input() {
		System.out.print("Nhập tên phòng ban: ");
		setName(General.formatName(General.s.nextLine()));
		addManager();
	}

	public void show() {
		System.out.printf("- Tên phòng ban: %s\n- Quản lý phòng ban: %s\n", this.name, this.manager.getName());
	}

	public void showList(Department d) {
		System.out.println("Danh sách nhân viên phòng ban:");
		d.staffList.forEach(nv -> System.out.println(nv.getName()));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}
}
