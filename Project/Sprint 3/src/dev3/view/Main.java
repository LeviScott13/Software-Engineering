package dev3.view;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev3.Answer;
import dev3.Group;
import dev3.Member;
import dev3.PersistenceManager;
import dev3.Post;
import dev3.Question;
import dev3.SiteManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	
	private static SiteManager site = new SiteManager();
	private static File file = new File(".\\Save.bin");
	
	private static Member currentUser;
	private static Group currentGroup;
	private static Question currentQuestion;
	private static Answer currentAnswer;
	private static Post currentPost;
	
	public static void main(String[] args) throws IOException {
		
		/*
		site.addGroup("Team3_fall18", "We wrote lots of code and had lots of questions. There where so many questions, I just couldn't answer them all. \n -The group creator");
		site.addGroup("Wallace's Group", "This a group by Wallace, with a description by Wallace, and with a memeber named Wallace \n -Wallace");
		site.addGroup("Savon's Group", "We need so many popups. Why is noone making popups? We'll find the answer");
		site.addGroup("Levi's Group", "This a group for Levi and all Levi related people.");
		site.addGroup("Harlans's Group", "Group description, Group description, Group description, Group description");
		site.addGroup("How to code", "This a group for those who code, and need a little help from time to time.");

		
		site.addMember("Wallace", "Coleman", "wallace", "wlcoleman@valdosta.edu");
		
		site.addMember("Levi", "Sutton", "Samcro", "levisutton@gmail.com");
		site.getMember("levisutton@gmail.com").joinGroup(site.getGroup("Team3_fall18"), LocalDateTime.now());
		site.getMember("levisutton@gmail.com").joinGroup(site.getGroup("Levi's Group"), LocalDateTime.now());
		site.getMember("levisutton@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		site.addMember("Savon", "Jackson", "JackOfSpades", "savon9ijackzon@gmail.com");
		site.getMember("savon9ijackzon@gmail.com").joinGroup(site.getGroup("Team3_fall18"), LocalDateTime.now());
		site.getMember("savon9ijackzon@gmail.com").joinGroup(site.getGroup("Savon's Group"), LocalDateTime.now());
		site.getMember("savon9ijackzon@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		site.addMember("Harlan", "Haris", "hgharris", "dawgsNotOnTop@yahoo.com");
		site.getMember("dawgsNotOnTop@yahoo.com").joinGroup(site.getGroup("Team3_fall18"), LocalDateTime.now());
		site.getMember("dawgsNotOnTop@yahoo.com").joinGroup(site.getGroup("Harlans's Group"), LocalDateTime.now());
		site.getMember("dawgsNotOnTop@yahoo.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		//Generic members
		site.addMember("Aaron", "Anderson", "AARon", "aaronAndy@gmail.com");
		site.getMember("aaronAndy@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		site.addMember("Billy", "Bob", "BillyBob", "BillyB@gmail.com");
		site.getMember("BillyB@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		site.addMember("Carl", "Carson", "CCarson", "cDog@gmail.com");
		site.getMember("cDog@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		site.addMember("Dolly", "Danka", "DeeDee", "DollyDee@gmail.com");
		site.getMember("DollyDee@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());

		site.addMember("Erik", "Erkison", "EerieE", "Erik@gmail.com");
		site.getMember("Erik@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		site.addMember("Faith", "Farson", "Faith", "faith@gmail.com");
		site.getMember("faith@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		site.addMember("George", "Garison", "Georgie", "georgie@gmail.com");
		site.getMember("georgie@gmail.com").joinGroup(site.getGroup("How to code"), LocalDateTime.now());
		
		
		
		
		site.getMember("wlcoleman@valdosta.edu").joinGroup(site.getGroup("Wallace's Group"), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").joinGroup(site.getGroup("Team3_fall18"), LocalDateTime.now());
		
		
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("How do you ask questions?", "I really would like to know, how do you ask questions?", LocalDateTime.now()), LocalDateTime.now());
		
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0), "You just ask very nicely.", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0), "You think of what you want to know, then let people know you want an answer.", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0), "Navigate to add questions, then fill out the form.", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0), "Ask the person who asked this question for you.", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0), "I'm sure it'll come to you", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Wallace's Group")).get(0), "You think of what you want to know, then let people know you want an answer.", LocalDateTime.now()));
		
		
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Team3_fall18"), new Question("How do you write a print statement?", "I've tried system.in.print, but it didn't work.", LocalDateTime.now()), LocalDateTime.now());
		
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0), "Have you tired New.system.in.print?", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0), "You need to use System.out.print or System.out.println", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0), "Just capitalize System and change in to out.", LocalDateTime.now()));
		site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0).addAnswer(new Answer(site.getMember("wlcoleman@valdosta.edu").getQuestions(site.getGroup("Team3_fall18")).get(0), "You could try using eclipse, it'll help with simple problems", LocalDateTime.now()));

		
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("I need more questions, how do I get more questions", "I really would like to know, how do you add questions?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("What is 5 * 5", "How fo you multipy this", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("How we stop them?", "Who am I talking about?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Math is hard", "Can you tell me what 7 + 3 is?", LocalDateTime.now()), LocalDateTime.now());
		
		
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Questions", "What are questions?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("How to replace a battery", "How do you replace a cellphone battery?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Small battery", "What is that small battery in laser pointers called?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Big batter", "What is that huge battery in flashlights called?", LocalDateTime.now()), LocalDateTime.now());
		
		
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Battery won't charge", "My laptop works when it's plugged in, but the battery won't charge. What's going on?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Do you member?", "I member", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("How to tie a shoe", "I can't tell which lace goes first", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("How to write a poem", "How do we write peotry", LocalDateTime.now()), LocalDateTime.now());
		

		
		
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Battery overheating", "My phone battery gets hot when I have a lot of apps open at the same time.", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("How to start a letter", "Do I need to write dear to everyone, or is there someting else I can start with?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("What is 42?", "I know its the ultimate answer, but what is the ultimate question?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("How many horns does a unicorn have?", "I've been led to believe they have 6, but now I'm startint to doubt it", LocalDateTime.now()), LocalDateTime.now());
		
		
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Why does it rain?", "Are the clouds sad?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Why is the sky blue?", "Is it sad?", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Who wrote The Dark Tower?", "", LocalDateTime.now()), LocalDateTime.now());
		site.getMember("wlcoleman@valdosta.edu").addQuestion(site.getGroup("Wallace's Group"), new Question("Why are books made of paper?", "Wouldn't thin pieces of wood be better?", LocalDateTime.now()), LocalDateTime.now());
		
		
		PersistenceManager.save(site, file);
		*/
		site = PersistenceManager.read(file);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("API");
		showMainView();
		showLogIn();
		
		//showJoinGroup();
		//showCreateGroup();
		//showQuestionDetails();
	}

	
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Home.fxml"));
		mainLayout = loader.load();
		
		Scene scene = new Scene(mainLayout, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	
	
	private void showLogIn() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("SignIn.fxml"));
		

		BorderPane signIn = loader.load();
		mainLayout.setCenter(signIn);
		
	}
	
	
	public void showIncompleteFieldsPopup() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("IncompleteFieldsPopup.fxml"));
		
		BorderPane loadable = loader.load();
		
		Stage addingdialogStage = new Stage();
		addingdialogStage.setTitle("Incomplete Fields");
		addingdialogStage.initModality(Modality.WINDOW_MODAL);
		addingdialogStage.initOwner(primaryStage);
		
		Scene scene = new Scene(loadable);
		addingdialogStage.setScene(scene);
		addingdialogStage.show();
	}
	
	public void showNoMatchPopup() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("NoMatchPopup.fxml"));
		
		BorderPane loadable = loader.load();
		
		Stage addingdialogStage = new Stage();
		addingdialogStage.setTitle("No Match");
		addingdialogStage.initModality(Modality.WINDOW_MODAL);
		addingdialogStage.initOwner(primaryStage);
		
		Scene scene = new Scene(loadable);
		addingdialogStage.setScene(scene);
		addingdialogStage.show();
	}
	

	public void showJoinGroup() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("JoinGroup.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
	}
	
	public void showCreateGroup() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("CreateGroup.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
	}
	
	public void showAddQuestion() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("AddQuestion.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
		
		Main controllerGroupDetails = loader.getController();
		controllerGroupDetails.AddQuestionSetup();
	}
	
	public void showAddAnswer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("AddAnswer.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
		
		Main controllerGroupDetails = loader.getController();
		controllerGroupDetails.AddAnswerSetup();
	}
	
	public void showQuestionDetails() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("QuestionDetails.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
		
		Main controllerGroupDetails = loader.getController();
		controllerGroupDetails.QuestionDetailsSetup();
		
		
	}
	public void showHomeScreen() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("HomeScreen.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
		
		Main controllerGroupDetails = loader.getController();
		controllerGroupDetails.HomeScreenSetup();
	}
	
	public void showSearchResults() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("SearchResults.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
		
		Main controllerGroupDetails = loader.getController();
		controllerGroupDetails.SearchResultSetup();
	}
	
	public void showGroupDetails() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("GroupDetails.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
		
		Main controllerGroupDetails = loader.getController();
		controllerGroupDetails.GroupDetailsSetup();
		
	}
	
	public void showConfirmed() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Confirmed.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
	}
