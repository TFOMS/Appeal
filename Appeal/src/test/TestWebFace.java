package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import res.PetitID;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestWebFace {
	
	WebClient webClient;
	HtmlPage page;
	HtmlForm form;
	
	@Before
	public void startMethod() throws InterruptedException, Exception {
		webClient = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(true);
		//webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		
		page = webClient.getPage("http://localhost:8082/Appeal");
	}
	
	@After
	public void stopMethod() throws InterruptedException, Exception {
		webClient.closeAllWindows();
	}

	@Test
	public void homePage() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
	    Assert.assertEquals("Обращения", page.getTitleText());
	    Assert.assertTrue(page.asText().contains("Запомнить меня"));
	}

	@Test
	public void loginAndAddTwoRecords() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		login();	
	    int curNum = new PetitID().readPetitID().getNum();
	    addRecord();
	    addRecord();
	    Assert.assertTrue(curNum + 2 == new PetitID().readPetitID().getNum());
	}

	private void addRecord() throws IOException {
		form = page.getFormByName("petit_form"); 
	    form.getInputByName("surname").setValueAttribute("surname");
	    form.getInputByName("name").setValueAttribute("name");
	    form.getInputByName("patrony").setValueAttribute("patrony");
	    form.getInputByName("policy").setValueAttribute("policy");
	    form.getInputByName("tel").setValueAttribute("tel");
	    form.getInputByName("adress").setValueAttribute("adress");
	    form.getInputByName("dateInput").setValueAttribute("01.01.2014");
	    form.getInputByName("ok_button").click();
	}

	private void login() throws IOException, MalformedURLException {
	    form = page.getFormByName("login_form");
	    form.getInputByName("j_username").setValueAttribute("sasha");
	    form.getInputByName("j_password").setValueAttribute("kjh987");
	    page = form.getInputByName("ok_button").click();
	    Assert.assertTrue(page.asText().contains("Регистрация обращений"));
	}
	
	@Test
	public void search() throws ElementNotFoundException, IOException {
		login();	
		page = page.getAnchorByText("Поиск").click();
		Assert.assertFalse(page.asText().contains("Параметры поиска"));
		page = page.getFormByName("search_form").getInputByName("more_button").click();
		Assert.assertTrue(page.asText().contains("Компенсация"));
		page = page.getFormByName("search_form").getInputByName("ok_button").click();
		Assert.assertTrue(page.asText().contains("Параметры поиска"));
		Assert.assertTrue(page.asText().contains("/"));
		page = page.getAnchorByText("Подробнее").click();
		Assert.assertTrue(page.asText().contains("Подробнее"));
	}
	
	@Test
	public void report() throws ElementNotFoundException, IOException {
		login();	
		page = page.getAnchorByText("Создать отчет").click();
		Assert.assertTrue(page.asText().contains("Жалобы с материальным возмещением"));
		form = page.getFormByName("reportAppealPay_form"); 
		form.getInputByName("dateBegin").setValueAttribute("01.01.2014");
		form.getInputByName("dateEnd").setValueAttribute("01.03.2014");
		form.getInputByName("reportAppealPay_button").click();
	}
	
}
