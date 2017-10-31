package beans;

public class Score {
	int studentID;
	int term;
	String subjectID;
	String subjectName;
	int credits;
	int courseID;	//Ma lop hoc
	float processScore;
	float finalScore;
	float overall;
	String letterScore;
	
	public Score(int studentID, int term, String subjectID, String subjectName, int credits, int courseID,
			float processScore, float finalScore, float overall, String letterScore) {
		this.studentID = studentID;
		this.term = term;
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.credits = credits;
		this.courseID = courseID;
		this.processScore = processScore;
		this.finalScore = finalScore;
		this.overall = overall;
		this.letterScore = letterScore;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public float getProcessScore() {
		return processScore;
	}

	public void setProcessScore(float processScore) {
		this.processScore = processScore;
	}

	public float getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(float finalScore) {
		this.finalScore = finalScore;
	}

	public float getOverall() {
		return overall;
	}

	public void setOverall(float overall) {
		this.overall = overall;
	}

	public String getLetterScore() {
		return letterScore;
	}

	public void setLetterScore(String letterScore) {
		this.letterScore = letterScore;
	}
	
	//===================getters and setters===============
	
	
}
