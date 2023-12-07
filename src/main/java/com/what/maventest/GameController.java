package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    private Stage stage;
    private Scene scene;
    public Parent root;
    public Button talkToJoeButton;
    public Button talkToSabrinaButton;
    public Button talkToChuckButton;
    @FXML
    private TextArea textAreaOffice;
    @FXML
    private TextArea textAreaSafari;
    @FXML
    private TextArea textAreaWoods;

    @FXML private TextArea textAreaWasteland;

    private int talkCounter = 1;



    public void goToOffice(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Office.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToOutside(ActionEvent event) throws IOException {
        Main.stage.getScene().setRoot(new Region());
        Main.stage.setScene(Main.gameScene);
        Main.stage.show();
        Main.tl.play();
    }

    public void goToDesert(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Desert.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSafari(ActionEvent event) throws IOException {
        ActionEvent battleEvent;
        if (shouldInitiateBattle()) {
            battleEvent = event;
            initiateBattle(event);
        } else {
            root = FXMLLoader.load(getClass().getResource("Safari.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void goToWoods(ActionEvent event) throws IOException {
        ActionEvent quizWoodsEvent;
        if (shouldStartWoodsQuiz()) {
            quizWoodsEvent = event;
            StartWoodsQuiz(event);
        } else {
            root = FXMLLoader.load(getClass().getResource("Woods.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void goToWasteland(ActionEvent event) throws IOException {
        ActionEvent quizWastelandEvent;
        if (shouldStartWastelandQuiz()) {
            quizWastelandEvent = event;
            StartWastelandQuiz(event);
        } else {
            root = FXMLLoader.load(getClass().getResource("Wasteland.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
        private void initiateBattle (ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Battle.fxml"));
            root = loader.load();
            BattleController battleController = loader.getController();
            battleController.setGameController(this);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        private boolean shouldInitiateBattle () {
            double randomValue = Math.random();
            double battleProbability = 0.2;
            return randomValue < battleProbability;
        }

        public void goToSafariAfterBattle () throws IOException {
            root = FXMLLoader.load(getClass().getResource("Safari.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }

        private void StartWoodsQuiz (ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WoodsIntro.fxml"));
            root = loader.load();
            WoodsQuizController woodsQuizController = loader.getController();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            woodsQuizController.setGameController(this);
            stage.show();


        }
        private boolean shouldStartWoodsQuiz () {
            double randomValue = Math.random();
            double quizProbability = 0.5;
            return randomValue < quizProbability;
        }

        public void goToWoodsQuiz () throws IOException {
            root = FXMLLoader.load(getClass().getResource("QuizWoodsQuestions.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }

        public void goBackToWoods () throws IOException {
            root = FXMLLoader.load(getClass().getResource("Woods.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }


        private void StartWastelandQuiz (ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WastelandIntro.fxml"));
            root = loader.load();
            WastelandQuizController wastelandQuizController = loader.getController();
            wastelandQuizController.setGameController(this);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        private boolean shouldStartWastelandQuiz () {
            double randomValue = Math.random();
            double quizProbability = 0.5;
            return randomValue < quizProbability;
        }

        public void goToWastelandQuiz () throws IOException {
            root = FXMLLoader.load(getClass().getResource("QuizWasteland.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        public void goBackToWasteland () throws IOException {
            root = FXMLLoader.load(getClass().getResource("Wasteland.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
    }

    public void talkToOfficeNPC(ActionEvent actionEvent) {
        updateOfficeText();
    }
    public void talkToWoodsNPC(ActionEvent actionEvent) {
        updateWoodsText();
    }
    public void talkToSafariNPC(ActionEvent actionEvent) {
        updateSafariText();
    }
    public void talkToWastelandNPC(ActionEvent actionEvent) {
        updateWastelandText();
    }
    private void updateOfficeText() {
        switch (talkCounter) {
            case 1:
                textAreaOffice.clear();
                textAreaOffice.appendText("Hey, my name is Joe. I'm your personal assistant here at our Park.");
                break;
            case 2:
                textAreaOffice.clear();
                textAreaOffice.appendText("This room is our office. This is where you'll do your taxes and cry.");
                textAreaOffice.appendText("\nThis is also where you relax after doing your taxes.");
                break;
            case 3:
                textAreaOffice.clear();
                textAreaOffice.appendText("Your job is to make sure that our Park is doing well.");
                textAreaOffice.appendText("\nYou can do that by navigating the different rooms " +
                        "\nand talking to the workers.");
                textAreaOffice.appendText("\nSabrina stands for making sure the Safari is doing well. " +
                        "\nChuck makes sure the Woods are doing well.");
                break;
            case 4:
                textAreaOffice.clear();
                textAreaOffice.appendText("If you speak to them, you can learn more about different problems" +
                        "\nwe face with poaching, deforestation and environmental degradation.");
                textAreaOffice.appendText("\nThey will also quiz you on what you've learnt," +
                        "\nin order to make sure you have paid attention.");
                break;
        }
        talkCounter++;
    }
    private void updateWoodsText() {
        switch (talkCounter) {
            case 1:
                textAreaWoods.clear();
                textAreaWoods.appendText("Hi my name is chuck \nI will teach you about Deforestation and Degradation." +
                        "\nDeforestation is defined as the process where forested areas disappear" +
                        "\ndue to human activities such as logging, often to free up land for " +
                        "\nagriculture, mining, or other commercial purposes.");

                break;
            case 2:
                textAreaWoods.clear();
                textAreaWoods.appendText("Consequences of Deforestation: \n" +

                        "Deforestation is mentioned to have severe consequences for the \nenvironment,biodiversity, and the people living in those areas. \nAdditionally, it is pointed out that deforestation can also impact the \nclimate since trees absorb significant amounts of \nCO2 from the atmosphere.");
                break;
            case 3:
                textAreaWoods.clear();
                textAreaWoods.appendText("Legislation to Stop Deforestation: \n" +
                        "The European Parliament has approved a new law that halts the sale of \ncommodities such as palm oil, cocoa, coffee, soy, cattle, \nand timber in the EU if they originate from areas where there has been \ndeforestation or forest degradation since the beginning of 2021. \nThis also applies to products like shoes, furniture, and chocolate.");
                break;
            case 4:
                textAreaWoods.clear();
                textAreaWoods.appendText("Purpose of the Law: \n" +

                        "The purpose of the law is to protect forests globally, \nincluding the Amazon, Indonesia's rainforests, and European \nforest areas under significant pressure. \nIt aims to halt or minimize deforestation and forest degradation. \n" +
                        "\n" ) ;
                break;

            case 5:
                textAreaWoods.clear();
                textAreaWoods.appendText("Statistics on Forest Loss: " +
                        "\n" +
                        "According to the UN, more than 420 million hectares of forest \n disappeared between 1990 and 2020, equivalent to an area \nlarger than all EU countries combined. \nAnnually, an area the size of Portugal is lost. ");
                break;
            case 6:
                textAreaWoods.clear();
                textAreaWoods.appendText(" Effect on Consumer Habits: \n" +
                        "\n" +
                        "Consumers are encouraged to expect that the products they purchase \ndo not contribute to deforestation or forest degradation, \ntaking a step towards combating global deforestation. \n" +
                        "The article provides an overview of how deforestation \nimpacts the environment and human lives and how \nlegislation is attempting to address this issue. ");
                break;

            case 7 :
                textAreaWoods.clear();
                textAreaWoods.appendText(" and now about degradation  " ); //skriv mere
                break ;

            case 8 :
                textAreaWoods.clear();
                textAreaWoods.appendText(" I think its enough information now lets begin with the quiz  " );
                break ;

        }
        talkCounter++;
    }

    private void updateSafariText() {
        switch (talkCounter) {
            case 1:
                textAreaSafari.clear();
                textAreaSafari.appendText("Hey, my name is Sabrina.");
                textAreaSafari.appendText("This is where our animals thrive.");
                break;
            case 2:
                textAreaSafari.clear();
                textAreaSafari.appendText("Our job is to protect our animals against poachers.\n");
                textAreaSafari.appendText("and to keep our animals happy and healthy.");
                break;
            case 3:
                textAreaSafari.clear();
                textAreaSafari.appendText("If you ever encounter a poacher don't hesitate to attack!\n");
                textAreaSafari.appendText("They are pretty weak, but they just keep coming..\n");
                break;
            case 4:
                textAreaSafari.clear();
                textAreaSafari.appendText("I hope you are up for the job - we need a good Ranger!");
                break;
        }
        talkCounter++;
    }

    private void updateWastelandText() {
        switch (talkCounter) {
            case 1:
                textAreaWasteland.clear();
                textAreaWasteland.appendText("Hi again ");
                textAreaWasteland.appendText("Welcome to the saddest and most \n" +
                        "deadly place in our park. The wasteland...");
                break;
            case 2:
                textAreaWasteland.clear();
                textAreaWasteland.appendText("Those damn poachers!!! Do you know how often I experience this.\n" +
                        "It makes me so sad, my job is to keep the animals safe.\n" +
                        "But I feel like I'm failing them.  ");
                break;
            case 3:
                textAreaWasteland.clear();
                textAreaWasteland.appendText("It's just so sad. Do you know how bad poaching can be?");

                break;
            case 4:
                textAreaWasteland.clear();
                textAreaWasteland.appendText("It'll reduce the population of some animal species, and in some cases,\n" +
                        "some species of animals will be completely eradicated. \n" +
                        "Which in result, would be bad for our biodiversity as well.");

                break;
            case 5:
                textAreaWasteland.clear();
                textAreaWasteland.appendText("Biodiversity is the different forms of life found in one place,\n" +
                        "such as the variety of animals and plants, fungi and microorganisms.\n" +
                        " \nAnd biodiversity is important for our ecosystem,\n" +
                        "because it provides important human resources \nsuch as clean air, water, " +
                        "it provides the food we eat \nand it's just good for our climate in general. "
                );

                break;
            case 6:
                textAreaWasteland.clear();
                textAreaWasteland.appendText("Not taking care of biodiversity, will result into this dump,\n" +
                        "that we are in right now...\n" +
                        "look how sad and polluted this place is. No plants, no life... no nothing. \n" +
                        "That's why we need to find the people who are responsible, to stop this. \n" +
                        "I know that there´s a poacher walking around killing animals, \n" +
                        "and cutting trees. Make him stop, please.");
        }
        talkCounter++;
    }
}