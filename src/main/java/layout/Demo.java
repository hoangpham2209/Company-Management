package layout;

import controller.*;
import entities.*;

import java.text.ParseException;

public class Demo {
    public static StaffManagement staffList = new StaffManagement();
    public static ProjectManagement projectList = new ProjectManagement();
    public static DepartmentManagement departmentList = new DepartmentManagement();

    public static void main(String[] args) throws ParseException {
        System.out.print(General.getTextCyan());

        Staff nv1 = new Manager("nguyen tan An", "an.nt@ou.edu.vn", "Nam", "30/4/2002", 1.2, "14/02/2021");
        Staff nv2 = new Tester("Vo thi Binh", "binh.vt@ou.edu.vn", "Nữ", "23/02/2002", 1.5, 3);
        Staff nv3 = new Designer("Pham Van Chieu", "chieu.pv@ou.edu.vn", "Nam", "3/03/2000", 1, 50000);
        Staff nv4 = new Dev("Nguyen thuy linh", "linh.nt@gmail.com", "Nữ", "5/05/1999", 1.3, 370000);
        Staff nv5 = new NormalStaff("Tran Van Em", "em.tv@gmail.com", "Nam", "22/09/2002", 1.7);
        Staff nv6 = new Manager("Ly Van Hai", "hai.lv@asd", "Nam", "30/06/2000", 1.4, "8/03/2020");
        Staff nv7 = new NormalStaff("ly thu An", "an.lt@ou.edu.vn", "Nữ", "22/09/2002", 1.2);
        Staff nv8 = new Tester("Vo thi tuyet", "tuyet.vt@ou.edu.vn", "Nữ", "2/02/2002", 1.5, 1);
        Staff nv9 = new Dev("Pham hoang nhat thanh", "thanh.phnt@ou.edu.vn", "Nam", "22/09/2002", 1, 52000);
        Staff nv10 = new Dev("Pham hoang nhat thong", "thong.phn@gmail.com", "Nam", "28/01/1999", 1.3, 35000);
        Staff nv11 = new NormalStaff("Tran quoc khai", "khai.tq@gmail.com", "Nam", "22/09/2002", 1.7);
        Staff nv12 = new Designer("Ly vinh Hai", "hai.lv@asd", "Nam", "20/07/2001", 1.4, 500000);

        staffList.addStaff(nv1);
        staffList.addStaff(nv2);
        staffList.addStaff(nv3);
        staffList.addStaff(nv4);
        staffList.addStaff(nv5);
        staffList.addStaff(nv6);
        staffList.addStaff(nv7);
        staffList.addStaff(nv8);
        staffList.addStaff(nv9);
        staffList.addStaff(nv10);
        staffList.addStaff(nv11);
        staffList.addStaff(nv12);

        projectList.inputFile("src/main/resources/projects.txt");
        departmentList.inputFile("src/main/resources/departments.txt");

        Menu menu = new Menu();
        menu.mainMenu();
    }
}
