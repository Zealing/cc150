package OODesign;

public class CallCenter {
	public boolean isCall = false;
	Respondent r;
	
	public CallCenter() {
		// TODO Auto-generated constructor stub
		Respondent r = new Respondent();
	}
	
	public void dispatchCall() {
		if (isCall == true) {
			if (!r.isFull()) {
				r.goWork();
			}
		}
	}

}
