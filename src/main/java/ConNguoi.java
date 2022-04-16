public abstract class ConNguoi {
    private static int dem = 0;
    private String id = String.format("NV%02d", ++dem);
    private String hoTen;
    private String email;
    private String gioiTinh;

    public  ConNguoi() {}

    public ConNguoi(String ten, String mail, String sex) {
        this.setHoTen(ten);
        this.setEmail(mail);
        this.setGioiTinh(sex);
    }

    public abstract void nhap();

    public abstract void hienThi();

    public String getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
