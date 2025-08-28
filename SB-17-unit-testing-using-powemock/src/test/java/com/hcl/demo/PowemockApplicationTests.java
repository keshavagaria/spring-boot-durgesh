package com.hcl.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.hcl.demo.dto.OrderRequest;
import com.hcl.demo.dto.OrderResponse;
import com.hcl.demo.service.OrderService;
import com.hcl.demo.util.NotificationUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.hcl.demo.*")
class PowemockApplicationTests {

	OrderRequest orderRequest = new OrderRequest(111, "Mobile", 1, 10000, "test@gmail.com", true);	
	public PowemockApplicationTests() {}

	@InjectMocks
	private OrderService orderService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(NotificationUtil.class);
	}

	@Test
	public void testStaticMethod() {
		
		//given 
		String emailid = "test@gmail.com";
		PowerMockito.mockStatic(NotificationUtil.class);
		//when
		when(NotificationUtil.sendEmail(emailid)).thenReturn("success");
		
		//then
		
		OrderResponse orderResponse =  orderService.checkOutOrder(orderRequest);
		assertEquals("success", orderResponse.getMessage());
	}
	
	@Test
	public void testPrivateMethod() throws Exception{
		//given
		//when
		OrderService spy =  PowerMockito.spy(orderService);
		doReturn(1000).when(spy,"addDiscount",ArgumentMatchers.any());
		
		//then
		OrderResponse response =  spy.checkOutOrder(orderRequest);
		int price = response.getResponse().getPrice();
		System.out.println("Price: "+price);
		assertEquals(9000, price);
	}
}
