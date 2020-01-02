package jugo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = TestAPI.class)
public class TestAPI {
	
	 @InjectMocks
	 GreetingController controller;
	
	@Test
	public void testId() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
       
        Greeting result = controller.greeting(null);
        
        assertThat(result.getId()).isNotEqualTo(2);
        
        assertThat(result.getId()).isEqualTo(1L);
	}
	
	@Test
	public void testContentWithOutParams() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
       
        Greeting result = controller.greeting(null);
        
        assertThat(result.getContent()).isEqualTo("Hello, null!");
	}
	
	@Test
	public void testContentWithParams() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
       
        Greeting result = controller.greeting("Hugo");
        
        assertThat(result.getContent()).isEqualTo("Hello, Hugo!");
	}

}
