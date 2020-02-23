package com.capg.test.service;

import java.util.Map;
import java.util.Set;

import com.capg.test.bean.Questions;

import com.capg.test.dao.IQuestionsDAO;
import com.capg.test.dao.QuestionsDAO;

public class QuestionsImp implements IQuestions {

	IQuestionsDAO dao = new QuestionsDAO();
	QuestionsDAO dao1 = new QuestionsDAO();

	public int addQuestion(Questions question) {
		// TODO Auten7erated method stub
		return dao.addQuestion(question);
	}

	public int updateQuestion(Questions question, int marks) {
		// TODO Auto-generated method stub
		return dao.updateQuestion(question, marks);
	}

	public Set<Integer> getAllQuestions(int id1) {
		// TODO Auto-generated method stub
		return dao.getAllQuestions(id1);
	}

	public int getResult(int i) {
		return dao.getResult(i);
	}

	public Map<Integer, Questions> getMap() {
		return dao1.getMap();
	}

	public static boolean isValidId(int questionId) {
		boolean flag = false;
		if (questionId != 0 && questionId <= 10) {
			flag = true;
		}
		return flag;
	}

	public static boolean isValidTitle(String questionTitle) {

		boolean flag = false;
		String str = questionTitle.toString();
		if (str.length() > 4 || str.matches("[0-9][+][0-9]")) {
			flag = true;
		}
		System.out.println("question " + flag);
		if (flag == false) {
			try {

				throw new Exception("invalid question Title");

			} catch (Exception e) {

				System.err.println(e);
				System.out.println("enter valid question title");
			}
		}
		return flag;
	}

	public static boolean isValidAnswer(int questionAnswer) {
		boolean flag = false;
		if (questionAnswer >= 0 && questionAnswer < 4) {
			flag = true;
		}
		if (flag == false) {
			try {

				throw new Exception("invalid question answer");

			} catch (Exception e) {

				System.err.println(e);
				System.out.println("enter valid question answer");
			}
		}

		return flag;
	}

	public static boolean isValidMarks(int questionMarks) {
		boolean flag = false;
		if (questionMarks > 0) {
			flag = true;
		}
		if (flag == false) {
			try {

				throw new Exception("invalid question marks");

			} catch (Exception e) {

				System.err.println(e);
				System.out.println("enter valid question marks");
			}
		}
		return flag;
	}

	public static boolean userValidations(Questions question)

	{
		boolean flag = false;
		if (isValidId(question.getQuestionId()) && isValidTitle(question.getQuestionTitle())
				&& isValidAnswer(question.getQuestionAnswer()) && isValidMarks(question.getQuestionMarks())) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int getResult(Questions questions) {
		// TODO Auto-generated method stub
		return dao.getResult(questions.getQuestionMarks());
	}
	@Override
	public int deleteQuestion(int questionId,Questions question) {
		// TODO Auto-generated method stub
		return dao.deleteQuestion(questionId,question);
	}
}
