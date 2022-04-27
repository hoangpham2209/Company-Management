package entities;

import java.text.ParseException;

public class NormalStaff extends Staff{
    public NormalStaff() {

    }

    public NormalStaff(String name, String mail, String sex, String dob, double coefficient) throws ParseException {
        super(name, mail, sex, dob, coefficient);
    }
}
