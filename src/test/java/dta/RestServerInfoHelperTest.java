package dta;

import org.junit.Assert;

import org.junit.Test;

public class RestServerInfoHelperTest {

	@Test
	public void testProtocol(){
		RestServerInfoHelper restServerInfoHelper=new RestServerInfoHelper();
		RestServerInfo restServerInfo=restServerInfoHelper.getRestServerInfo();
		Assert.assertEquals("http", restServerInfo.getProtocol());
	}
	
	@Test
	public void testHost(){
		RestServerInfoHelper restServerInfoHelper=new RestServerInfoHelper();
		RestServerInfo restServerInfo=restServerInfoHelper.getRestServerInfo();
		Assert.assertEquals("localhost", restServerInfo.getHost());
	}
	
	@Test
	public void testPort(){
		RestServerInfoHelper restServerInfoHelper=new RestServerInfoHelper();
		RestServerInfo restServerInfo=restServerInfoHelper.getRestServerInfo();
		Assert.assertEquals("8080", restServerInfo.getPort());
	}
	
	
	
}
