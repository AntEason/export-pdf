package com.example.controller;


import com.example.model.Content;
import com.example.model.Message;
import com.example.model.MsgInfo;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

@RestController
public class ExportPdfController {
    @Autowired
    Configuration configuration;

    private static final String FONT = "/Users/eason/code/java/export-pdf/src/main/resources/simhei.ttf";

    @GetMapping("/exprortPdf")
    public void exprortPdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        JSONObject model = new JSONObject();
//        model.put("msgId", "10086");
//        model.put("correspondent", "LPL RNG");
//        JSONObject contents = new JSONObject();
//        JSONObject message = new JSONObject();
//        message.put("relatedReference", "relatedReference");
//        message.put("trabsactuibReferenceNumber", "G10086");
//        message.put("sndrFinInstnld", "MY1CSG");
//        message.put("rcvrFinInstnld", "EASON");
//        message.put("narrative", "10086");
//        contents.put("message", message);
//        model.put("content", contents);
//        System.out.println(JSON.toJSONString(model));
        MsgInfo model=new MsgInfo();
        Content contents=new Content();
        model.setContent(contents);
        model.setCorrespondent("LPL RNG");
        model.setMsgId("10086");
        Message message=new Message();
        contents.setMessage(message);
        message.setNarrative("10086");
        message.setRcvrFinInstnld("EASON");
        message.setSndrFinInstnld("MY1CSG");
        message.setTransactionReferenceNumber("G10086");
        message.setRelatedReference("relatedReference");
        Template t = configuration.getTemplate("welcome.ftl"); // freeMarker template

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        String css="body{ width: 100%; }\n" +
                "        .title{\n" +
                "            background-color: aquamarine;\n" +
                "        }\n" +
                "        table{\n" +
                "            width: auto;\n" +
                "            border:1px solid #d9d9d9;\n" +
                "            border-collapse:collapse;\n" +
                "        }\n" +
                "        th,td{\n" +
                "            border:1px solid #d9d9d9;   /*为单元格单独设置边框*/\n" +
                "        }";
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontImp.register(FONT);
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new ByteArrayInputStream(content.getBytes()), new ByteArrayInputStream(css.getBytes()), Charset.forName("UTF-8"), fontImp);
        // step 5
        document.close();
    }
}
