package entities;

import layout.General;
import java.text.ParseException;

public class Tester extends Staff {
	private static int count = 0;
	private int bugs;

	public Tester(String name, String mail, String sex, String dob, double coefficient, int bugs) throws ParseException {
		super(name,mail,sex,dob,coefficient);
		this.id = String.format("KT%02d", ++count);
		setBugs(bugs);
	}

    public Tester() {
		this.id = String.format("KT%02d", ++count);
    }

	@Override
	public void input() throws ParseException {
		super.input();
		System.out.print("Nhập số lỗi tìm: ");
		setBugs(Integer.parseInt(General.s.nextLine()));
	}

	@Override
	public void show() {
		super.show();
		System.out.printf("- Số lỗi tìm được: %d \n", this.bugs);
	}

	@Override
	public double calSalary() {
		return super.calSalary() + this.bugs * 200000;
	}

	public int getBugs() {
		return bugs;
	}

	public void setBugs(int bugs) {
		this.bugs = bugs;
	}
}
