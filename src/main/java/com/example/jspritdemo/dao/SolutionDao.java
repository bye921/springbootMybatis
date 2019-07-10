package com.example.jspritdemo.dao;

import com.example.jspritdemo.entity.Solution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionDao {

    List<Solution> getAll();

    void saveSolution(Solution solution);

    int getMaxId();
}
