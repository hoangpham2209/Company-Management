import java.util.ArrayList;
import java.util.List;

public class NhanVien extends ConNguoi {
    protected double heSoLuong;
    protected List<DuAn> duAnThamGia = new ArrayList<>();
    public static final double LUONG = 5000000;

    public NhanVien() {

    }

    public NhanVien(String ten, String mail, String sex, double heSoLuong) {
        super(ten,mail,sex);
        this.setHeSoLuong(heSoLuong);
    }

    @Override
    public void nhap() {
        System.out.print("Nhap ten: ");
        super.setHoTen(CauHinh.s.nextLine());
        System.out.print("Nhap mail: ");
        super.setEmail(CauHinh.s.nextLine());
        System.out.print("Nhap gioi tinh: ");
        super.setGioiTinh(CauHinh.s.nextLine());
        System.out.print("Nhap hsl: ");
        this.setHeSoLuong(Double.parseDouble(CauHinh.s.nextLine()));
    }

    public void themDA(DuAn d) {
        if (getDuAnThamGia().size() < 3) {
            getDuAnThamGia().add(d);
            System.out.println("SUCCESS");
        }
        else System.out.println("FAIL");
    }

    @Override
    public void hienThi() {
        System.out.printf("- Mã: %s\n- Tên: %s\n- Email: %s\n- Gioi tinh: %s\n- HSL: %.2f\n",
                getId(), getHoTen(), getEmail(), getGioiTinh(), getHeSoLuong());
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public List<DuAn> getDuAnThamGia() {
        return duAnThamGia;
    }

    public void setDuAnThamGia(List<DuAn> duAnThamGia) {
        this.duAnThamGia = duAnThamGia;
    }
}
