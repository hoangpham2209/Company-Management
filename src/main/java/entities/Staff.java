package entities;

import layout.General;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Staff {
    private static int count = 0;
    protected String id = String.format("NV%02d", ++count);;
    protected String name;
    protected String email;
    protected String sex;
    protected Date dob;
    protected double coefficientSalary;
    protected Department inRoom;
    protected List<Project> leadProjects = new ArrayList<>();
    protected List<Project> joinProjects = new ArrayList<>();
    public static final double SALARY = 5000000;

    public Staff() {}

    public Staff(String name, String mail, String sex, String dob, double coefficient) throws ParseException {
        setName(General.formatName(name));
        setEmail(mail);
        setSex(sex);
        setDob(General.f.parse(dob));
        setCoefficientSalary(coefficient);
    }

    public double calSalary() {
        return SALARY * this.coefficientSalary;
    }

    public void input() throws ParseException {
        System.out.print("Nhập họ tên nhân viên: ");
        this.name = General.formatName(General.s.nextLine());
        System.out.print("Nhập ngày sinh: ");
        this.dob = General.f.parse(General.s.nextLine());
        System.out.print("Nhập giới tính: ");
        this.sex = General.s.nextLine();
        System.out.print("Nhập email: ");
        this.email = General.s.nextLine();
        System.out.print("Nhập hệ số lương: ");
        this.coefficientSalary = Double.parseDouble(General.s.nextLine());
    }

    public void show() {
        System.out.printf("- Mã nhân viên: %s\n- Họ tên: %s\n- Ngày sinh: %s\n- Giới tính: %s\n- Email: %s\n- Hệ số lương: %.2f\n",
                this.id, this.name, General.f.format(this.dob), this.sex, this.email, this.coefficientSalary);
    }

    public void showJoinProjects() {
        System.out.println("=================================");
        System.out.printf("Danh sách dự án của %s tham gia\n", this.getName());
        this.joinProjects.forEach(project -> {
            project.show();
            System.out.println("=================================");
        });
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getCoefficientSalary() {
        return coefficientSalary;
    }

    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    public List<Project> getJoinProjects() {
        return joinProjects;
    }

    public void setJoinProjects(List<Project> joinProjects) {
        this.joinProjects = joinProjects;
    }

    public Department getInRoom() {
        return inRoom;
    }

    public void setInRoom(Department inRoom) {
        this.inRoom = inRoom;
    }

    public List<Project> getLeadProjects() {
        return leadProjects;
    }

    public void setLeadProjects(List<Project> leadProjects) {
        this.leadProjects = leadProjects;
    }
}
