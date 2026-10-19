import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Lớp cơ sở Thí sinh
class ThiSinh {
    protected String soBaoDanh;
    protected String hoTen;
    protected String diaChi;
    protected int mucUuTien;

    public ThiSinh(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        this.soBaoDanh = soBaoDanh;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public void hienThiThongTin() {
        System.out.println("SBD: " + soBaoDanh + " | Họ tên: " + hoTen + 
                           " | Địa chỉ: " + diaChi + " | Mức ưu tiên: " + mucUuTien);
    }
}

// Thí sinh Khối A
class ThiSinhKhoiA extends ThiSinh {
    public static final String MON_TOAN = "Toán";
    public static final String MON_LY = "Lý";
    public static final String MON_HOA = "Hoá";

    public ThiSinhKhoiA(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("   Khối thi: Khối A (" + MON_TOAN + ", " + MON_LY + ", " + MON_HOA + ")");
    }
}

// Thí sinh Khối B
class ThiSinhKhoiB extends ThiSinh {
    public static final String MON_TOAN = "Toán";
    public static final String MON_HOA = "Hoá";
    public static final String MON_SINH = "Sinh";

    public ThiSinhKhoiB(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("   Khối thi: Khối B (" + MON_TOAN + ", " + MON_HOA + ", " + MON_SINH + ")");
    }
}

// Thí sinh Khối C
class ThiSinhKhoiC extends ThiSinh {
    public static final String MON_VAN = "Văn";
    public static final String MON_SU = "Sử";
    public static final String MON_DIA = "Địa";

    public ThiSinhKhoiC(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("   Khối thi: Khối C (" + MON_VAN + ", " + MON_SU + ", " + MON_DIA + ")");
    }
}

// Lớp quản lý tuyển sinh
class TuyenSinh {
    private List<ThiSinh> danhSachThiSinh;

    public TuyenSinh() {
        danhSachThiSinh = new ArrayList<>();
    }

    // Chức năng 1: Thêm mới thí sinh
    public void themMoiThiSinh(ThiSinh thiSinh) {
        danhSachThiSinh.add(thiSinh);
        System.out.println(">> Thêm thí sinh thành công!");
    }

    // Chức năng 2: Hiện thị thông tin thí sinh và khối thi
    public void hienThiDanhSach() {
        if (danhSachThiSinh.isEmpty()) {
            System.out.println(">> Danh sách thí sinh hiện đang trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH THÍ SINH ---");
        for (ThiSinh ts : danhSachThiSinh) {
            ts.hienThiThongTin();
        }
    }

    // Chức năng 3: Tìm kiếm theo số báo danh
    public void timKiemTheoSBD(String sbd) {
        boolean timThay = false;
        for (ThiSinh ts : danhSachThiSinh) {
            if (ts.getSoBaoDanh().equalsIgnoreCase(sbd)) {
                System.out.println("\n>> Thông tin thí sinh tìm thấy:");
                ts.hienThiThongTin();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println(">> Không tìm thấy thí sinh có SBD: " + sbd);
        }
    }
}

// Lớp điều khiển chương trình (Main)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TuyenSinh tuyenSinh = new TuyenSinh();

        while (true) {
            System.out.println("\n=============== QUAN LY THI SINH ================");
            System.out.println("1. Them moi thi sinh");
            System.out.println("2. Hien thi thong tin thi sinh");
            System.out.println("3. Tim kiem theo so bao danh");
            System.out.println("4. Thoat khoi chuong trinh");
            System.out.print("Chon chuc nang (1-4): ");

            int chon = Integer.parseInt(scanner.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhập số báo danh: ");
                    String sbd = scanner.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String diaChi = scanner.nextLine();
                    System.out.print("Nhập mức ưu tiên: ");
                    int mucUuTien = Integer.parseInt(scanner.nextLine());

                    System.out.println("Chọn khối thi (a: Khối A, b: Khối B, c: Khối C): ");
                    String khoi = scanner.nextLine().toLowerCase();

                    switch (khoi) {
                        case "a":
                            tuyenSinh.themMoiThiSinh(new ThiSinhKhoiA(sbd, hoTen, diaChi, mucUuTien));
                            break;
                        case "b":
                            tuyenSinh.themMoiThiSinh(new ThiSinhKhoiB(sbd, hoTen, diaChi, mucUuTien));
                            break;
                        case "c":
                            tuyenSinh.themMoiThiSinh(new ThiSinhKhoiC(sbd, hoTen, diaChi, mucUuTien));
                            break;
                        default:
                            System.out.println(">> Khối thi không hợp lệ!");
                            break;
                    }
                    break;

                case 2:
                    tuyenSinh.hienThiDanhSach();
                    break;

                case 3:
                    System.out.print("Nhập số báo danh cần tìm: ");
                    String searchSbd = scanner.nextLine();
                    tuyenSinh.timKiemTheoSBD(searchSbd);
                    break;

                case 4:
                    System.out.println(">> Đã thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println(">> Lựa chọn không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        }
    }
}
