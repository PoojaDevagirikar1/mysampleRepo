package com.application.testsuite.app.yourtestcases;



import com.application.testscenarios.HomePageScenarios;
import com.application.testsuite.base.UIAutomationBaseTestClass;
import com.application.testsuite.testdata.factory.TestDataReaderFactory;
import com.application.testsuite.testdata.web.beans.TestBean1;
import com.application.utils.annotations.Test;
import com.application.utils.annotations.TestData;




public class TC_01 extends UIAutomationBaseTestClass
{
	@Test(groups = {"tests"},description="Loream", invocationCount= 1)
	@TestData(type = TestDataReaderFactory.JSON, source = "Datasets1",dataBean ="com.application.testsuite.testdata.web.beans.TestBean")
	
	
	public void UserSpecificCart_ISO(TestBean1 TC_01_Testdatabean) throws InterruptedException
	{
		HomePageScenarios homePageScenarios =null;
		homePageScenarios = new HomePageScenarios();
		
		homePageScenarios.s_VerifyCustomerLogin();
		homePageScenarios.s_VerifyCustomerLogout();
		//homePageScenarios.s_test();
		//call next step 
		
	}
}
