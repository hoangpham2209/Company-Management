package controller;

import entities.Project;
import entities.Staff;
import layout.Demo;
import layout.General;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProjectManagement {
	private List<Project> projectList = new ArrayList<>();

	public void inputFile(String path) throws ParseException  {
		File f = new File(path);
		try (Scanner sc = new Scanner(f)) {
			while (sc.hasNext()) {
				Project p = new Project(General.formatName(sc.nextLine()), General.f.parse(sc.nextLine()), General.f.parse(sc.nextLine()), Double.parseDouble(sc.nextLine()),Demo.staffList.searchById(General.formatId(sc.nextLine())));

				this.projectList.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addProject(Project p) {
		this.projectList.add(p);
	}

	public void removeProject(Project p) {
		this.projectList.remove(p);

		Demo.staffList.getStaffList().forEach(staff -> {
			staff.getJoinProjects().remove(p);
			staff.getLeadProjects().remove(p);
		});
	}

	public void editProject(Project p) throws ParseException {
		p.input();

		Demo.staffList.getStaffList().forEach(staff -> {
			staff.getJoinProjects().forEach(project -> {
				if (project.equals(p) == true)
					project = p;
			});
			staff.getLeadProjects().forEach(project -> {
				if (project.equals(p) == true)
					project = p;
			});
		});
	}

	public void sortCost() {
		this.projectList.sort((p1, p2) -> {
			double cost1 = p1.getCost();
			double cost2 = p2.getCost();

			return (cost1 > cost2 ? 1 : (cost1 < cost2 ? -1 : 0));
		});
	}

	public Project searchById(String key) {
		for (int i = 0; i < projectList.size(); i++) {
			if (projectList.get(i).getId().equals(key) == true)
				return projectList.get(i);
		}
		return null;
	}

	public List<Project> searchByName(String key) {
		return this.projectList.stream().filter(p -> p.getName().contains(key) == true).collect(Collectors.toList());
	}

	public List<Project> searchByStartDate(Date key) {
		return this.projectList.stream().filter(staff -> staff.getStartDate().equals(key) == true).collect(Collectors.toList());
	}

	public void show() {
		System.out.println("Danh sách dự án:");
		this.projectList.forEach(p -> {
			p.show();
			System.out.println("=================================");
		});
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
}
