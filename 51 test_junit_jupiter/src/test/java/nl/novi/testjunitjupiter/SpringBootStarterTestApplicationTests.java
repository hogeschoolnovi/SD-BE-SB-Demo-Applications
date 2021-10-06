package nl.novi.testjunitjupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest()
@ContextConfiguration(classes={TestJunitJupiterApplication.class})
class SpringBootStarterTestApplicationTests {

	@Test
	@DisplayName("Testing if context is correctly set")
	void ContextLoadsTest() {
		assertNotEquals(1, 2);
	}

}
