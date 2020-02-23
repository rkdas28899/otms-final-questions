package com.capg.test.dao;

import java.util.Map;
import java.util.Set;

import com.capg.test.bean.Questions;
import com.capg.test.repository.MyRepository;
import com.capg.test.service.ValidateException;

public class QuestionsDAO implements IQuestionsDAO {
	public int addQuestion(Questions question) {
		// TODO Auto-generated method stub

		int add = MyRepository.addQuestion(question);

		return add;
	}

	public int updateQuestion(Questions question, int testid) {
		// TODO Auto-generated method stub
		int upd = 0;
		try {
			if(testid != 0 && question.getQuestionId() != 0) {
				upd = MyRepository.updateQuestion(question, testid);
			}
			else {
				throw new ValidateException("No question available for updation");
			}
		}catch(ValidateException e) {
			e.getMessage();
		}
		return upd;
	}

	public int deleteQuestion(Questions question, int testid) {
		// TODO Auto-generated method stub
		int del = 0;
		try {
		if(testid != 0 && question.getQuestionId()!= 0) {
			del = MyRepository.deleteQuestion(question,testid);
		}
		else {
			throw new ValidateException("No question to Delete");
		}
		}catch(ValidateException e) {
			e.getMessage();
		}
		return del;
	}
	
	@Override
	public int getResult(Questions question) {
		int res = 0;
		try {
			if(question.getQuestionId()!=0) {
				res = MyRepository.getResults(question);
			}
			else {
				throw new ValidateException("No question to get result");
			}
		}catch(ValidateException e) {
			e.getMessage();
		}
		return res;
	}

	public Map<Integer, Questions> getMap() {
		return MyRepository.getMap();
	}
	public int deleteQuestion(int questionId,Questions question) {
		// TODO Auto-generated method stub
		int del = 0;
		try {
		if(questionId != 0 && question.getQuestionId()!= 0) {
			del = MyRepository.deleteQuestion(question,questionId);
		}
		else {
			throw new ValidateException("No question to Delete");
		}
		}catch(ValidateException e) {
			e.getMessage();
		}
		return del;
	}

	@Override
	public Set<Integer> getAllQuestions(int id1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getResult(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
