import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DuAn {
    private static int dem = 0;
    private String id = String.format("DA%02d", ++dem);
    private String ten;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private double chiPhi;
    private NhanVien chuNhiem;
    private List<NhanVien> nhanVienThamGia = new ArrayList<>();

    public DuAn() {

    }

    public DuAn(String ten, Date ngayBatDau, Date ngayKetThuc, double chiPhi, NhanVien nv) {
        this.setTen(ten);
        this.setNgayBatDau(ngayBatDau);
        this.setNgayKetThuc(ngayKetThuc);
        this.setChiPhi(chiPhi);
        this.setChuNhiem(nv);
    }

    public void themNhanVien(NhanVien nv) {
        if (getNhanVienThamGia().size() < 10) {
            getNhanVienThamGia().add(nv);
            System.out.println("SUCCESS");
        }
        System.out.println("FAIL");
    }

    public void nhap() {
        System.out.print("Nhap ten: ");
        this.setTen(CauHinh.s.nextLine());
        System.out.print("Nhap hsl: ");
        this.chiPhi = Double.parseDouble(CauHinh.s.nextLine());
    }

    public void hienThi() {
        System.out.printf("- Mã: %s\n- Tên: %s\n- Chi phi: %.2f\n",
                getId(), getTen(), chiPhi);
    }

    public void hienThiNhanVienThamGia(NhanVien nv) {

    }

    public String getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public NhanVien getChuNhiem() {
        return chuNhiem;
    }

    public void setChuNhiem(NhanVien chuNhiem) {
        this.chuNhiem = chuNhiem;
    }

    public List<NhanVien> getNhanVienThamGia() {
        return nhanVienThamGia;
    }

    public void setNhanVienThamGia(List<NhanVien> nhanVienThamGia) {
        this.nhanVienThamGia = nhanVienThamGia;
    }
}
