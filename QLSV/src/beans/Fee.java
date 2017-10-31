package beans;

public class Fee {
	int studentID;
	int term;
	int numOfCredit;
	int extraNumOfCredit;
	int creditFee;
	int extraFee;
	int total;
	public Fee(int studentID, int term, int numOfCredit, int extraNumOfCredit, int creditFee, int extraFee, int total) {
		super();
		this.studentID = studentID;
		this.term = term;
		this.numOfCredit = numOfCredit;
		this.extraNumOfCredit = extraNumOfCredit;
		this.creditFee = creditFee;
		this.extraFee = extraFee;
		this.total = total;
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
	public int getNumOfCredit() {
		return numOfCredit;
	}
	public void setNumOfCredit(int numOfCredit) {
		this.numOfCredit = numOfCredit;
	}
	public int getExtraNumOfCredit() {
		return extraNumOfCredit;
	}
	public void setExtraNumOfCredit(int extraNumOfCredit) {
		this.extraNumOfCredit = extraNumOfCredit;
	}
	public int getCreditFee() {
		return creditFee;
	}
	public void setCreditFee(int creditFee) {
		this.creditFee = creditFee;
	}
	public int getExtraFee() {
		return extraFee;
	}
	public void setExtraFee(int extraFee) {
		this.extraFee = extraFee;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
