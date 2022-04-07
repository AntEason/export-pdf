package com.example.controller;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SpireExportPdfController {

    @Autowired
    Configuration configuration;


    @GetMapping("/spireExprortPdf")
    public void exprortPdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("time", new Date());
        model.put("name", "张三");
        Template t = configuration.getTemplate("welcome.ftl"); // freeMarker template


        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        //新建Document对象
        Document document = new Document();
        //添加section
        Section sec = document.addSection();

        //添加段落并写入HTML文本
        sec.addParagraph().appendHTML(content);
        document.saveToStream(response.getOutputStream(), FileFormat.PDF);

    }


}
