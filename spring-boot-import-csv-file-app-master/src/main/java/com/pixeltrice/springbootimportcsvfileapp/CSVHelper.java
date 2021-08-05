package com.pixeltrice.springbootimportcsvfileapp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Fistname", "Lastname", "Annualsalary", "Superrate", "Paymentdate" }; 

  ////////////
  //Income Tax///
  ///////////////
  public static boolean hasCSVFormat(MultipartFile file) {
	  System.out.println(file.getContentType());
	     if (TYPE.equals(file.getContentType())
	     		|| file.getContentType().equals("application/vnd.ms-excel")) {
	       return true;
	     }

	     return false;
	   }
  		//Parse csv file into mysql database
	   public static List<DeveloperTutorial> csvToTutorials(InputStream is) {
	     try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	         CSVParser csvParser = new CSVParser(fileReader,
	             CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	       List<DeveloperTutorial> developerTutorialList = new ArrayList<>();

	       Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	       
	       //TO DO : CONTROLLING THE DATA INPUT???
	       for (CSVRecord csvRecord : csvRecords) {
	     	  DeveloperTutorial developerTutorial = new DeveloperTutorial(
	               csvRecord.get("Firstname"),	               
	               csvRecord.get("Lastname"),	               
	               Long.parseLong(csvRecord.get("Annualsalary")),
	               csvRecord.get("Superrate"),
	               csvRecord.get("Paymentdate")
	             );

	     	  developerTutorialList.add(developerTutorial);
	       }

	       return developerTutorialList;
	     } catch (IOException e) {
	       throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	     }
	   }
	   
	   //Import data to CSV file for downloading
	   public static ByteArrayInputStream tutorialsToCSV(List<DeveloperTutorial> developerTutorialList) {
	     final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	     try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	         CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	       for (DeveloperTutorial developerTutorial : developerTutorialList) {
	         List<String> data = Arrays.asList(
	               developerTutorial.getFirstname()+ " " + developerTutorial.getLastname(),
	               paymentDate(developerTutorial.getPaymentdate()),	               
	               grossIncome(Double.valueOf(developerTutorial.getAnnualsalary())),
	               incomeTax(Double.valueOf(developerTutorial.getAnnualsalary())),	  
	               String.valueOf(grossincome-incometax),
	               superRate(developerTutorial.getSuperrate())
	             );

	         csvPrinter.printRecord(data);
	       }

	       csvPrinter.flush();
	       return new ByteArrayInputStream(out.toByteArray());
	     } catch (IOException e) {
	       throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	     }
	   }
	   
	   //Fix the ? in string Paymentdate
	   public static String paymentDate (String paymentdate) {
		   String paydate = paymentdate.replace("?", "-");
		   paydate = paymentdate.replace("�", "-");
		   return paydate;
	   }
	   
	   //Gross income - calculation function
	   public static double grossincome;	   
	   public static String grossIncome (Double annualsalary) {
		   grossincome = Math.round(annualsalary/12);
		   return String.valueOf(grossincome);
	   }
	   
	   
	   //Tax on this income - calculation function
	   public static double incometax;
	   public static String incomeTax (Double annualsalary) {
		   if (annualsalary <= 18200 ) {
			   incometax = 0;
			   return "Nil";
		   } else if (annualsalary <= 37000) {
			   incometax = Math.round(((annualsalary - 18200)*0.19)/12);
			   return String.valueOf(incometax);
		   } else if (annualsalary <= 87000) {
			   incometax = Math.round(((annualsalary - 37000)*0.325+3572)/12);
			   return String.valueOf(incometax);
		   } else if (annualsalary <= 180000) {
			   incometax = Math.round(((annualsalary - 87000)*0.37+19822)/12);
			   return String.valueOf(incometax);
		   } else {
			   incometax = Math.round(((annualsalary - 180000)*0.45+54232)/12);
		       return String.valueOf(incometax);
		   }
	   }
	   
	   //Super rate String to Value
	   public static String superRate (String superrate) {
		  String superrat = superrate.substring(0, superrate.length()-1);
		  long superr = Math.round(grossincome*(Double.parseDouble(superrat))/100);
		  return String.valueOf(superr);
	   }
	   
}
