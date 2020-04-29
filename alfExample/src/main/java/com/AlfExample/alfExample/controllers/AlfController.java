package com.AlfExample.alfExample.controllers;

import com.AlfExample.alfExample.service.AlfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/display")
public class AlfController {
    public static final Logger logger = LoggerFactory.getLogger(AlfController.class);

    @Autowired
    AlfService alfService;

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public ResponseEntity<String> displayReportOutput(@PathVariable("number") int number) {
        String reportOutput = alfService.printFizzBuzz(number);
        logger.info("Fetching report output for {} numbers", number);
       return new ResponseEntity<>(reportOutput, HttpStatus.OK);
    }
}
