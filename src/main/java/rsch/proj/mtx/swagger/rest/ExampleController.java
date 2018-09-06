package rsch.proj.mtx.swagger.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rsch.proj.mtx.swagger.entity.Example;
import rsch.proj.mtx.swagger.service.ExampleService;

@RestController
@RequestMapping("/examples")
@Api(value="examples", description="Data service operations on examples", tags=("examples"))
public class ExampleController {
	
	@Autowired
	private ExampleService exampleService;
	
	@GetMapping
	@ApiOperation(value="Get All Examples", notes="Get all examples in the system", nickname="getExamples")
	public List<Example> findAll() {
		return exampleService.lookup();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Get Specific Example", notes="Get specific examples in the system", nickname="getSpecificExample")
	public Example findById(@PathVariable int id) {
		return exampleService.getById(id);
	}
	
	@PostMapping
	@ApiOperation(value="Insert an Example", notes="Insert an example to the system", nickname="insertExample")
	public Example add(@RequestBody Example example) {
		return exampleService.save(example);
	}
	
	@PutMapping
	@ApiOperation(value="Update an Example", notes="Update an example in the system", nickname="updateExample")
	public Example update(@RequestBody Example example) {
		return exampleService.update(example);
	}
	
	@DeleteMapping
	@ApiOperation(value="Delete an Example", notes="Delete an example in the system", nickname="deleteExample")
	public Example delete(@RequestBody Example example) {
		return exampleService.delete(example);
	}
	
}
