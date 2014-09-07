package com.nabila.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nabila.domain.Result;
import com.nabila.repository.ResultRepository;

@Controller
@RequestMapping("/results")
public class ResultResource {

    private ResultRepository resultRepository;

    @Autowired
    public ResultResource(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Result> allResults() {
        return resultRepository.findAll();
    }

    @RequestMapping(value = "/{subject}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Result> findResultsBySubject(@PathVariable("subject") String subject) {
        List<Result> result = resultRepository.findBySubjectIgnoreCase(subject);
        if (result == null) {
            throw new ResultNotFoundException(subject);
        }
        return result;
    }

}
