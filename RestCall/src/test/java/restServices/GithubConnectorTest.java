package restServices;

import java.net.MalformedURLException;

import org.junit.Test;

public class GithubConnectorTest {
	
	@Test
	public void getRepositories() throws MalformedURLException {
		GithubConnector connector = new GithubConnector();
		connector.inviteUser();
		//connector.getRepos();
	}

}
