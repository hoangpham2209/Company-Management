package layout;

import entities.*;

import java.text.ParseException;

public class Menu {
    private int choose;
    private Staff staff = new NormalStaff();
    private Project project = new Project();
    private Department department = new Department();

    public void mainMenu() throws ParseException {
        do {
            General.clearScreen();
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN, DỰ ÁN");
            System.out.printf("1/ Chức năng nhân viên\n2/ Chức năng dự án\n3/ Chức năng phòng ban\n");
            System.out.print("Sự lựa chọn của bạn: ");
            choose = Integer.parseInt(General.s.nextLine());
            General.clearScreen();
            System.out.println("=================================\n");
            switch (choose) {
                case 1: {
                    staffMenu();
                    break;
                }
                case 2: {
                    projectMenu();
                    break;
                }
                case 3: {
                    departmentMenu();
                    break;
                }
                default: {
                    System.out.println("CHƯƠNG TRÌNH KẾT THÚC!");
                    System.exit(0);
                }
            }
        } while (choose > 0 && choose < 4);
    }

    public void staffMenu() throws ParseException {
        do {
            General.clearScreen();
            System.out.println("CHỨC NĂNG NHÂN VIÊN");
            System.out.printf("1/ Thêm nhân viên \n2/ Tìm kiếm nhân viên theo tên \n3/ Tìm kiếm nhân viên theo ngày sinh \n4/ Tìm kiếm nhân viên theo phòng ban \n" +
                    "5/ Tính tiền lương nhân viên \n6/ Hiển thị danh sách nhân viên \n7/ Hiển thị danh sách dự án của nhân viên \n8/ Quay lại \n");
            System.out.print("Sự lựa chọn của bạn: ");
            choose = Integer.parseInt(General.s.nextLine());
            General.clearScreen();
            System.out.println("=================================\n");
            switch (choose) {
                case 1: {
                    staff.input();
                    Demo.staffList.addStaff(staff);
                    System.out.println("Nhập thành công! ");
                    break;
                }
                case 2:{
                    System.out.print("Nhập tên nhân viên cần tìm: ");
                    String name =  General.formatName(General.s.nextLine());

                    Demo.staffList.searchByName(name).forEach(staff -> {
                        staff.show();
                        System.out.println("=================================");
                    });
                    break;
                }
                case 3:{
                    System.out.print("Nhập ngày sinh của nhân viên cần tìm: ");
                    String start = General.s.nextLine().trim();

                    Demo.staffList.searchByBirth(General.f.parse(start)).forEach(staff -> {
                        staff.show();
                        System.out.println("=================================");
                    });
                    break;
                }
                case 4:{
                    System.out.print("Nhập tên phòng ban cần tìm: ");
                    String name = General.formatName(General.s.nextLine());

                    for (Department d : Demo.departmentList.getDepartmentList())
                        if (d.getName().contains(name) == true) {
                            d.showList(d);
                            break;
                        }
                    break;
                }
                case 5:{
                    Demo.staffList.getStaffList().forEach(staff -> {
                        staff.show();
                        System.out.printf("- Lương: %.2f\n", staff.calSalary());
                        System.out.println("=================================");
                    });
                    break;
                }
                case 6:{
                    Demo.staffList.show();
                    break;
                }
                case 7: {
                    System.out.print("Nhập mã nhân viên: ");
                    String id = General.formatId(General.s.nextLine());

                    Demo.staffList.searchById(id).showJoinProjects();
                    break;
                }
                case 8: {
                    mainMenu();
                    break;
                }

                default: {
                    System.out.println("CHƯƠNG TRÌNH KẾT THÚC!");
                    System.exit(0);
                }
            }
            General.hold();
        } while (choose > 0 && choose <= 8);

        System.exit(0);
    }

