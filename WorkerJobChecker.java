
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class WorkerJobChecker {
	
	public static final Logger LOG = Logger.getLogger(Test.class.getName());
	
	public static Integer count = 0;
	public static final Integer LAPSE = 5000;
	public static LinkedList<String> st = new LinkedList<>();
	public static boolean helperBollean = true;
	public static void setStack() {
		st.push("A");
		st.push("B");
		st.push("C");
		st.push("D");
		st.push("E");
		st.push("F");
		st.push("G");
	}
	
	
	public static String checkQueue() {
		String result = "";
		if(st.size() == 4 && helperBollean) {
			st.push("A");
			st.push("B");
			st.push("C");
			helperBollean = false;
		}
		if(st.size() != 0) {
			result = st.pollLast();
			return result;
		} else {
			return "nothing";
		}
	}
	
	
	public static void main(String[] args) {
		setStack();
		new Timer().scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
		    	String result = checkQueue();
		    	LOG.info("element = " + result +" / "+ "records = "+ st.size());
		    	count++;
		    }
		},0,LAPSE);
	}
}
