
/**
 *
 * @author HP
 */
public class GradeStudent{
private String MaSV, TenSV;
private int ID,tinhoc, tienganh, gdtc;

    public GradeStudent() {
    }

    public GradeStudent(String MaSV, String TenSV, int ID, int tinhoc, int tienganh, int gdtc) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.ID = ID;
        this.tinhoc = tinhoc;
        this.tienganh = tienganh;
        this.gdtc = gdtc;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTinhoc() {
        return tinhoc;
    }

    public void setTinhoc(int tinhoc) {
        this.tinhoc = tinhoc;
    }

    public int getTienganh() {
        return tienganh;
    }

    public void setTienganh(int tienganh) {
        this.tienganh = tienganh;
    }

    public int getGdtc() {
        return gdtc;
    }

    public void setGdtc(int gdtc) {
        this.gdtc = gdtc;
    }

    public double avg(){
        return Math.round(tinhoc+gdtc+tienganh)/3;
    }
}