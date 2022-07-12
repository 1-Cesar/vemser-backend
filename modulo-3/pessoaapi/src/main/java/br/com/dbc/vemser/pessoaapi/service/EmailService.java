package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;
    Pessoa nome = new Pessoa();
    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    public Object sendEmail(Object id, Integer controle) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);

            switch (controle) {
                case 1 -> {
                    mimeMessageHelper.setSubject("Bem Vindo - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplate((PessoaDTO) id), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
                case 2 -> {
                    mimeMessageHelper.setSubject("Atualização - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplatePut(), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
                case 3 -> {
                    mimeMessageHelper.setSubject("Exclusão - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplateDelete(), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
                case 4 -> {
                    mimeMessageHelper.setSubject("Registro de Endereço - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplateEndereco((EnderecoDTO) id, nome), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
                case 5 -> {
                    mimeMessageHelper.setSubject("Exclução de Endereço - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplateEnderecoDelete((EnderecoDTO) id, nome), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
            }
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
        return id;
    }

    public String geContentFromTemplate(PessoaDTO id) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", id.getNome());
        dados.put("id", id.getIdPessoa());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("pessoa-post-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplatePut() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("put-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplateDelete() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("pessoa-delete-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplateEndereco(EnderecoDTO id, Pessoa nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("id", id.getIdEndereco());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("endereco-post-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplateEnderecoDelete(EnderecoDTO id, Pessoa nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("id", id.getIdEndereco());
        dados.put("rua", id.getLogradouro());
        dados.put("numero", id.getNumero());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("endereco-delete-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
