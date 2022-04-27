package entities;

import layout.General;
import java.text.ParseException;

public class Dev extends Staff {
	private static int count = 0;
	private double OTSalary;

	public Dev(String ten, String mail, String sex, String dob, double coefficient, double  OTSalary) throws ParseException {
		super(ten,mail,sex,dob,coefficient);
		this.id = String.format("LT%02d", ++count);
		setOTSalary(OTSalary);
	}

    public Dev() {
		this.id = String.format("LT%02d", ++count);
    }

	@Override
	public void input() throws ParseException {
		super.input();
		System.out.print("Nhập lương OT: ");
		setOTSalary(Double.parseDouble(General.s.nextLine()));
	}

	@Override
	public void show() {
		super.show();
		System.out.printf("- Lương OT: %.2f \n", this.OTSalary);
	}

	@Override
	public double calSalary() {
		return super.calSalary() + this.OTSalary;
	}

	public double getOTSalary() {
		return OTSalary;
	}

	public void setOTSalary(double OTSalary) {
		this.OTSalary = OTSalary;
	}
}
