package com.capg.test.service;

import java.util.Set;

import com.capg.test.bean.Questions;

public interface IQuestions {

	int addQuestion(Questions question);

	int updateQuestion(Questions question, int marks);

	int deleteQuestion(int questionId,Questions question);

	int getResult(Questions questions);

}
