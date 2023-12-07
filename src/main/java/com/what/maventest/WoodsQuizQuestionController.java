package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WoodsQuizQuestionController extends GameController implements Initializable {

    @FXML
    private TextArea textAreaQuiz;
    @FXML
    public Button opt1, opt2, opt3, opt4;

    int counter = 0;
    static int correct = 0;
    static int wrong = 0;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        correct = 0;
        wrong = 0;
        loadWoodQuestions();
    }

    private void loadWoodQuestions() {
        if (counter == 0) {
            textAreaQuiz.appendText("First up, the Deforestation and Environmental degradation Quiz!!!" +
                    "\n " +
                    "\n 1. What is defined as deforestation in the text?" +
                    "\n " +
                    "\n A: An increase in forested areas." +
                    "\n " +
                    "\n B: A process of planting more trees." +
                    "\n " +
                    "\n C: The removal of forest areas due to human activity." + // korrekt
                    "\n " +
                    "\n D: Natural renewal of the forest population");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 1) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("2.According to the text, what are the consequences of deforestation?" +
                    "\n " +
                    "\n A: Increased biodiversity." +
                    "\n " +
                    "\n B: Improved environmental quality." +
                    "\n " +
                    "\n C: Threats to the environment, biodiversity, and local communities." + // korrekt
                    "\n " +
                    "\n D: Reduction of CO2 in the atmosphere.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 2) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("3. What role do forests play in the carbon cycle, and what happens when they are cleared?" +
                    "\n " +
                    "\n A: Forests release carbon dioxide when cleared." +
                    "\n " +
                    "\n B: Forests have no impact on the carbon cycle." +
                    "\n " +
                    "\n C: Clearing forests has no effect on carbon levels." +
                    "\n " +
                    "\n D: Forests act as carbon sinks, absorbing carbon dioxide during photosynthesis.."); // korrekt
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 3) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText(" 4.Besides threatening biodiversity, what other serious consequence does deforestation have on the climate?" +
                    "\n " +
                    "\n A: Contribution to the greenhouse effect and climate change" + // korrekt
                    "\n " +
                    "\n B: Improved climate conditions." +
                    "\n " +
                    "\n C: Increased rainfall." +
                    "\n " +
                    "\n D: Enhanced temperature regulation.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 4) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("5.What human activities are commonly identified as drivers of deforestation?" +
                    "\n " +
                    "\n A: Forest restoration projects." +
                    "\n " +
                    "\n B: Urbanization, mining, and agriculture." + // korrekt
                    "\n " +
                    "\n C: Wildlife protection initiatives." +
                    "\n " +
                    "\n D: Sustainable forest management practices.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 5) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("6. Why do forests play a role in preventing soil erosion?" +
                    "\n " +
                    "\n A: Forests contribute to soil erosion." +
                    "\n " +
                    "\n B: Forests help prevent soil erosion." + // korrekt
                    "\n " +
                    "\n C: Forests have no impact on soil stability." +
                    "\n " +
                    "\n D: Soil erosion is unrelated to forest health.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 6) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("7.What is emphasized as crucial for combating deforestation and ensuring a sustainable future?" +
                    "\n " +
                    "\n A: Increasing deforestation rates." +
                    "\n " +
                    "\n B: Expanding agricultural activities in forested areas." +
                    "\n " +
                    "\n C: Implementing sustainable forest management practices." + // korrekt
                    "\n " +
                    "\n D: Ignoring the impact of deforestation.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 7) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("8.What is the overarching message regarding the role of individuals and governments in addressing deforestation?" +
                    "\n " +
                    "\n A:  Individuals and governments have no role in addressing deforestation . " +
                    "\n " +
                    "\n B:  Governments alone are responsible for combating deforestation." +
                    "\n " +
                    "\n C:  Implementing conservation measures, such as habitat preservation, sustainable resource management, and combating illegal wildlife trade, is crucial for protecting biodiversity." + // korrekt
                    "\n " +
                    "\n D:  Only global initiatives can effectively address deforestation.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 8) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("And now for the Poaching and Biodiversity part of the Quiz!!!!" +
                    "\n " +
                    "\n 1. What is poaching?" +
                    "\n " +
                    "\n A: The act of illegally hunting animals in nature. Usually done to rare, exotic or threatened species." + // korrekt
                    "\n " +
                    "\n B: A person that takes care of animals in an animal conservation center. " +
                    "\n " +
                    "\n C: A tourist who takes pictures of animals. " +
                    "\n " +
                    "\n D: A person who specializes in identifying different species of animals");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 9) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("2. What are the consequence of poaching?" +
                    "\n " +
                    "\n A: Extinction of animals and loss of biodiversity." + // korrekt
                    "\n " +
                    "\n B: Increases biodiversity." +
                    "\n " +
                    "\n C: Boosts population growth of certain species." +
                    "\n " +
                    "\n D: Promotes balance in the ecosystem.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 10) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText(".3. Where does the most poaching happen?" +
                    "\n " +
                    "\n A: Poaching is most prevalent in protected wildlife reserves where animals are well-guarded." +
                    "\n " +
                    "\n B: Poaching is more common in areas with low biodiversity, as there is less demand for rare animals." +
                    "\n " +
                    "\n C: Poaching primarily occurs in regions with extreme climates, as it makes it easier for poachers to evade authorities." +
                    "\n " +
                    "\n D: Poaching is a significant issue in various parts of Africa and Asia, where demand for exotic animal products is high, leading to the illegal hunting of endangered species."); // korrekt
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 11) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("4. " +
                    "\n A: " +
                    "\n B: " +
                    "\n C: " +
                    "\n D: ");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 12) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("5. What is biodiversity?" +
                    "\n " +
                    "\n A: It is the absence of animals, plants and microorganisms." +
                    "\n " +
                    "\n B: The different forms of life found in one place, such as a variety of animals, plants, fungi and microorganisms." + // korrekt
                    "\n " +
                    "\n C: It is a computer- generated world different from the real world. It's a complex virtual environment made by machines to simulate life." +
                    "\n " +
                    "\n D: It is a spiritual connection between different ecosystems.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 13) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("6. Why is biodiversity important?" +
                    "\n " +
                    "\n A: Biodiversity is not important; it only serves aesthetic purposes in nature." +
                    "\n " +
                    "\n B: Biodiversity is crucial because it ensures that all species live in perfect harmony without any competition." +
                    "\n " +
                    "\n C: Biodiversity is important solely for the economic benefits it provides, such as the commercial value of rare animal species." +
                    "\n " +
                    "\n D: Biodiversity is essential for ecosystem stability, resilience, and the overall health of the planet, supporting various ecological functions and services."); // korrekt
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 14) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("7. How does genetic diversity contribute to the resilience of a population in the face of environmental changes?" +
                    "\n " +
                    "\n A: Genetic diversity increases the likelihood of some individuals having traits that enhance survival in changing conditions." + // korrekt
                    "\n " +
                    "\n B: Genetic diversity allows for a broader range of adaptations, improving the population's ability to cope with environmental challenges." +
                    "\n " +
                    "\n C: Genetic diversity hinders adaptability, making populations more vulnerable to environmental changes." +
                    "\n " +
                    "\n D: Genetic diversity has no impact on the resilience of a population in the face of environmental changes.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 15) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("8. How do you protect biodiversity?" +
                    "\n " +
                    "\n A: To protect biodiversity, it's best to domesticate wild animals and keep them as pets to ensure their safety." +
                    "\n " +
                    "\n B: Building more highways and infrastructure in natural habitats is an effective way to safeguard biodiversity by providing animals with new living spaces." +
                    "\n " +
                    "\n C: Implementing conservation measures, such as habitat preservation, sustainable resource management, and combating illegal wildlife trade, is crucial for protecting biodiversity. " + // korrekt
                    "\n " +
                    "\n D: Biodiversity is preserved by introducing non-native species to different ecosystems to enhance their diversity.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        }
    }

    @FXML
    public void opt1clicked(ActionEvent event) {
        checkAnswer(opt1.getText());
        if (checkAnswer(opt1.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }

        if (counter == 15) {
            Main.setScene("quizResults");
        } else {
            counter++;
            loadWoodQuestions();
        }
    }

    @FXML
    public void opt2clicked(ActionEvent event) {
        checkAnswer(opt2.getText());
        if (checkAnswer(opt2.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }

        if (counter == 15) {
            Main.setScene("quizResults");
        } else {
            counter++;
            loadWoodQuestions();
        }
    }

    @FXML
    public void opt3clicked(ActionEvent event) {
        checkAnswer(opt3.getText());
        if (checkAnswer(opt3.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }

        if (counter == 15) {
            Main.setScene("quizResults");
        } else {
            counter++;
            loadWoodQuestions();
        }
    }

    @FXML
    public void opt4clicked(ActionEvent event) {
        checkAnswer(opt4.getText());
        if (checkAnswer(opt4.getText())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }

        if (counter == 15) {
            Main.setScene("quizResults");
        } else {
            counter++;
            loadWoodQuestions();
        }
    }

    boolean checkAnswer(String answer) {
        String[] correctAnswer = {"C", "C", "D", "A", "B", "B", "C", "C", "A", "A", "D", ".", "B", "D", "B", "C"};
        return correctAnswer[counter].equals(answer);
    }
}
