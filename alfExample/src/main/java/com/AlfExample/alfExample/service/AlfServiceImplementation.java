package com.AlfExample.alfExample.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlfServiceImplementation implements AlfService {
    String reportOutput;

    public String printFizzBuzz(int n) {
        int integerCount = 0;
        List<String> reportList = new ArrayList<String>();
        for(int i=1; i<=n; i++){
            if(Integer.toString(i).contains("3")){
                reportList.add("alfresco");
            }
            else if(i%3==0 & i%5==0) {
                reportList.add("fizzbuzz");
                           }
            else if(i%5==0){
                reportList.add("buzz");
            }
            else if(i%3==0){
                reportList.add("fizz");
            }
            else {
                reportList.add(Integer.toString(i));
                integerCount++;
            }
        }
         reportOutput = displayReportOutput(reportList,integerCount);
        return reportOutput;
    }

    @Override
    public String getOutputReport() {
        return reportOutput;
    }

    public int checkIfContainsString(String string, List<String> list){
      int count = 0;
      for(String eachElement: list) {
          if (eachElement.equals(string)) count++;
      }
      return count;
    }

    private String displayReportOutput(List<String> reportList, int integerCount){
       String reportOutput = "The list is: " + reportList + "." + System.lineSeparator() + "Report: " +  "fizz " + checkIfContainsString("fizz", reportList) + ", buzz "
                + checkIfContainsString("buzz", reportList) + ", fizzbuzz "
                + checkIfContainsString("fizzbuzz", reportList) + ", alfresco " + checkIfContainsString("alfresco", reportList)
                + ", integer " + integerCount;
       return reportOutput;
    }
}
