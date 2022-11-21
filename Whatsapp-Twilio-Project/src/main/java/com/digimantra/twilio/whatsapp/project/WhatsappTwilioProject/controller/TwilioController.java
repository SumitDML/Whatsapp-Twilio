package com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.controller;
import com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.dto.Smsrequest;
import com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.service.Smsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/twilio")
public class TwilioController {

    @Autowired
    private Smsservice smsservice;

    @RequestMapping("/")
    public String homepage(ModelAndView model)
    {
        return "index";
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<Object> sendmessage(@RequestBody Smsrequest smsrequest)
    {
        String status=smsservice.sendsms(smsrequest);
        if("sent".equals(status)||"queued".equals(status))
        {
            return new ResponseEntity<Object>("Sent successfully",HttpStatus.OK);
        }
        return new ResponseEntity<Object>("failed to send message",HttpStatus.NOT_FOUND);
    }



}

