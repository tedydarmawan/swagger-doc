package rsch.proj.mtx.swagger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import rsch.proj.mtx.swagger.entity.Example;

@Service
public class ExampleService {
	
	private static List<Example> examples = new ArrayList<>();
	
	static {
		examples.addAll(
				Arrays.asList(new Example(1, "Example 1"), new Example(2, "Example 2"), 
						new Example(3, "Example 3"), new Example(4, "Example 4"), new Example(5, "Example 5"))
				);
	}
	
	public List<Example> lookup() {
		return examples;
	}
	
	public Example getById(int id) {
		for(Example e: examples) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	public Example save(Example e) {
		examples.add(e);
		return e;
	}
	
	public Example update(Example ex) {
		for(Example e: examples) {
			if(e.getId() == ex.getId()) {
				e.setDescription(ex.getDescription());
				return e;
			}
		}
		return null;
	}
	
	public Example delete(Example ex) {
		for(Example e: examples) {
			if(e.getId() == ex.getId()) {
				examples.remove(e);
				return e;
			}
		}
		return null;
	}
	
}
