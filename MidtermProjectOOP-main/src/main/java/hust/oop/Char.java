package hust.oop;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Char {
    private String URL = "https://thuvienlichsu.com/nhan-vat?page=";
    private final String regex = "[()-]";
    private Document document;
    private ArrayList<NhanVat> Chars;

    public Char() {
        this.Chars = new ArrayList<>();
        getSomething();
    }

    public void getSomething(){
        try{
            for(int i = 1; i <= 41; i++){
                String url = URL + String.valueOf(i);
                this.document = Jsoup.connect(url).get();
                String query =  ".divide-content h3.card-title";
                Elements result = this.document.select(query);
                for(Element e : result) {
                    NhanVat nv = new NhanVat();
                    String title = e.text();
                    String[] sp = title.split(regex);
                    nv.setHoTen(sp[0]);
                    if(sp.length > 1) {
                        if(sp[1].trim().equals("?") || sp[1] == "") nv.setNamSinh(-1);
                        else {
                            nv.setNamSinh(Integer.parseInt(sp[1].trim()));
                        }
                        if(sp[2].trim().equals("?") || sp[2] == "") nv.setNamMat(-1);
                        else {
                            nv.setNamMat(Integer.parseInt(sp[2].trim()));
                        }
                    } else {
                        nv.setNamSinh(-1);
                        nv.setNamMat(-1);
                    }
                    this.Chars.add(nv);
                    // System.out.println(e.text());
                }
                // System.out.println("Pg=" + (i) + ",NUM=" + result.size());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void in() {
        for(NhanVat nv : this.Chars) {
            System.out.println(nv.toString());
        }
    }
}