package com.AlfExample.alfExample.controllers;

import com.AlfExample.alfExample.model.Report;
import com.AlfExample.alfExample.service.AlfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AlfController {
    public static final Logger logger = LoggerFactory.getLogger(AlfController.class);

    @Autowired
    AlfService alfService;

    @RequestMapping(value = "display/{number}", method = RequestMethod.GET)
    public ResponseEntity<String> displayReportOutput(@PathVariable("number") int number) {
        String reportOutput = alfService.printFizzBuzz(number);
        logger.info("Fetching report output for {} numbers", number);
        return new ResponseEntity<>(reportOutput, HttpStatus.OK);
    }
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("report") Report report,
                          ModelMap model) {
        model.addAttribute("number", report.getNumber());
        report.setReportOutput(alfService.printFizzBuzz(report.getNumber()));
         return new ModelAndView("redirect:/display/report");
    }
    @RequestMapping(value = "display/report", method = RequestMethod.GET)
    public ModelAndView getReport() {
        Map<String, Object> model = new HashMap<>();
        model.put("reportOutput", alfService.getOutputReport());
        return new ModelAndView("reportView", model);
        }
    }
