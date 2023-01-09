package hust.oop;

import hust.oop.model.ThoiKyLichSu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.ArrayList;

public class XuLy {
    private final String URL_NGUOIKESU = "http://nguoikesu.com";

    private final String URL_XMLFILE = "thoikylichsu.xml";

    private Document document;

    private ArrayList<ThoiKyLichSu> thoiKyLichSu;

    public XuLy() {
        this.thoiKyLichSu = new ArrayList<>();
        connect();
        queryThoiKyLichSu();
    }

    private void connect() {
        try {
            Document doc = Jsoup.connect(URL_NGUOIKESU).get();
            this.document = doc;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String subQueryFindChild(int child) {
        String query = ".list-categories:nth-child(2) .level-0:nth-child(" + child + ") .level-1";
        return query;
    }

    private void queryThoiKyLichSu() {
        String query = ".list-categories:nth-child(2) .level-0 > a[href]";
        Elements result = this.document.select(query);

        for (int i = 0; i < result.size(); i++) {

            ThoiKyLichSu tkls = new ThoiKyLichSu();
            tkls.setNoiDung(result.get(i).text());
            tkls.setUrl(result.get(i).attr("href"));

            if(subQueryFindChild(i) != null) {
                Elements subResult = this.document.select(subQueryFindChild(i) + " > a[href]");

                for (Element rs : subResult) {
                    ThoiKyLichSu tklsCon = new ThoiKyLichSu();
                    tklsCon.setMocLichSu(null);
                    tklsCon.setNoiDung(rs.text());
                    tklsCon.setUrl(rs.attr("href"));

                    tkls.getMocLichSu().add(tklsCon);
                }
            } else {
                tkls.setMocLichSu(null);
            }

            this.thoiKyLichSu.add(tkls);
        }
    }

    public void getThoiKyLichSu() {
        for(ThoiKyLichSu tkls : this.thoiKyLichSu) {
            System.out.println(tkls.toString());
        }
    }

    private void generateThoiKy(ThoiKyLichSu tkls, org.w3c.dom.Element root, org.w3c.dom.Document xml) {
        org.w3c.dom.Element thoiKy = xml.createElement("ThoiKy");
        root.appendChild(thoiKy);

        org.w3c.dom.Attr url = xml.createAttribute("url");
        url.setValue(tkls.getUrl());

        thoiKy.setAttributeNode(url);

        org.w3c.dom.Element noiDung = xml.createElement("NoiDung");
        noiDung.appendChild(xml.createTextNode(tkls.getNoiDung()));
        thoiKy.appendChild(noiDung);

        if(tkls.getMocLichSu() != null) {
            for(ThoiKyLichSu tklsCon : tkls.getMocLichSu()) {
                generateThoiKy(tklsCon, thoiKy, xml);
            }
        }
    }

    public void xuatFileXML() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document xml = documentBuilder.newDocument();

            org.w3c.dom.Element root = xml.createElement("ThoiKyLichSu");
            xml.appendChild(root);

            for(ThoiKyLichSu tkls : this.thoiKyLichSu) {
                generateThoiKy(tkls, root, xml);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");



            DOMSource domSource = new DOMSource(xml);
            StreamResult streamResult = new StreamResult(URL_XMLFILE);

            transformer.transform(domSource, streamResult);
            System.out.println("[SYSTEM] Xuat file thanh cong: /xml/thoikylichsu.xml ");
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