//	public void showFeedback() throws IOException {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("Feeback.fxml"));
//		
//		BorderPane loadable = loader.load();
//		mainLayout.setCenter(loadable);
//	}
	public void showFeedbackConfirmation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("FeedbackConfirmation.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
	}
//	public void showViewFeedBack() throws IOException{
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("ViewFeedBack.fxml"));
//		
//		BorderPane loadable = loader.load();
//		
//		Stage addingdialogStage = new Stage();
//		addingdialogStage.setTitle("FeedBack");
//		addingdialogStage.initOwner(primaryStage);
//		
//		Scene scene = new Scene(loadable);
//		addingdialogStage.setScene(scene);
//		addingdialogStage.show();
//		
//		Main controllerGroupDetails = loader.getController();
//		controllerGroupDetails.ViewFeedBackSetup();
//	}
	
	public void showFeedback() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Feedback.fxml"));
		
		BorderPane loadable = loader.load();
		mainLayout.setCenter(loadable);
		
		Main controllerGroupDetails = loader.getController();
		controllerGroupDetails.FeedbackSetup();
	}
	
	//*************************************************************************************
	//methods the controller parts need access to
	//*************************************************************************************
	
	
	public static List<Group> searchGroup(String key) throws IOException {
		
		List<Group> retrunable = site.getGroups(key);
		
		return retrunable;
	}
	
	public static List<Question> searchQuestionsWithMultipleGroups(List<Group> groups, String key){
		
		List<Question> questions = new ArrayList<>();
		for(int i = 0; i < groups.size(); i++) {
			List<Question> temp = groups.get(i).getQuestions();
			for(int j = 0; j < temp.size();j++) {
				if(temp.get(i).getTitle().trim().toLowerCase().contains(key.toLowerCase().trim()) ||
						key.toLowerCase().trim().contains(temp.get(i).getTitle().toLowerCase().trim())) {
					questions.add(temp.get(i));
				}
			}
		}
		return questions;	
	}
	
	public static List<Question> searchQuestionsOneGroup(Group group, String key){
		List<Question>returnable = new ArrayList<>();
		List<Question> temp = group.getQuestions();
		
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i).getTitle().toLowerCase().contains(key.toLowerCase())) {
				returnable.add(temp.get(i));
			}
		}
		
		return returnable;
	}
	
	
	//************************************************************************************************************************************
	//FXML JoinGroup controller
	//************************************************************************************************************************************

	
	@FXML
	TextField searchBar;
	
	@FXML
	ListView<String> groups;

	@FXML
	private void search() throws IOException {
		String x = searchBar.getText().trim();
//		ssss(x);
		
		groups.getItems().clear();
		
		List<Group> groupObjects = searchGroup(x);
		
		if(groupObjects == null) {
			showNoMatchPopup();
		}
		else {

			for(int i = 0; i < groupObjects.size(); i++) {

				groups.getItems().add(groupObjects.get(i).getTitle());

			}
			
		}
		
	}
		
	@FXML
	private void goToGroupDetails() throws IOException {
		
		String title = groups.getSelectionModel().getSelectedItem().trim();
		
		if(title == null) {
		}
		else {
			currentGroup = site.getGroup(title);
			
			showGroupDetails();
		}
		
	}
	
	//************************************************************************************************************************************
	//FXML SignIn Controller
	//************************************************************************************************************************************
	
	
	@FXML
	private TextField returningScreenName;
	
	@FXML
	private TextField returningEmail;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField screenName;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField email2;
	
	
	@FXML
	private void addMember() throws IOException {
		boolean successfullyAdded = site.addMember(firstName.getText().trim(), lastName.getText().trim(), screenName.getText().trim(), email.getText().trim());
		if(successfullyAdded) {
			currentUser = site.getMember(email.getText().trim());
			 showHomeScreen();
		}
		else {
			
		}
		PersistenceManager.save(site, file);
	}
	
	@FXML
	private void signIn() throws IOException {
		
		currentUser = site.getMember(returningEmail.getText().trim());
		
		if(returningEmail.getText().trim().equals("") || returningScreenName.getText().trim().equals("")) {
			showIncompleteFieldsPopup();
		}
		else if(currentUser == null) {
			showNoMatchPopup();
		}
		else {
			if(currentUser.getScreenName().equals(returningScreenName.getText().trim())) {
				 showHomeScreen();
			}
			else {
				showNoMatchPopup();
			}
		}
	}
	
	//************************************************************************************************************************************
	//FXML CreateGroup controller
	//************************************************************************************************************************************
		
	@FXML
	private TextField newGroupName;
	
	@FXML
	private TextArea newGroupDescription;
	
	
	
	@FXML
	private void addGroup() throws IOException {
		boolean groupSuccessfullyAdded = site.addGroup(newGroupName.getText().trim(), newGroupDescription.getText().trim());
		
		if(groupSuccessfullyAdded) {
			PersistenceManager.save(site, file);
			showHomeScreen();
		}
		else {
			
		}
		
		
	}
	
	
	//************************************************************************************************************************************
	//FXML QuestionDetails controller
	//************************************************************************************************************************************
	
	@FXML
	Label QuestionDetailsTitle;
	
	@FXML
	Label QuestinoDetailsQuestionText;
	
	@FXML
	ListView<String> QuestionDetailsAnswers;
	
	private void QuestionDetailsSetup() {
		QuestionDetailsTitle.setText(currentQuestion.getTitle());
		QuestinoDetailsQuestionText.setText(currentQuestion.getText());
		
		List<Answer> answers = currentQuestion.getAnswers();
		
		for(int i = 0; i < answers.size(); i++) {
			String feedbacks = "";
			for (int j = 0; j < answers.get(i).getFeedback().size(); j++) {
			
				feedbacks = feedbacks + "\n    +" + answers.get(i).getFeedback().get(j);
				
			}
			QuestionDetailsAnswers.getItems().add(answers.get(i).getText()+feedbacks);
		}
	}
	
	@FXML
	private void goToAddAnswer() throws IOException {
		showAddAnswer();
	}
	
	@FXML
	private void goToAddFeedback() throws IOException {
		if(QuestionDetailsAnswers.getSelectionModel().getSelectedItem() == null) {
			currentPost = currentQuestion;
		}
		else {
			for(int i = 0; i < currentQuestion.getAnswers().size(); i++) {
				
				String AnswerBody[] = QuestionDetailsAnswers.getSelectionModel().getSelectedItem().trim().split("\n");
				
				if(currentQuestion.getAnswers().get(i).getText().trim().equals(AnswerBody[0].trim())) {
					currentPost = currentQuestion.getAnswers().get(i);
				}
			}
		}
		showFeedback();
	}
	
