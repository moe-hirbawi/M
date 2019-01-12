package restServices;

import java.net.MalformedURLException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XkcdCaller {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(XkcdCaller.class);
	
	public JSONObject getRandomComic() throws MalformedURLException {
		WebTarget target = ClientBuilder.newClient().target("https://xkcd.com")
				.path("" + (int)((Math.random() * 2095) + 1))
				.path("info.0.json");
		
		LOGGER.info(target.getUri().toURL().toString());
		
		Response response = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get();
		String jsonString = response.readEntity(String.class);
		
		LOGGER.info(jsonString);
		
		JSONObject json = new JSONObject(jsonString);
		
		return json;
	}

}
