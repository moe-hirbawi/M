package camundaBeispiel.RestCall;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

import restServices.XkcdCaller;

public class GetComic implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		XkcdCaller restCaller = new XkcdCaller();
		
		JSONObject json = restCaller.getRandomComic();
		
		execution.setVariable("img", json.get("img"));
		
		
	}

}