    public void projectMenu() throws ParseException {
        do {
            General.clearScreen();
            System.out.println("CHỨC NĂNG DỰ ÁN");
            System.out.printf("1/ Thêm dự án \n2/ Xóa dự án \n3/ Sửa dự án \n4/ Thêm nhân viên cho dự án \n5/ Sắp xếp dự án theo chi phí tăng dần \n" +
                    "6/ Tìm kiếm dự án theo tên \n7/ Tìm kiếm dự án theo ngày bắt đầu \n8/ Hiển thị danh sách dự án \n9/ Hiển thị danh sách nhân viên tham gia dự án \n" +
                    "10/ Thêm chủ nhiệm dự án \n11/ Quay lại \n");
            System.out.print("Sự lựa chọn của bạn: ");
            choose = Integer.parseInt(General.s.nextLine());
            General.clearScreen();
            System.out.println("=================================\n");
            switch (choose) {
                case 1: {
                    project.input();
                    Demo.projectList.addProject(project);
                    System.out.println("Nhập thành công! ");
                    break;
                }
                case 2: {
                    System.out.print("Nhập mã dự án cần xóa: ");
                    String id = General.formatId(General.s.nextLine());

                    Demo.projectList.removeProject(Demo.projectList.searchById(id));
                    System.out.println("Xóa thành công! ");
                    break;
                }
                case 3: {
                    System.out.print("Nhập mã dự án cần sửa: ");
                    String id = General.formatId(General.s.nextLine());

                    Demo.projectList.editProject(Demo.projectList.searchById(id));
                    System.out.println("Sửa thành công! ");
                    break;
                }
                case 4:{
                    System.out.print("Nhập mã dự án cần thêm nhân viên tham gia: ");
                    String idProject = General.formatId(General.s.nextLine());
                    Project p = Demo.projectList.searchById(idProject);

                    do {
                        System.out.print("Nhập mã nhân viên tham gia: ");
                        String idStaff = General.formatId(General.s.nextLine());

                        Staff s = Demo.staffList.searchById(idStaff);

                        if (p.addStaff(s) == false)
                            System.out.println("Nhân viên đã tham gia đủ dự án hoặc dự án đã đủ nhân viên!");
                        else
                            System.out.println("Thêm thành công!");
                    } while (p.getJoinStaff().size() < 5);
                    break;
                }
                case 5:{
                    if (Demo.projectList.getProjectList().size() > 0) {
                        Demo.projectList.sortCost();
                        System.out.println("Sắp xếp thành công!\n");
                    }
                    break;
                }
                case 6:{
                    System.out.print("Nhập tên dự án cần tìm: ");
                    String name = General.formatName(General.s.nextLine());

                    Demo.projectList.searchByName(name).forEach(p -> {
                        p.show();
                        System.out.println("=================================");
                    });
                    break;
                }
                case 7:{
                    System.out.print("Nhập ngày bắt đầu của dự án cần tìm: ");
                    String start = General.s.nextLine().trim();

                    Demo.projectList.searchByStartDate(General.f.parse(start)).forEach(p -> {
                        p.show();
                        System.out.println("=================================");
                    });
                    break;
                }
                case 8:{
                    Demo.projectList.show();
                    break;
                }
                case 9: {
                    System.out.print("Nhập mã dự án: ");
                    String id = General.formatId(General.s.nextLine());

                    Demo.projectList.searchById(id).showJoinStaff();
                    break;
                }
                case 10: {
                    System.out.print("Nhập mã dự án cần gán chủ nhiệm: ");
                    String id = General.formatId(General.s.nextLine());

                    Demo.projectList.searchById(id).addLeader();
                    System.out.println("Gán thành công!\n");
                    break;
                }
                case 11: {
                    mainMenu();
                    break;
                }

                default: {
                    System.out.println("CHƯƠNG TRÌNH KẾT THÚC!");
                    System.exit(0);
                }
            }
            General.hold();
        } while (choose > 0 && choose <= 11);

        System.exit(0);
    }

    public void departmentMenu() throws ParseException {
        do {
            General.clearScreen();
            System.out.println("CHỨC NĂNG PHÒNG BAN");
            System.out.printf("1/ Thêm phòng ban \n2/ Thêm nhân viên vào phòng ban\n"+
                    "3/ Hiển thị danh sách phòng ban \n4/ Hiển thị danh sách nhân viên thuộc phòng ban \n5/ Quay lại \n");
            System.out.print("Sự lựa chọn của bạn: ");
            choose = Integer.parseInt(General.s.nextLine());
            General.clearScreen();
            System.out.println("=================================\n");
            switch (choose) {
                case 1: {
                    department.input();
                    Demo.departmentList.addDepartment(department);
                    System.out.println("Thêm thành công! ");
                    break;
                }
                case 2: {
                    System.out.print("Nhập tên phòng ban: ");
                    String nameDepartment = General.formatName(General.s.nextLine());

                    Department d = Demo.departmentList.searchByName(nameDepartment);

                    System.out.print("Nhập mã nhân viên: ");
                    String idStaff =  General.formatId(General.s.nextLine());
                    Staff s = Demo.staffList.searchById(idStaff);

                    d.addStaff(s);
                    System.out.println("Thêm thành công! ");
                    break;
                }
                case 3: {
                    Demo.departmentList.show();
                    break;
                }
                case 4: {
                    System.out.print("Nhập tên phòng ban: ");
                    String name = General.formatName(General.s.nextLine());

                    department.showList(Demo.departmentList.searchByName(name));
                    break;
                }
                case 5: {
                    mainMenu();
                    break;
                }

                default: {
                    System.out.println("CHƯƠNG TRÌNH KẾT THÚC!");
                    System.exit(0);
                }
            }
            General.hold();
        } while (choose > 0 && choose <= 4);

        System.exit(0);
    }
}
