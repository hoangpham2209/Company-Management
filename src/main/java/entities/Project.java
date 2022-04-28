package entities;

import layout.Demo;
import layout.General;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private static int count = 0;
    private String id = String.format("DA%02d", ++count);
    private String name;
    private Date startDate;
    private Date endDate;
    private double cost;
    private Staff leader;
    private List<Staff> joinStaff = new ArrayList<>();

    public Project() {}

    public Project(String name, Date startDate, Date endDate, double cost, Staff leader) {
        setName(General.formatName(name));
        setStartDate(startDate);
        setEndDate(endDate);
        setCost(cost);
        setLeader(leader);
    }

    public Project(String name, String startDate, String endDate, double cost, Staff leader) throws ParseException {
        this(name, General.f.parse(startDate), General.f.parse(endDate), cost, leader);
    }

    public boolean addStaff(Staff staff) {
        if (this.joinStaff.size() < 10 && staff.joinProjects.size() < 3) {
            this.joinStaff.add(staff);
            staff.joinProjects.add(this);
            return true;
        }
        return false;
    }

    public void input() throws ParseException {
        System.out.print("Nhập tên dự án: ");
        setName(General.formatName(General.s.nextLine()));
        System.out.print("Nhập ngày bắt đầu: ");
        setStartDate(General.f.parse(General.s.nextLine()));
        System.out.print("Nhập ngày kết thúc: ");
        setEndDate(General.f.parse(General.s.nextLine()));
        System.out.print("Nhập chi phí: ");
        setCost(Double.parseDouble(General.s.nextLine()));
        addLeader();
    }

    public void addLeader() {
        removeLeader();

        System.out.print("Nhập mã nhân viên chủ nhiệm dự án: ");
        String id = General.formatId(General.s.nextLine());

        Staff staff = Demo.staffList.searchById(id);
        setLeader(staff);

        staff.getLeadProjects().add(this);
        staff.getJoinProjects().add(this);
    }

    public void removeLeader() {
        this.getLeader().getLeadProjects().remove(this);
        this.getLeader().getJoinProjects().remove(this);
        setLeader(null);
    }

    public void show() {
        System.out.printf("- Mã dự án: %s\n- Tên dự án: %s\n- Ngày bắt đầu: %s\n- Ngày kết thúc: %s\n- Chi phí dự án: %.2f\n- Chủ nhiệm dự án: %s\n",
                this.id, this.name, General.f.format(this.startDate), General.f.format(this.endDate), this.cost, this.leader.getName());
    }

    public void showJoinStaff() {
        System.out.println("=================================");
        System.out.printf("Danh sách nhân viên tham gia dự án %s\n", this.getName());
        this.joinStaff.forEach(staff -> {
            staff.show();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Staff getLeader() {
        return leader;
    }

    public void setLeader(Staff leader) {
        this.leader = leader;
    }

    public List<Staff> getJoinStaff() {
        return joinStaff;
    }

    public void setJoinStaff(List<Staff> joinStaff) {
        this.joinStaff = joinStaff;
    }
}
