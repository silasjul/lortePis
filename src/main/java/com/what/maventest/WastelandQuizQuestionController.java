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

public class WastelandQuizQuestionController extends GameController implements Initializable {

    @FXML
    private TextArea textAreaQuiz;

    @FXML
    public Button opt1, opt2, opt3, opt4;

    int counter = 0;
    static int correct = 0;
    static int wrong = 0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private GameController gameController;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        correct = 0;
        wrong = 0;
        loadWastelandQuestions();
    }

    private void loadWastelandQuestions() {
        if (counter == 0) {
            textAreaQuiz.appendText("1. What is poaching?" +
                    "\n A: The act of illegally hunting animals in nature. Usually done to rare, exotic or threatened species." +
                    "\n B: A person that takes care of animals in an animal conservation center. " +
                    "\n C: A tourist who takes pictures of animals. " +
                    "\n D: A person who specializes in identifying different species of animals");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 1) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("2. What are the consequence of poaching?" +
                    "\n A: Extinction of animals and loss of biodiversity." +
                    "\n B: Increases biodiversity." +
                    "\n C: Boosts population growth of certain species." +
                    "\n D: Promotes balance in the ecosystem.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 2) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("3. Where does the most poaching happen?" +
                    "\n A: Poaching is most prevalent in protected wildlife reserves where animals are well-guarded." +
                    "\n B: Poaching is a significant issue in various parts of Africa and Asia, where demand for exotic animal products is high, leading to the illegal hunting of endangered species." +
                    "\n C: Poaching primarily occurs in regions with extreme climates, as it makes it easier for poachers to evade authorities." +
                    "\n D: Poaching is more common in areas with low biodiversity, as there is less demand for rare animals.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 3) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("4. Where does the most poaching happen?" +
                    "\n A: Poaching is most prevalent in protected wildlife reserves where animals are well-guarded." +
                    "\n B: Poaching is more common in areas with low biodiversity, as there is less demand for rare animals." +
                    "\n C: Poaching primarily occurs in regions with extreme climates, as it makes it easier for poachers to evade authorities." +
                    "\n D: Poaching is a significant issue in various parts of Africa and Asia, where demand for exotic animal products is high, leading to the illegal hunting of endangered species.");

            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 4) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("5. What is biodiversity?" +
                    "\n A: It is the absence of animals, plants and microorganisms." +
                    "\n B: The different forms of life found in one place, such as a variety of animals, plants, fungi and microorganisms." +
                    "\n C: It is a computer- generated world different from the real world. It's a complex virtual environment made by machines to simulate life." +
                    "\n D: It is a spiritual connection between different ecosystems.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 5) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("6. Why is biodiversity important?" +
                    "\n A: Biodiversity is not important; it only serves aesthetic purposes in nature." +
                    "\n B: Biodiversity is crucial because it ensures that all species live in perfect harmony without any competition." +
                    "\n C: Biodiversity is important solely for the economic benefits it provides, such as the commercial value of rare animal species." +
                    "\n D: Biodiversity is essential for ecosystem stability, resilience, and the overall health of the planet, supporting various ecological functions and services.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 6) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("7. How does genetic diversity contribute to the resilience of a population in the face of environmental changes?" +
                    "\n A: To protect biodiversity, it's best to domesticate wild animals and keep them as pets to ensure their safety." +
                    "\n B: Building more highways and infrastructure in natural habitats is an effective way to safeguard biodiversity by providing animals with new living spaces." +
                    "\n C: Implementing conservation measures, such as habitat preservation, sustainable resource management, and combating illegal wildlife trade, is crucial for protecting biodiversity." +
                    "\n D: Biodiversity is preserved by introducing non-native species to different ecosystems to enhance their diversity.");
            opt1.setText("A");
            opt2.setText("B");
            opt3.setText("C");
            opt4.setText("D");
        } else if (counter == 7) {
            textAreaQuiz.clear();
            textAreaQuiz.appendText("8. How do you protect biodiversity?" +
                    "\n A: To protect biodiversity, it's best to domesticate wild animals and keep them as pets to ensure their safety." +
                    "\n B: Building more highways and infrastructure in natural habitats is an effective way to safeguard biodiversity by providing animals with new living spaces." +
                    "\n C: Implementing conservation measures, such as habitat preservation, sustainable resource management, and combating illegal wildlife trade, is crucial for protecting biodiversity." +
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

        if (counter == 7) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("WastelandResults.fxml"));
                root = loader.load();
                WastelandQuizResultController wastelandQuizResultController = loader.getController();
                wastelandQuizResultController.setGameController(gameController);

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadWastelandQuestions();
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

        if (counter == 7) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("WastelandResults.fxml"));
                root = loader.load();
                WastelandQuizResultController wastelandQuizResultController = loader.getController();
                wastelandQuizResultController.setGameController(gameController);

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadWastelandQuestions();
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

        if (counter == 7) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("WastelandResults.fxml"));
                root = loader.load();
                WastelandQuizResultController wastelandQuizResultController = loader.getController();
                wastelandQuizResultController.setGameController(gameController);

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadWastelandQuestions();
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

        if (counter == 7) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("WastelandResults.fxml"));
                root = loader.load();
                WastelandQuizResultController wastelandQuizResultController = loader.getController();
                wastelandQuizResultController.setGameController(gameController);

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadWastelandQuestions();
        }
    }

    boolean checkAnswer(String answer) {

        if (counter == 0) {
            return answer.equals("A");
        }
        if (counter == 1) {
            return answer.equals("A");
        }
        if (counter == 2) {
            return answer.equals("B");
        }
        if (counter == 3) {
            return answer.equals("D");
        }
        if (counter == 4) {
            return answer.equals("B");
        }
        if (counter == 5) {
            return answer.equals("D");
        }
        if (counter == 6) {
            return answer.equals("C");
        }
        if (counter == 7) {
            return answer.equals("C");
        }
        return false;
    }
}

