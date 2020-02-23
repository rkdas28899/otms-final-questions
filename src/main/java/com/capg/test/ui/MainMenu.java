package com.capg.test.ui;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capg.test.bean.Questions;

import com.capg.test.repository.MyRepository;
import com.capg.test.service.IQuestions;
import com.capg.test.service.QuestionsImp;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IQuestions service = new QuestionsImp();
		QuestionsImp services = new QuestionsImp();
		Scanner sc = new Scanner(System.in);

		Map<Integer, Questions> map1 = MyRepository.goMap();

		int questionAdded = 0;
		while (true) {
			System.out.println("What you want to operate ");
			System.out.println("1.add Question");
			System.out.println("2.update Question ");
			System.out.println("3.delete Question ");
			System.out.println("4.Get Questions");
			System.out.println("5.Exit");
			Questions question = new Questions();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				int questionId = 0;
				try {
				System.out.print("Question Number:");
				questionId = sc.nextInt();
				sc.nextLine();
				}catch(Exception e) {
					System.err.println("Id cannot be string");
					break;
				}
				if(map1.containsKey(questionId)) {
					System.out.println("Question already exists, cannot add");
				}
				else {
				System.out.println("Question title:");
				String questionTitle = sc.nextLine();
				int n = 4;
				System.out.println("Add question options:");
				String[] questionOption = new String[n];
				for (int i = 0; i < n; i++) {
					questionOption[i] = sc.next();
				}
				int questionAnswer = 0;
				try {
				System.out.print("Enter key for question:");
					questionAnswer = sc.nextInt();
					if(questionAnswer>4 || questionAnswer<1) {
						throw new Exception("Invalid Key!!!");
				}
				}catch(Exception e) {
					e.getMessage();
				}
				System.out.print("Enter score:");
				int questionMarks = sc.nextInt();
				question.setQuestionId(questionId);
				question.setQuestionTitle(questionTitle);
				question.setQuestionOption(questionOption);
				question.setQuestionAnswer(questionAnswer);
				question.setQuestionMarks(questionMarks);
				boolean isValid = QuestionsImp.userValidations(question);
				if (isValid) {
					System.out.println("Question added successfully");
					map1.put(questionId, question);
					//System.out.println("Added question is "+map1.get(questionId));
					//questionAdded = service.addQuestion(question);
				} 
				else {
					System.out.println("invalid try!!!Try again");
				}
				}
				break;
			case 2:
				System.out.println("enter the questionId");
				questionId = sc.nextInt();
				if(map1.containsKey(questionId)) {
					System.out.println("enter the marks you want to update");
					int questionMarks = sc.nextInt();
					int updateQuestion = services.updateQuestion(question, questionMarks);
					map1.put(questionId, question);
				}
				else {
					System.out.println("No question to update");
				}
				break;
			case 3:
				System.out.println("enter the question to be deleted");
				int id = sc.nextInt();
				if(map1.containsKey(id)) {
					int deletedQuestion = service.deleteQuestion(id,question);
					Questions delete = map1.remove(id);
					System.out.println("Question is deleted");
					System.out.println("Deleted Question is "+delete);
				}
				else {
					System.out.println("no question to delete!!!");
				}
				break;
			case 4:
				if(map1.isEmpty()) {
					System.out.println("No questions to display!!!");
				}
				else {
				System.out.println("The questions are");
				for(int m:map1.keySet()) {
					Questions q = map1.get(m);
					System.out.println("Question id:"+q.getQuestionId());
					System.out.println("Question: "+q.getQuestionTitle());
					int i=0;
					for(String s:q.getQuestionOption()) {
						System.out.println("option "+i+":"+s);
						i++;
					}
					System.out.println("Question key:"+q.getQuestionAnswer());
					System.out.println("Question Marks:"+q.getQuestionMarks());
					System.out.println();
				}
				}
				break;
		
			case 5:
				System.out.println("Thank you!!");
				System.exit(0);
			default:
				System.out.println(" Invalid option");
			
				break;
			}

		}
		}
}
