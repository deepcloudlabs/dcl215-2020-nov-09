package com.example.hr;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.HireEmployeeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = HrMicroserviceApplication.class)
@AutoConfigureMockMvc
class HrControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private ModelMapper modelMapper;

	@MockBean
	private HrApplication hrApplication;

	@Test
	@DisplayName("sends post request to hire an employee and receives OK(200)")
	void hireOneEmployeeSuccessfully() throws Throwable {
		// 1. Fixture
		HireEmployeeRequest request = new HireEmployeeRequest();
		request.setIdentity("11111111110");
		request.setFirstname("jack");
		request.setLastname("bauer");
		request.setIban("TR830006267681564933345177");
		request.setSalary(10_000);
		request.setCurrency(FiatCurrency.TRY);

		Employee employee = modelMapper.map(request, Employee.class);
		Mockito.when(hrApplication.hireEmployee(employee)).thenReturn(Optional.of(employee));

		mvc.perform( // 2. Call exercise method
			MockMvcRequestBuilders.post("/employees")
					.content(mapper.writeValueAsString(request))
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON_VALUE)
		)
		// 3. Verification
		.andExpect(status().isOk()).andExpect(jsonPath("status", is("ok")))
		.andExpect(jsonPath("employee.identity", is("11111111110")))
		.andExpect(jsonPath("employee.firstname", is("jack")))
		.andExpect(jsonPath("employee.lastname", is("bauer")))
		.andExpect(jsonPath("employee.salary", is(10_000.)))
		.andExpect(jsonPath("employee.iban", is("TR830006267681564933345177")))
		.andExpect(jsonPath("employee.currency", is("TRY")));
	}
	
	@Test
	@DisplayName("sends post request to hire an employee with invalid data and receives BAD REQUEST(400)")
	void hireInvalidEmployeeFails() throws Throwable {
		// 1. Fixture
		HireEmployeeRequest request = new HireEmployeeRequest();
		request.setIdentity("1");
		request.setFirstname("");
		request.setLastname("");
		request.setIban("TR1");
		request.setSalary(2000);
		request.setCurrency(FiatCurrency.TRY);
		
		mvc.perform( // 2. Call exercise method
				MockMvcRequestBuilders.post("/employees")
				.content(mapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				)
		// 3. Verification
		.andExpect(status().isBadRequest());
	}
	
	@Test
	@DisplayName("sends post request to hire an existing employee and receives BAD REQUEST(400)")
	void hireExistingEmployeeFails() throws Throwable {
		// 1. Fixture
		HireEmployeeRequest request = new HireEmployeeRequest();
		request.setIdentity("11111111110");
		request.setFirstname("jack");
		request.setLastname("bauer");
		request.setIban("TR830006267681564933345177");
		request.setSalary(10_000);
		request.setCurrency(FiatCurrency.TRY);
		
		Employee employee = modelMapper.map(request, Employee.class);
		Mockito.when(hrApplication.hireEmployee(employee)).thenReturn(Optional.empty());
		
		mvc.perform( // 2. Call exercise method
				MockMvcRequestBuilders.post("/employees")
				.content(mapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				)
		// 3. Verification
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("identity", is("11111111110")));
	}
	
	@Test
	@DisplayName("sends delete request to fire an employee and receives OK(200)")
	void fireOneEmployeeSuccessfully() throws Throwable {
		// 1. Fixture
		HireEmployeeRequest request = new HireEmployeeRequest();
		request.setIdentity("11111111110");
		request.setFirstname("jack");
		request.setLastname("bauer");
		request.setIban("TR830006267681564933345177");
		request.setSalary(10_000);
		request.setCurrency(FiatCurrency.TRY);
		
		var employee = modelMapper.map(request, Employee.class);
		Mockito.when(hrApplication.fireEmployee(TcKimlikNo.valueOf("11111111110"))).thenReturn(Optional.of(employee));
		
		mvc.perform( // 2. Call exercise method
				MockMvcRequestBuilders.delete("/employees/11111111110")
				.accept(MediaType.APPLICATION_JSON_VALUE)
		)
		// 3. Verification
		.andExpect(status().isOk()).andExpect(jsonPath("status", is("ok")))
		.andExpect(jsonPath("employee.identity", is("11111111110")))
		.andExpect(jsonPath("employee.firstname", is("jack")))
		.andExpect(jsonPath("employee.lastname", is("bauer")))
		.andExpect(jsonPath("employee.iban", is("TR830006267681564933345177")))
		.andExpect(jsonPath("employee.salary", is(10_000.)))
		.andExpect(jsonPath("employee.currency", is("TRY")));
	}
	
	@Test
	@DisplayName("sends delete request to fire an employee with invalid identity in request path and receives BAD REQUEST(400)")
	void fireOneEmployeeWithInvalidIdentityFails() throws Throwable {
		// 1. Fixture
		HireEmployeeRequest request = new HireEmployeeRequest();
		request.setIdentity("1");
		request.setFirstname("jack");
		request.setLastname("bauer");
		request.setIban("TR830006267681564933345177");
		request.setSalary(10_000);
		request.setCurrency(FiatCurrency.TRY);
		
		mvc.perform( // 2. Call exercise method
				MockMvcRequestBuilders.delete("/employees/1")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				)
		// 3. Verification
		.andExpect(status().isBadRequest());
	}
	
	@Test
	@DisplayName("sends delete request to fire non exisiting employee and receives NOT FOUND(404)")
	void fireNonExistingEmployeeFails() throws Throwable {
		// 1. Fixture
		HireEmployeeRequest request = new HireEmployeeRequest();
		request.setIdentity("11111111110");
		request.setFirstname("jack");
		request.setLastname("bauer");
		request.setIban("TR830006267681564933345177");
		request.setSalary(10_000);
		request.setCurrency(FiatCurrency.TRY);
		
		Mockito.when(hrApplication.fireEmployee(TcKimlikNo.valueOf("11111111110"))).thenReturn(Optional.empty());
		
		mvc.perform( // 2. Call exercise method
				MockMvcRequestBuilders.delete("/employees/11111111110")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				)
		// 3. Verification
		.andExpect(status().isNotFound())
		.andExpect(jsonPath("identity", is("11111111110")));
	}

}
