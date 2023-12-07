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
    @FXML
    private TextArea textAreaOutside;
    @FXML
    private TextArea textAreaWasteland;

    private int talkCounter = 1;

    public void goToOutside() throws IOException {
        Main.stage.getScene().setRoot(new Region());
        Main.stage.setScene(Main.gameScene);
        Main.stage.show();
        Main.tl.play();
        talkCounter = 2;
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
    public void talkToOutsideNPC(ActionEvent actionEvent) {
        updateOutsideText();
    }
    private void updateOfficeText() {
        switch (talkCounter) {
            case 1:
                textAreaOffice.clear();
                textAreaOffice.appendText("Hey, welcome to our Office.");
                textAreaOffice.appendText("This is where you'll do your taxes and cry.");
                textAreaOffice.appendText("\nThis is also where you relax after doing your taxes.");
                break;
            case 2:
                textAreaOffice.clear();
                textAreaOffice.appendText("There's not much in this room right now.");
                textAreaOffice.appendText("\nBut if you want, you can stay and chill a bit.");
                textAreaOffice.appendText("\nDon't chill for too long, though.");
                textAreaOffice.appendText("\nSabrina might need your help with some Poachers.");
                break;

        }
        talkCounter++;
    }
    private void updateWoodsText() {
        switch (talkCounter) {
            case 1:
                textAreaWoods.clear();
                textAreaWoods.appendText("Hi my name is Chuck." +
                        "\nI will teach you about Deforestation and Environmental Degradation." +
                        "\nDeforestation is defined as the process where forested areas disappear" +
                        "\ndue to human activities such as logging, often to free up land for" +
                        "\nagriculture, mining, or other commercial purposes.");

                break;
            case 2:
                textAreaWoods.clear();
                textAreaWoods.appendText("Deforestation is mentioned to have severe consequences for the" +
                        "\nenvironment, biodiversity and the people living in those areas." +
                        "\nAdditionally, it is pointed out that deforestation can also impact the" +
                        "\nclimate since trees absorb significant amounts of " +
                        "\nCO2 from the atmosphere.");
                break;
            case 3:
                textAreaWoods.clear();
                textAreaWoods.appendText("The European Parliament has approved a law that halts the sale of" +
                        "\ncommodities such as palm oil, cocoa, coffee, soy, cattle," +
                        "\nand timber in the EU if they originate from areas where there has been" +
                        "\ndeforestation or forest degradation since the beginning of 2021." +
                        "\nThis also applies to products like shoes, furniture, and chocolate.");
                break;
            case 4:
                textAreaWoods.clear();
                textAreaWoods.appendText("It's illegal to cut trees at a large scale without a permit." +
                        "\nThe reason for that is to protect forests globally, " +
                        "\nincluding the Amazon, Indonesia's rainforests, and European" +
                        "\nforest areas under significant pressure." +
                        "\nIt aims to halt or minimize deforestation and forest degradation.");
                break;

            case 5:
                textAreaWoods.clear();
                textAreaWoods.appendText("According to the UN, more than 420 million hectares of forest " +
                        "\ndisappeared between 1990 and 2020, equivalent to an area" +
                        "\nlarger than all EU countries combined." +
                        "\nAnnually, an area the size of Portugal is lost." +
                        "\nThis is why we pay so much attention to it not happening at our Park.");
                break;
            case 6:
                textAreaWoods.clear();
                textAreaWoods.appendText("If you as a consumer wants to help, it is wise to buy products" +
                        "\nthat do not contribute to deforestation or forest degradation," +
                        "\ntaking a step towards combating global deforestation." +
                        "\nDeforestation impacts the environment and human lives in a lot of ways," +
                        "\nbut they're all bad.");
                break;

            case 7 :
                textAreaWoods.clear();
                textAreaWoods.appendText("All of the different problems, deforestation, poaching and biodiversity loss included" +
                        "\nare some of the causes of environmental degradation." +
                        "\nEnvironmental degradation is a huge problem globally, as it means the land that we live on slowly" +
                        "\nbecomes uninhabitable, for humans, animals and plants alike." +
                        "\nSoil becomes unusable for humans to grow crops, while the plants that keep the animals" +
                        "\nalive all slowly begin struggling to grow.");
                break ;

            case 8 :
                textAreaWoods.clear();
                textAreaWoods.appendText("Soil erosion is a big part of it. Erosion is caused by over-exploitation" +
                        "\nof the soil. It reduces the fertility of the soil. Combined with a potential increase of salinity" +
                        "\nit can end up affecting the ability for plants to absorb water and nutrients." +
                        "\nAll this leads to a circle in which plants can't grow, which means the soil doesn't get nutrients" +
                        "\nfrom all the dead plant matter. Which in turn makes it even worse." );
                break ;
            case 9 :
                textAreaWoods.clear();
                textAreaWoods.appendText("");
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
    private void updateOutsideText() {
        switch (talkCounter) {
            case 1:
                textAreaOutside.clear();
                textAreaOutside.appendText("Hey, my name is Joe. I'm your personal assistant here at our Park.");
                break;
            case 2:
                textAreaOutside.clear();
                textAreaOutside.appendText("This is the main hub of our Park. The Outside.");
                textAreaOutside.appendText("\nThis is connected to all the other parts of our Park.");
                break;
            case 3:
                textAreaOutside.clear();
                textAreaOutside.appendText("Your job is to make sure that our Park is doing well.");
                textAreaOutside.appendText("\nYou can do that by navigating the different rooms " +
                        "\nand talking to the workers.");
                textAreaOutside.appendText("\nSabrina stands for making sure the Safari is doing well." +
                        "\nChuck makes sure the Woods are doing well.");
                break;
            case 4:
                textAreaOutside.clear();
                textAreaOutside.appendText("If you speak to them, you can learn more about different problems" +
                        "\nwe face with poaching, deforestation and environmental degradation.");
                textAreaOutside.appendText("\nThey will also quiz you on what you've learnt," +
                        "\nin order to make sure you have paid attention.");
                break;
        }
        talkCounter++;
    }
}