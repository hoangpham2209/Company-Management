package controller;

import entities.Department;
import entities.Manager;
import layout.Demo;
import layout.General;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentManagement {
    private List<Department> departmentList = new ArrayList<>();

    public void inputFile(String path) throws ParseException {
        File f = new File(path);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                Department d = new Department(General.formatName(sc.nextLine()), (Manager) Demo.staffList.searchById(General.formatId(sc.nextLine())));

                this.departmentList.add(d);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addDepartment(Department d) {
        this.departmentList.add(d);
    }

    public Department searchByName(String key) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getName().equals(key) == true)
                return departmentList.get(i);
        }
        return null;
    }

    public void show() {
        System.out.println("Danh sách phòng ban:");
        this.departmentList.forEach(department -> {
            department.show();
            System.out.println("=================================");
        });
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
