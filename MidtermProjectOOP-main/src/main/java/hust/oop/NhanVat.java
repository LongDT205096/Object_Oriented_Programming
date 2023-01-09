package hust.oop;

public class NhanVat {
    private String HoTen;
    private int namSinh;
    private int namMat;

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }
    
    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getNamMat() {
        return namMat;
    }

    public void setNamMat(int namMat) {
        this.namMat = namMat;
    }

    @Override
    public String toString() {
        return "NhanVat [HoTen=" + HoTen + ", Nam Sinh=" + namSinh + ", Nam Mat=" + namMat + "]";
    }

    

    
}
