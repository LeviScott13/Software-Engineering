package hw1a;

import java.util.ArrayList;
import java.util.List;

public class GradeReport {

	double pointsMax=0.0;
	double pointsEarned=0.0;
	double percentCorrect=0.0;
	int numCorrect=0;
	int numTotal=0;
	List<Test> tests = new ArrayList<Test>();

	public GradeReport() {
	}

	public void addTest(Test test) {

	}

	public void assessTests() {
		for(Test test : tests) {
			test.assess();
			this.pointsMax += test.pointsMax;
			this.pointsEarned += test.pointsEarned;
		}
		this.percentCorrect = pointsEarned/pointsMax * 100.0;
	}

	public String expectedOutput() {
		/*
		 * Format is: "#" as test delimeter, followed by desc, max points, number of answers,
		 * then the actual answers. Note, delimeter is not used per se, simply used to make
		 * expected results file slightly more readable.
		 */
		StringBuilder res = new StringBuilder();
		int i=1;
		for(Test test : tests) {
			res.append("# Test " + (i++) + " Expected Results\n");
			res.append(test.description + "\n");
			res.append(test.pointsMax + "\n");
			res.append(test.expectedOutput.size() + "\n");
			for(String s : test.expectedOutput) {
				res.append(s + "\n");
			}
		}
		return res.toString();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		int i=1;
		for(Test test : tests) {
			res.append("Test " + (i++) + "-" + test + "\n");
		}

		res.append(String.format("Overall Summary: %.1f points out of %.1f (%.1f%%)\n",
				pointsEarned, pointsMax, percentCorrect));

		return res.toString();
	}
}
