package entities;

import layout.General;
import java.text.ParseException;
import java.util.Date;

public class Manager extends Staff {
	private static int count = 0;
	public int countRoom = 0;
	public Department[] roomManage = new Department[2];
	private Date leadDate;

	public Manager(String name, String mail, String sex, String dob, double coefficient, Date leadDate) throws ParseException {
		super(name,mail,sex,dob,coefficient);
		this.id = String.format("QL%02d", ++count);
		setLeadDate(leadDate);
	}

	public Manager(String name, String mail, String sex, String dob, double coefficient, String leadDate) throws ParseException {
		this(name, mail, sex, dob, coefficient, General.f.parse(leadDate));
	}

    public Manager() {
		this.id = String.format("QL%02d", ++count);
    }

	@Override
	public void input() throws ParseException {
		super.input();
		System.out.print("Nhập ngày nhậm chức: ");
		setLeadDate(General.f.parse(General.s.nextLine()));
	}

	@Override
	public void show() {
		super.show();
		System.out.printf("- Ngày nhậm chức: %s \n", General.f.format(this.leadDate));
	}

	public void showRoomManage() {
		for (int i = 0; i < countRoom; i++)
			System.out.println(roomManage[i].getName());
	}

	public Date getLeadDate() {
		return leadDate;
	}

	public void setLeadDate(Date leadDate) {
		this.leadDate = leadDate;
	}
}
