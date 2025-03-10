package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.yaksha.assignment.utils.CustomParser;

public class UserInfoControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	// 1. Test for presence of ${name}, ${age}, and ${userAgent} in user-info.jsp
	@Test
	public void testRequestParamPresenceInUserInfoJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/user-info.jsp";

		// Check for dynamic content rendering such as name, age, and user-agent
		boolean hasDynamicName = CustomParser.checkJspTagPresence(filePath, "${name}");
		boolean hasDynamicAge = CustomParser.checkJspTagPresence(filePath, "${age}");
		boolean hasDynamicUserAgent = CustomParser.checkJspTagPresence(filePath, "${userAgent}");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasDynamicName && hasDynamicAge && hasDynamicUserAgent, businessTestFile);
	}

	// 2. Test for presence of <h1> tag in user-info.jsp
	@Test
	public void testH1TagPresenceInUserInfoJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/user-info.jsp";

		// Check for <h1> tag in user-info.jsp
		boolean hasH1Tag = CustomParser.checkJspTagPresence(filePath, "<h1>");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasH1Tag, businessTestFile);
	}

	// 3. Test if UserInfoController is annotated with @Controller
	@Test
	public void testUserInfoControllerAnnotation() throws Exception {
		String filePath = "src/main/java/com/yaksha/assignment/controller/UserInfoController.java";

		// Check if the class is annotated with @Controller
		boolean hasControllerAnnotation = CustomParser.checkClassAnnotation(filePath, "Controller");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasControllerAnnotation, businessTestFile);
	}

	// 4. Test if getUserInfo() method is annotated with @GetMapping("/user/info")
	@Test
	public void testGetUserInfoMethodAnnotation() throws Exception {
		String filePath = "src/main/java/com/yaksha/assignment/controller/UserInfoController.java";

		// Check if getUserInfo method has the correct @GetMapping annotation with the
		// correct URL
		boolean hasGetMappingAnnotation = CustomParser.checkMethodAnnotationWithValue(filePath, "GetMapping",
				"/user/info");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasGetMappingAnnotation, businessTestFile);
	}

	// 5. Test if getUserInfo() method contains @RequestParam for "name" and "age"
	// and @RequestHeader for "User-Agent"
	@Test
	public void testGetUserInfoParameters() throws Exception {
		String filePath = "src/main/java/com/yaksha/assignment/controller/UserInfoController.java";

		// Check if the getUserInfo method contains @RequestParam for name, age, and
		// @RequestHeader for User-Agent
		boolean hasRequestParamAnnotations = CustomParser.checkMethodParameterAnnotationWithValue(filePath,
				"getUserInfo", "RequestParam", "name")
				&& CustomParser.checkMethodParameterAnnotationWithValue(filePath, "getUserInfo", "RequestParam", "age")
				&& CustomParser.checkMethodParameterAnnotationWithValue(filePath, "getUserInfo", "RequestHeader",
						"User-Agent");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasRequestParamAnnotations, businessTestFile);
	}
}
