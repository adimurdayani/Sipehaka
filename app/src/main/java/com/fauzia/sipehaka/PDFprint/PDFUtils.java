package com.fauzia.sipehaka.PDFprint;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

public class PDFUtils {

    public static void addNewItem(Document document, String text, int align, Font font)throws DocumentException {
        Chunk chunk = new Chunk(text,font);
        Paragraph p = new Paragraph(chunk);
        p.setAlignment(align);
        document.add(p);
    }

    public static void addLineSpace(Document document)throws DocumentException{
        document.add(new Paragraph(""));
    }

    public static  void addNewItemWithLeftAndRight(Document document,String leftText, String rightText,
                                                   Font leftFont, Font rigthFont)throws DocumentException{
        Chunk leftTextChunk = new Chunk(leftText,leftFont);
        Chunk rightTextChunk = new Chunk(rightText,rigthFont);
        Paragraph p = new Paragraph(leftTextChunk);
        p.add(new VerticalPositionMark());
        p.add(rightTextChunk);
        document.add(p);
    }

    public static void addLineSeparator(Document document) throws DocumentException{

        LineSeparator lineSeparator = new LineSeparator();
        lineSeparator.setLineColor(new BaseColor(0,0,0,68));
        addLineSpace(document);
        document.add(new Chunk(lineSeparator));
        addLineSpace(document);

    }

}
