package com.capg.testcases;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.capg.test.bean.Questions;
import com.capg.test.service.QuestionsImp;

public class OnlineTest {

	static QuestionsImp service;

	@Before
	public void getQues() {
	service = new QuestionsImp();
	}

	Questions questionobj = new Questions();
	@Test
	public void testAddQuestion() {
		int res = service.addQuestion(questionobj);
		assertEquals(1, res);
	}
	
	@Test
	public void testDeleteQuestion() {
		questionobj.setQuestionId(12);
		int res = service.deleteQuestion(questionobj.getQuestionId(), questionobj);
		assertEquals(1, res);

	}
	
	@Test
	public void testUpdateQuestion() {
		int res = service.updateQuestion(questionobj, questionobj.getQuestionId());
		assertEquals(0, res);
	}
	
	@Test
	public void testGetResult() {
		questionobj.setQuestionMarks(-5);
		int res = service.getResult(questionobj.getQuestionMarks());
		assertEquals(0, res);
	}
	
}
