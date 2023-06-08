import javax.swing.JLabel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GradeCalculator extends Application {
	
	private TextField labText = new TextField();
	private TextField reviewQuizText = new TextField();
	private TextField project1Text = new TextField();
	private TextField project2Text = new TextField();
	private TextField midTermText = new TextField();
	private TextField finalExamText = new TextField();
	private TextField finalWeightGradeText = new TextField();


	private Button displayGradeButton = new Button("Display Grade");
	private Button exitButton = new Button("Exit");
	private Button clearButton = new Button("Clear");
	
	@Override
	public void start(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		
		pane.setHgap(10);
		pane.setVgap(6);
		pane.add(displayGradeButton, 0, 0);
		pane.add(exitButton, 1, 0);
		pane.add(clearButton, 2, 0);
		pane.add(new Label("Activity"), 0, 1);
		pane.add(new Label("Weighted"), 1, 1);
		pane.add(new Label("Your Average"), 2, 1);
		
		pane.add(new Label("Labs"), 0, 2);
		Label labWeighColor = new Label();
		labWeighColor.setText("25");
		labWeighColor.setStyle("-fx-background-color: pink");
		pane.add(labWeighColor, 1, 2);
		pane.add(labText, 2, 2);
		
		pane.add(new Label("Review Quizzes"), 0, 3);
		Label quizWeighColor = new Label();
		quizWeighColor.setText("15");
		quizWeighColor.setStyle("-fx-background-color: pink");
		pane.add(quizWeighColor,1,3);
		pane.add(reviewQuizText, 2, 3);

		pane.add(new Label("Project #1"), 0, 4);
		Label project1WeighColor = new Label();
		project1WeighColor.setText("20");
		project1WeighColor.setStyle("-fx-background-color: pink");
		pane.add(project1WeighColor,1,4);
		pane.add(project1Text, 2, 4);

		pane.add(new Label("Project #2"), 0, 5);
		Label project2WeighColor = new Label();
		project2WeighColor.setText("20");
		project2WeighColor.setStyle("-fx-background-color: pink");
		pane.add(project2WeighColor,1,5);
		pane.add(project2Text, 2, 5);
		
		pane.add(new Label("Mid Term"), 0, 6);
		Label midtermColor = new Label();
		midtermColor.setText("10");
		midtermColor.setStyle("-fx-background-color: pink");
		pane.add(midtermColor,1,6);
		pane.add(midTermText, 2, 6);
		
		pane.add(new Label("Final Exam"), 0, 7);
		Label finalColor = new Label();
		finalColor.setText("10");
		finalColor.setStyle("-fx-background-color: pink");
		pane.add(finalColor,1,7);
		pane.add(finalExamText, 2, 7);
		
		pane.add(new Label("Final Weighted Grade"),1,9);
		pane.add(finalWeightGradeText,2,9);

		
		exitButton.setOnAction(e -> {
	            Platform.exit();});
		
		clearButton.setOnAction(event -> {
			labText.clear();
			reviewQuizText.clear();
			project1Text.clear();
			project2Text.clear();
			midTermText.clear();
			finalExamText.clear();
			finalWeightGradeText.clear();
			  });
		 
		finalWeightGradeText.setEditable(false);
		
		displayGradeButton.setOnAction(e -> calculateGrade());

		
		Scene scene = new Scene(pane, 700, 500);
		primaryStage.setTitle("My Grade"); 
		primaryStage.setScene(scene);
		primaryStage.show(); 
		
	}
	
	public void calculateGrade(){
		
		double labGrade = Double.parseDouble(labText.getText());
		double reviewQuizGrade = Double.parseDouble(reviewQuizText.getText());
		double project1Grade = Double.parseDouble(project1Text.getText());
		double project2Grade = Double.parseDouble(project2Text.getText());
		double midTermGrade = Double.parseDouble(midTermText.getText());
		double finalExamGrade = Double.parseDouble(finalExamText.getText());

		FinalGradeCalc finalGrade = new FinalGradeCalc(labGrade,reviewQuizGrade,project1Grade,project2Grade,midTermGrade,finalExamGrade);
		
		finalWeightGradeText.setText(String.format("%.2f",finalGrade.WeightedGrade()));


		
	}

	public static void main(String[] args) {
			launch(args);
		}
	class FinalGradeCalc{
		private double weightedGrade;
		private double labWeight;
		private double quizWeight;
		private double project1Weight;
		private double project2Weight;
		private double midTermWeight;
		private double finalWeight;
		
		public FinalGradeCalc() {
			
		}
		public double getWeightedGrade() {
			return weightedGrade;
		}
		public void setWeightedGrade(double weightedGrade) {
			this.weightedGrade = weightedGrade;
		}
		public double getLabWeight() {
			return labWeight;
		}
		public void setLabWeight(double labWeight) {
			this.labWeight = labWeight;
		}
		public double getQuizWeight() {
			return quizWeight;
		}
		public void setQuizWeight(double quizWeight) {
			this.quizWeight = quizWeight;
		}
		public double getProject1Weight() {
			return project1Weight;
		}
		public void setProject1Weight(double project1Weight) {
			this.project1Weight = project1Weight;
		}
		public double getProject2Weight() {
			return project2Weight;
		}
		public void setProject2Weight(double project2Weight) {
			this.project2Weight = project2Weight;
		}
		public double getMidTermWeight() {
			return midTermWeight;
		}
		public void setMidTermWeight(double midTermWeight) {
			this.midTermWeight = midTermWeight;
		}
		public double getfinalWeight() {
			return finalWeight;
		}
		public void setfinalWeight(double finalWeight) {
			this.finalWeight = finalWeight;
		}
		
		public  FinalGradeCalc(double labWeight, double quizWeight, double project1Weight, double project2Weight, double midTermWeight, double finalWeight) {
			
			this.labWeight = labWeight;
			this.quizWeight = quizWeight;
			this.project1Weight = project1Weight;
			this.project2Weight = project2Weight;
			this.midTermWeight = midTermWeight;
			this.finalWeight = finalWeight;
			
			
		}
		
		public double WeightedGrade() {
			weightedGrade = (labWeight * .25) + (quizWeight * .15) + (project1Weight * .20) + (project2Weight * .20) + (midTermWeight * .10) + (finalWeight * .10);
			
			return weightedGrade;
		}
		
	}
}
