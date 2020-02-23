package com.capg.test.dao;

import java.util.Set;

import com.capg.test.bean.Questions;

public interface IQuestionsDAO {

	int addQuestion(Questions question);

	int updateQuestion(Questions question, int marks);

	Set<Integer> getAllQuestions(int id1);

	int getResult(int i);

	int getResult(Questions question);

	int deleteQuestion(int questionId, Questions question);
}
