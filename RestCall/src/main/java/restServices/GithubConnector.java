package restServices;

import java.net.MalformedURLException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class GithubConnector {
	
	private final static String token = "";
	
	/**
	 * @param owner the username of the owner
	 * @param projectName the name of the github project
	 * @param inviteeUsername the github username of the person to be invited
	 * @return
	 * @throws MalformedURLException
	 */
	public JSONObject inviteUser(String owner, String projectName, String inviteeUsername) throws MalformedURLException {
		WebTarget target = ClientBuilder.newClient().target("https://api.github.com")
				.path("repos")
				.path(owner)//individuell
				.path(projectName)//indi
				.path("collaborators")
				.path(inviteeUsername);//indi
		
		//LOGGER.info(target.getUri().toURL().toString());
		JSONObject putEntity = new JSONObject();
		putEntity.put("permission", "admin");
		
		Response response = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token " + token).put(Entity.entity(putEntity.toString(), MediaType.APPLICATION_JSON));
		String jsonString = response.readEntity(String.class);
		
		//LOGGER.info(jsonString);
		
		JSONObject json = new JSONObject(jsonString);
		System.out.println(json.toString());
		
		// das hier ist der link, der dann per mail verschickt werden muss
		json.getString("html_url");
		
		return json;
	}

}
