package hw1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TestEngine {
	GradeReport gradeReport;

	// Set to true when generating expected results by running against the solution.
	// Set to false when running against a student solution. Must have expected results file.
	final boolean shouldGenerateExpectedResults = false;
	final String PATH = "src//hw1a//";
	final boolean shouldSaveStudentReport = true;
	// File containing expected results.
	final File expectedResultsFile = new File(PATH + "expectedResults.txt");
	// File containing all results for student.
	final File studentReportFile = new File(PATH + "studentReport.txt");

	public TestEngine() {
	}


	/**
	 * This method is called when we want to run the test methods in TestSuite against the solution
	 * (instructor's solution) and save the results to a text file. Each test method produces a 
	 * list of strings. Thus, the helper method, generateTestResults is called first to run all
	 * the test methods and it returns a list of the results of all the test methods. Thus, each
	 * element in the returned list, is the list of strings returned for one test method.
	 */
	public void generateExpectedResults() {
		// Generate the expected results from running against the solution.
		ArrayList<ArrayList<String>> testResults = generateTestResults();
		// Build the grade report.
		gradeReport = buildExpectedGradeReport(testResults);
		// Get the expected results from the grade report (this is a cleaner
		// format than the raw results contained in testResults.
		String expectedOutput = gradeReport.expectedOutput();
		// Save the results to a text file.
		saveResults(expectedOutput, expectedResultsFile);
		System.out.println(expectedOutput);
	}

	/**
	 * This method is called when we want to run the test methods in TestSuite against a 
	 * student solution, grade the results compared to the expected results, and then saves
	 * the student's report.
	 */
	public void generateActualResults() {
		// Read the expected results from text file and build the GradeReport.
		buildExpectedGradeReport(readExpectedResults(expectedResultsFile));
		// Generate the actual results from running against the student's solution.
		ArrayList<ArrayList<String>> actualTestResults = generateTestResults();
		// Add the actual results to the grade report.
		addActualResults(actualTestResults);
		// Grade the tests.
		gradeReport.assessTests();
		// Save student's report.
		if(shouldSaveStudentReport) {
			saveResults(gradeReport.toString(), studentReportFile);
		}
		System.out.println(gradeReport);
	}

	private ArrayList<ArrayList<String>> generateTestResults() {
		ArrayList<ArrayList<String>> resultsLists = new ArrayList<>();
		try {
			Class<TestSuite> c = TestSuite.class;

			ArrayList<String> testMethodNames = new ArrayList<>();
	        Method[] methods = c.getDeclaredMethods();
	        for(int i=0; i<methods.length; i++) {
	        	if(methods[i].getName().contains("test")) {
	            	testMethodNames.add(methods[i].getName());
	        	}
	        	else {
	        		continue;
	        	}
	        }
	    	Collections.sort(testMethodNames);

            ArrayList<String> results;
            for(String methodName : testMethodNames) {
            	System.out.println("Method: " + methodName + " begins");
        		Method method = TestSuite.class.getDeclaredMethod(methodName);
        		results = (ArrayList<String>)method.invoke(null);
            	resultsLists.add(results);
            }
		}
		catch (Throwable e) {
            System.err.println(e);
		}
		return resultsLists;

		// Example: has parameter, no return
//      Class[] param = new Class[1];
//		param[0] = ArrayList.class;
//		Method method = TestSuite.class.getDeclaredMethod(m[0].getName(), param);
//		method.invoke(null, results);

	}

	// What code smell does this exhibit and why? You don't need to fix this 
	private GradeReport buildExpectedGradeReport(ArrayList<ArrayList<String>> resultsLists) {
		gradeReport = new GradeReport();
		for(ArrayList<String> results : resultsLists) {
			Test test = new Test();
			test.description = results.remove(0);
			test.pointsMax = Double.parseDouble(results.remove(0));
			test.expectedOutput.addAll(results);
			gradeReport.tests.add(test);
		}
		return gradeReport;
	}

	private void addActualResults(ArrayList<ArrayList<String>> resultsLists) {
		int i=0;
		for(ArrayList<String> results : resultsLists) {
			Test test = gradeReport.tests.get(i++);
			// Remove description and max points, already initialized with expected.
			results.remove(0);
			results.remove(0);
			test.actualOutput.addAll(results);
		}
	}

	private ArrayList<ArrayList<String>> readExpectedResults(File file) {
		ArrayList<ArrayList<String>> resultsLists = new ArrayList<>();

		try {
			Scanner expScan = new Scanner(file);

			while(expScan.hasNextLine()){
				ArrayList<String> results = new ArrayList<String>();
				// Ignore "#" delimeter. Not actually used!
				expScan.nextLine();
				results.add(expScan.nextLine());
				results.add(expScan.nextLine());
				int numAnswers = Integer.parseInt(expScan.nextLine());
				for(int i=0; i<numAnswers; i++) {
					results.add(expScan.nextLine());
				}
				resultsLists.add(results);
			}
			expScan.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return resultsLists;
	}

	private void saveResults(String results, File file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.print(results);
			writer.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestEngine testEngine = new TestEngine();

		if(testEngine.shouldGenerateExpectedResults) {
			testEngine.generateExpectedResults();
		}
		else {
			testEngine.generateActualResults();
		}
	}
}