//	@FXML
//	private void goToViewFeedBack() throws IOException {
//		if(QuestionDetailsAnswers.getSelectionModel().getSelectedItem() == null) {
//			currentPost = currentQuestion;
//		}
//		else {
//			for(int i = 0; i < currentQuestion.getAnswers().size(); i++) {
//				if(currentQuestion.getAnswers().get(i).getText().trim().equals(QuestionDetailsAnswers.getSelectionModel().getSelectedItem().trim())) {
//					currentPost = currentQuestion.getAnswers().get(i);
//				}
//			}
//		}
//		showViewFeedBack();
//	}

	//************************************************************************************************************************************
	//FXML controller HomeScreen
	//************************************************************************************************************************************
	@FXML
	private void goToJoinGroup() throws IOException{
		showJoinGroup();
	}
	@FXML
	private void goToCreateGroup() throws IOException{
		showCreateGroup();
	}
	@FXML
	private void goToAddQuestion() throws IOException{
		showAddQuestion();
	}
	@FXML
	private void goToSearchResults() throws IOException {
		showSearchResults();
	}
	@FXML
	private void goToLogIn() throws IOException {
		showLogIn();
	}
	
	@FXML
	Label HomeScreenScreenName;
	
	public void HomeScreenSetup() {
		HomeScreenScreenName.setText("Welcome back, " + currentUser.getScreenName());
	}
  
  //************************************************************************************************************************************
	//FXML Confirmation controller
	//************************************************************************************************************************************

  
