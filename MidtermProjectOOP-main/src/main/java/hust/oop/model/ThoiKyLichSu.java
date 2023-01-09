package hust.oop.model;

import java.util.ArrayList;

public class ThoiKyLichSu {
    private String noiDung;

    private String url;

    private ArrayList<ThoiKyLichSu> mocLichSu;

    public ThoiKyLichSu() {
        this.mocLichSu = new ArrayList<ThoiKyLichSu>();
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<ThoiKyLichSu> getMocLichSu() {
        return mocLichSu;
    }

    public void setMocLichSu(ArrayList<ThoiKyLichSu> mocLichSu) {
        this.mocLichSu = mocLichSu;
    }

    @Override
    public String toString() {
        return "ThoiKyLichSu{" +
                "noiDung='" + noiDung + '\'' +
                ", url='" + url + '\'' +
                ", mocLichSu=" + mocLichSu +
                '}';
    }
}
