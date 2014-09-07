package com.nabila.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nabila.domain.Result;

@Repository
public interface ResultRepository extends CrudRepository<Result, String> {

    public List<Result> findAll();
    
    public List<Result> findBySubjectIgnoreCase(String subject);
}

/*public class ResultRepository{
	private static List<Result> results = new ArrayList<Result>();
	public ResultRepository(){
		Result r1 = new Result();
		r1.setSchool("St. Aaron College");
		r1.setSubject("numeracy");
		r1.setFactoredGainY3Y5(69.81);
		r1.setGlgY3Y5(113.52757826);
		r1.setLatestGainInGainY3Y5(-7.0);
		r1.setLatestY3(413.55);
		r1.setLatestY5(494.25);
		r1.setLatestY7(0.0);
		r1.setLatestY9(0.0);
		r1.setRawGainY3Y5(61.4917);
		
		Result r2 = new Result();
		r2.setSchool("St. Alan College");
		r2.setSubject("numeracy");
		r2.setFactoredGainY3Y5(69.81);
		r2.setGlgY3Y5(113.52757826);
		r2.setLatestGainInGainY3Y5(-7.0);
		r2.setLatestY3(413.55);
		r2.setLatestY5(494.25);
		r2.setLatestY7(0.0);
		r2.setLatestY9(0.0);
		r2.setRawGainY3Y5(61.4917);
		
		results.add(r1);
		results.add(r2);
	}
	
	public List<Result> findAll(){
		return results;
	}
	
	public Result findOne(String subject){
		return results.get(0);
	}
}*/