//	@FXML
//	private void goToQuestionDetails() throws IOException {
//		showQuestionDetails();
//	}
  
  
	//************************************************************************************************************************************
	//FXML QuestionDetails controller
	//************************************************************************************************************************************

//	@FXML
//	private void goToFeedback() throws IOException {
//		showFeedback();
//	}
	//************************************************************************************************************************************
	//FXML  Feedback Confirmation controller
	//************************************************************************************************************************************
	
	@FXML
	private void goToFeedbackConfirmation() throws IOException {
		showFeedbackConfirmation();
	}
	
		

	//************************************************************************************************************************************
	//FXML GroupDetails controller 
	//************************************************************************************************************************************
	
	@FXML
	Label GroupDetailsGroupTitle;
	
	@FXML
	Label GroupDetailsGroupDescription;
	
	@FXML
	ListView<String> GroupDetailsMemberList;
	
	

	private void GroupDetailsSetup() {
		GroupDetailsGroupTitle.setText(currentGroup.getTitle());
		GroupDetailsGroupDescription.setText(currentGroup.getDescription());
		
		List<Member> activeMembers = currentGroup.getActiveMembers(10);
		
		for(int i = 0; i < activeMembers.size(); i++) {
			GroupDetailsMemberList.getItems().add(activeMembers.get(i).getScreenName());
			//GroupDetailsMemberList.getItems().add(0, activeMembers.get(i).getScreenName());
		}
	}
	
	@FXML
	private void joinGroupOnClick() throws IOException {
		boolean successfullyJoinedGroup = site.getMember(currentUser.getEmailAddress()).joinGroup(site.getGroup(currentGroup.getTitle()), LocalDateTime.now());
		currentUser = site.getMember(currentUser.getEmailAddress());
		if(successfullyJoinedGroup) {
			PersistenceManager.save(site,file);
			showConfirmed();
		}
		else {
			
		}
		
		
	}
	
	//************************************************************************************************************************************
	//FXML SearchResults controller 
	//************************************************************************************************************************************
	
	@FXML
	ListView<String> SearchResultsListView;
	
	@FXML
	TextField SearchResultsSearchBar;
	
	@FXML
	ChoiceBox<String> SearchResultsCheckBox;
	
	String groupName;
	
	//searchQuestionsWithMultipleGroups
	
	public void SearchResultSetup() {
			
			List<Group> groupObjects = currentUser.getGroups();
			
			for(int i = 0; i < groupObjects.size(); i++) {
				SearchResultsCheckBox.getItems().add(groupObjects.get(i).getTitle());
			}
		}
	
	@FXML
	private void SearchResultsSearch() {
		SearchResultsListView.getItems().clear();
		
		if(SearchResultsCheckBox.getSelectionModel().getSelectedItem() != null) {
			//ssss("got here");
			groupName = SearchResultsCheckBox.getSelectionModel().getSelectedItem();
			List<Question> temp = searchQuestionsOneGroup(site.getGroup(SearchResultsCheckBox.getSelectionModel().getSelectedItem()), SearchResultsSearchBar.getText().trim());
			for(int i = 0; i < temp.size(); i ++) {
				SearchResultsListView.getItems().add(temp.get(i).getTitle());
			}
			currentGroup = site.getGroup(groupName);
		}

	}
	
	@FXML
	private void goToQuestionDetails() throws IOException {
		if(SearchResultsListView.getSelectionModel().getSelectedItem() != null) {
			List<Question> temp = site.getGroup(groupName).getQuestions();
			for(int i = 0; i < temp.size(); i++) {
				if(temp.get(i).getTitle().equals(SearchResultsListView.getSelectionModel().getSelectedItem())) {
					currentQuestion = temp.get(i);
					currentPost = currentQuestion;
					showQuestionDetails();
					break;
				}
			}
			
		}
	}
	
	//************************************************************************************************************************************
	//FXML AddQuestion controller 
	//************************************************************************************************************************************
	
	@FXML
	TextField AddQuestionTextArea;
	
	@FXML
	ChoiceBox<String> AddQuestionChoiceBox;
	
	@FXML
	TextField AddQuestionTitle;
	
	public void AddQuestionSetup() {
		
		List<Group> groupObjects = currentUser.getGroups();
		
		for(int i = 0; i < groupObjects.size(); i++) {
			AddQuestionChoiceBox.getItems().add(groupObjects.get(i).getTitle());
		}
	}
	
	@FXML
	private void AddQuestionPost() throws IOException {
		if(AddQuestionChoiceBox.getSelectionModel().getSelectedItem() == null) {
			showIncompleteFieldsPopup();
		}
		else {
			boolean questionSuccessfullyAdded = site.getMember(currentUser.getEmailAddress()).addQuestion(
					site.getGroup(
						AddQuestionChoiceBox.getSelectionModel().getSelectedItem()),
						new Question(
							AddQuestionTitle.getText().trim(),
							AddQuestionTextArea.getText(),
							LocalDateTime.now()),
						LocalDateTime.now());
			if(questionSuccessfullyAdded) {
				PersistenceManager.save(site, file);
				showHomeScreen();
			}
			else {
				showIncompleteFieldsPopup();
			}
			
		}
	}
	
	//************************************************************************************************************************************
	//FXML AddAnswer controller 
	//************************************************************************************************************************************
	
	@FXML
	Label AddAnswerQuestionText;
	
	@FXML
	TextArea AddAnswerAnswerField;
	
	public void AddAnswerSetup(){
		AddAnswerQuestionText.setText(currentQuestion.getTitle() + "\n" + currentQuestion.getText());
	}
	
	@FXML
	private void AddAnswerAddAnswer() throws IOException {
		//currentQuestion.addAnswer(new Answer(currentQuestion, AddAnswerAnswerField.getText().trim(), LocalDateTime.now()));
		
		if(AddAnswerAnswerField.getText() != null) {
			if (!(AddAnswerAnswerField.getText().trim().equals(""))) {
				List<Question> questions;
				questions = site.getGroup(currentGroup.getTitle().trim()).getQuestions();
				for (int i = 0; i < questions.size(); i++) {
					if (questions.get(i).getTitle().equals(currentQuestion.getTitle())) {
						site.getGroup(currentGroup.getTitle()).getQuestions().get(i).addAnswer(new Answer(
								currentQuestion, AddAnswerAnswerField.getText().trim(), LocalDateTime.now()));
						break;
					}
				}
				PersistenceManager.save(site, file);
				showQuestionDetails();
			}
		}
	}
	
	@FXML
	private void AddAnswerAddAnswerEnterKey() throws IOException{
		if(AddAnswerAnswerField.getText().contains("\n")) {
			if(AddAnswerAnswerField.getText() != null) {
				if (!(AddAnswerAnswerField.getText().trim().equals(""))) {
					List<Question> questions;
					questions = site.getGroup(currentGroup.getTitle().trim()).getQuestions();
					for (int i = 0; i < questions.size(); i++) {
						if (questions.get(i).getTitle().equals(currentQuestion.getTitle())) {
							site.getGroup(currentGroup.getTitle()).getQuestions().get(i).addAnswer(new Answer(
									currentQuestion, AddAnswerAnswerField.getText().trim(), LocalDateTime.now()));
							break;
						}
					}
					PersistenceManager.save(site, file);
					showQuestionDetails();
				}
			}
		}
	}
	

	//************************************************************************************************************************************
	//FXML Feedback controller 
	//************************************************************************************************************************************
	
	@FXML
	TextArea FeedbackTextField;
	
	@FXML
	Label FeedbackTitle;
	
	public void FeedbackSetup(){
		FeedbackTitle.setText(currentPost.getText());
	}
	
	@FXML
	private void FeedbackAddFeedback() throws IOException {
		currentPost.addFeedback(FeedbackTextField.getText().trim());
		showQuestionDetails();
		PersistenceManager.save(site,file);
	}
	
	@FXML
	private void FeedbackAddFeedbackEnterKey(KeyEvent event) throws IOException {
		if (FeedbackTextField.getText().contains("\n"))
        {
	        	currentPost.addFeedback(FeedbackTextField.getText().trim());
	    		showQuestionDetails();
	    		PersistenceManager.save(site,file);
		}
	}
	
	
	//************************************************************************************************************************************
	//FXML ViewFeedBack controller 
	//************************************************************************************************************************************
	
	@FXML
	Label ViewFeedBackLabel;
	
	@FXML
	ListView<String> ViewFeedBackList;
	
	public void ViewFeedBackSetup(){
		ViewFeedBackLabel.setText(currentPost.getText());
		ViewFeedBackList.getItems().clear();
		for (int i = 0; i < currentPost.getFeedback().size();i++) {
			ViewFeedBackList.getItems().add(currentPost.getFeedback().get(i));
		}
	}
	
	//************************************************************************************************************************************
	//FXML controller shared methods
	//************************************************************************************************************************************
	@FXML
	private void goHome() throws IOException {
		showHomeScreen();
	}
	
	@FXML
	private void GlobalGoToQuestionDetails() throws IOException {
		showQuestionDetails();
	}
	
	
	
}
