
import java.util.HashMap;
public class IDandPassword {

	HashMap<String,String> logininfo= new HashMap<String,String>();
	
	IDandPassword(){
		
		logininfo.put("Anu","PASSWORD");
		logininfo.put("Ananya","1234");
		logininfo.put("2003005","abc123");
	}
	
	protected HashMap getLoginInfo() {
		return logininfo;
	}
	
}
