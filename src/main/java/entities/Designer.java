package entities;

import layout.General;
import java.text.ParseException;

public class Designer extends Staff {
	private static int count = 0;
	private double bonus;

	public Designer(String name, String mail, String sex, String dob, double coefficient, double  bonus) throws ParseException {
		super(name,mail,sex,dob,coefficient);
		this.id = String.format("TK%02d", ++count);
		setBonus(bonus);
	}

    public Designer() {
		this.id = String.format("TK%02d", ++count);
    }

	@Override
	public void input() throws ParseException {
		super.input();
		System.out.print("Nhập lương bonus: ");
		setBonus(Double.parseDouble(General.s.nextLine()));
	}

	@Override
	public void show() {
		super.show();
		System.out.printf("- Lương bonus: %.2f \n", this.bonus);
	}

	@Override
	public double calSalary() {
		return super.calSalary() + this.bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
