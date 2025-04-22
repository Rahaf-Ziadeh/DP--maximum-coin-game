
package application;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import java.util.Collections;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver extends Application {
	//This method is for the interface of the game

	static int c = 0;
	int k = 0;
	private int b = 0;
	static int arr[];
	int[][] dp;
	static int player1 = 0;
	static int player2 = 0;
	static boolean p1 = true;
	static int p1Coins[];
	static int p2Coins[];
	int p1Index = 0; // Counter for Player 1's coins
	int p2Index = 0; // Counter for Player 2's coins

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMaximized(true);
		BorderPane pane = new BorderPane();

		String soundFilePath = "file:/C:/Users/hp%20elite%20840/Downloads/mouse-click-sound-233951.mp3";
		Media clickSound = new Media(soundFilePath);

		MediaPlayer mediaPlayer = new MediaPlayer(clickSound);
		;
		Button btBack = new Button("");
		Image imageBack = new Image("file:/C:/Users/hp elite 840/Downloads/back.png");
		ImageView imageBackView = new ImageView(imageBack);
		imageBackView.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
		imageBackView.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.1));
		btBack.setStyle("-fx-background-color: transparent;");
		btBack.setGraphic(imageBackView);
		btBack.setAlignment(Pos.CENTER);
		Label lbChooseWay = new Label("Choose how to get coins values");
		lbChooseWay.setFont(Font.font("Comic Sans MS", 30));
		Button btRandom = new Button();
		Button btManually = new Button();
		Button btFile = new Button();

		HBox hbChoose = new HBox();
		hbChoose.getChildren().addAll(btRandom, btManually, btFile);
		hbChoose.setAlignment(Pos.CENTER);

		Button btInfo = new Button();

		Label lbMode = new Label("");
		lbMode.setFont(Font.font("Comic Sans MS", 30));
		Button btOne = new Button();
		Button btTwo = new Button();

		Image imagePl1 = new Image("file:/C:/Users/hp elite 840/Downloads/oneP (2).png");
		ImageView imagePl1View = new ImageView(imagePl1);
		imagePl1View.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
		imagePl1View.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.1));
		btOne.setStyle("-fx-background-color: transparent;");
		btOne.setGraphic(imagePl1View);

		Image imagePl2 = new Image("file:/C:/Users/hp elite 840/Downloads/twoP (1).png");
		ImageView imagePl2View = new ImageView(imagePl2);
		imagePl2View.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
		imagePl2View.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.1));
		btTwo.setStyle("-fx-background-color: transparent;");
		btTwo.setGraphic(imagePl2View);

		HBox hbmode = new HBox(20);
		// hbmode.getChildren().addAll(btOne, btTwo);

		VBox vMode = new VBox(10);
		vMode.getChildren().addAll(lbMode, hbmode);
		hbmode.setAlignment(Pos.CENTER);
		vMode.setAlignment(Pos.CENTER);

		Image Random = new Image("file:/C:/Users/hp elite 840/Downloads/file.png");
		ImageView buttonImageView1 = new ImageView(Random);
		buttonImageView1.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
		buttonImageView1.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
		btRandom.setGraphic(buttonImageView1);
		btRandom.setStyle("-fx-background-color: transparent;");

		Image manual = new Image("file:/C:/Users/hp elite 840/Downloads/manual.png");
		ImageView buttonImageView2 = new ImageView(manual);
		buttonImageView2.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
		buttonImageView2.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
		btManually.setGraphic(buttonImageView2);
		btManually.setStyle("-fx-background-color: transparent;");

		Image file = new Image("file:/C:/Users/hp elite 840/Downloads/random.png");
		ImageView buttonImageView3 = new ImageView(file);
		buttonImageView3.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
		buttonImageView3.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
		btFile.setGraphic(buttonImageView3);
		btFile.setStyle("-fx-background-color: transparent;");

		VBox layout = new VBox(10);

		btOne.setOnAction(ef -> {
			StackPane stackPane = new StackPane();
			mediaPlayer.stop();
			mediaPlayer.play();

			optAns(arr, dp);

			Label playerO = new Label("player one: " + player1);
			Label playerT = new Label("player two: " + player2 + "");
			Label lbResult = new Label("Result");
			Label lbWinner = new Label("");
			Label lbp1Result = new Label("first player coins: ");
			Label lbp2Result = new Label("second player coins: ");

			lbp1Result.setFont(Font.font("Comic Sans MS", 30));
			lbp2Result.setFont(Font.font("Comic Sans MS", 30));
			playerO.setFont(Font.font("Comic Sans MS", 30));
			playerT.setFont(Font.font("Comic Sans MS", 30));
			lbWinner.setFont(Font.font("Comic Sans MS", 30));
			lbResult.setFont(Font.font("Comic Sans MS", 30));
			playerO.setStyle("-fx-text-fill: OLDLACE;");
			playerT.setStyle("-fx-text-fill: OLDLACE;");
			lbWinner.setStyle("-fx-text-fill: GOLDENROD;");
			lbResult.setStyle("-fx-text-fill: GOLDENROD;");
			lbp1Result.setStyle("-fx-text-fill: GOLDENROD;");
			lbp2Result.setStyle("-fx-text-fill: GOLDENROD;");

			HBox hb1 = new HBox(30);
			HBox hb2 = new HBox(30);
			hb1.getChildren().add(lbp1Result);
			hb2.getChildren().add(lbp2Result);
			lbp1Result.setAlignment(Pos.CENTER);
			lbp2Result.setAlignment(Pos.CENTER);
			hb1.setAlignment(Pos.CENTER);
			hb2.setAlignment(Pos.CENTER);

			for (int i = 0; i < p1Coins.length / 2; i++) {
				Image Next = new Image("file:/C:/Users/hp elite 840/Downloads/dollar.png");
				ImageView buttonImageView4 = new ImageView(Next);
				buttonImageView4.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
				buttonImageView4.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
				Button btCoin = new Button();

				btCoin.setGraphic(buttonImageView4);
				btCoin.setStyle("-fx-background-color: transparent;");
				Label lbCoin = new Label(String.valueOf(p1Coins[i]));
				lbCoin.setFont(Font.font("Comic Sans MS", 30));
				lbCoin.setStyle("-fx-text-fill: GOLDENROD;");
				VBox vbCoin = new VBox(btCoin, lbCoin);
				vbCoin.setAlignment(Pos.CENTER);
				hb1.getChildren().add(vbCoin);

			}

			for (int i = 0; i < p2Coins.length / 2; i++) {
				Image Next = new Image("file:/C:/Users/hp elite 840/Downloads/dollar.png");
				ImageView buttonImageView4 = new ImageView(Next);
				buttonImageView4.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
				buttonImageView4.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
				Button btCoin = new Button();

				btCoin.setGraphic(buttonImageView4);
				btCoin.setStyle("-fx-background-color: transparent;");
				Label lbCoin = new Label(String.valueOf(p2Coins[i]));
				lbCoin.setFont(Font.font("Comic Sans MS", 30));
				lbCoin.setStyle("-fx-text-fill: GOLDENROD;");
				VBox vbCoin = new VBox(btCoin, lbCoin);
				vbCoin.setAlignment(Pos.CENTER);
				hb2.getChildren().add(vbCoin);

			}

			if (player1 > player2) {
				lbWinner.setText("Player One is the WINNER!!");
			} else if (player2 > player1) {
				lbWinner.setText("Player Two is the WINNER!!");
			} else if (player1 == player2) {
				lbWinner.setText("Player Two is the WINNER!!");
			}
			HBox hbWinner = new HBox();
			hbWinner.getChildren().addAll(lbWinner);
			hbWinner.setAlignment(Pos.CENTER);

			HBox hbResult = new HBox(20);
			hbResult.getChildren().addAll(playerO, lbResult, playerT);
			hbResult.setAlignment(Pos.CENTER);

			Button btDp = new Button("");
			Image imageDp = new Image("file:/C:/Users/hp elite 840/Downloads/DPbtn.png");
			ImageView imageDPView = new ImageView(imageDp);
			imageDPView.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
			imageDPView.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.1));
			btDp.setStyle("-fx-background-color: transparent;");
			btDp.setGraphic(imageDPView);
			HBox hbDp = new HBox();
			hbDp.getChildren().addAll(btDp);
			hbDp.setAlignment(Pos.CENTER);

			btDp.setOnAction(e2 -> {
				Stage tableStage = new Stage();
				tableStage.setTitle("Table Display");

				// Use a TextArea to display the table in a simple format
				TextArea dpValues = new TextArea();
				dpValues.setEditable(false); // Make it read-only
				dpValues.setFont(Font.font("Comic Sans MS", 30));
				dpValues.setStyle("-fx-text-fill: OLDLACE;" + // Text color
						"-fx-control-inner-background: MIDNIGHTBLUE;" // Background inside TextArea
				);

				// Build the table content as a string
				StringBuilder tableContent = new StringBuilder();
				for (int i = 0; i < dp.length; i++) {
					for (int j = 0; j < dp[i].length; j++) {
						tableContent.append(dp[i][j]).append("\t");
					}
					tableContent.append("\n");
				}
				dpValues.setText(tableContent.toString());

				// Add the TextArea to the scene
				VBox tableRoot = new VBox(dpValues);
				tableRoot.setAlignment(Pos.CENTER); // Align the TextArea in the center
				tableRoot.setStyle("-fx-background-color: MIDNIGHTBLUE;");
				// VBox.setVgrow(dpValues, Priority.ALWAYS); // Allow the TextArea to grow
				// dynamically

				Scene tableScene = new Scene(tableRoot, 600, 400);
				tableScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				// Adjust TextArea size dynamically to fit the window
				dpValues.prefWidthProperty().bind(tableScene.widthProperty().multiply(0.8));
				dpValues.prefHeightProperty().bind(tableScene.heightProperty().multiply(0.8));

				tableStage.setScene(tableScene);
				tableStage.setMaximized(true); // Maximize the stage for full screen
				tableStage.show();
			});

			btDp.setAlignment(Pos.CENTER);

			VBox vbResult = new VBox(20);

			Separator separator = new Separator();
			Separator separator2 = new Separator();
			separator.prefWidthProperty().bind(vbResult.widthProperty());
			separator2.prefWidthProperty().bind(vbResult.widthProperty());
			btBack.setAlignment(Pos.CENTER);
			vbResult.getChildren().addAll(hbWinner, separator, hbResult, separator2, hbDp, hb1, hb2, btBack);
			vbResult.setAlignment(Pos.CENTER);
			StackPane sPane = new StackPane(vbResult);
			sPane.setStyle("-fx-background-color: 	MIDNIGHTBLUE;");
			Scene result = new Scene(sPane, primaryStage.getWidth(), primaryStage.getHeight());
			result.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(result);
			primaryStage.show();

		});

		btTwo.setOnAction(e3 -> {

			VBox vbBoth = new VBox(30);
			vbBoth.setAlignment(Pos.CENTER);
			Label lbName1 = new Label("Enter First Player Name");
			TextField tfName1 = new TextField();
			HBox hbOne = new HBox();
			hbOne.getChildren().add(tfName1);
			hbOne.setAlignment(Pos.CENTER);
			String name1 = tfName1.getText();
			Label lbName2 = new Label("Enter Second Player Name");
			TextField tfName2 = new TextField();

			HBox hbTwo = new HBox();
			hbTwo.getChildren().add(tfName2);
			hbTwo.setAlignment(Pos.CENTER);
			String name2 = tfName2.getText();
			Label lbMsg = new Label();
			VBox vbNames = new VBox(20);
			vbNames.setStyle("-fx-background-color: 	MIDNIGHTBLUE;");
			vbNames.setAlignment(Pos.CENTER);
			lbName1.setFont(Font.font("Comic Sans MS", 30));
			lbName1.setStyle("-fx-text-fill: OLDLACE;");
			lbName2.setFont(Font.font("Comic Sans MS", 30));
			lbName2.setStyle("-fx-text-fill: OLDLACE;");
			lbMsg.setFont(Font.font("Comic Sans MS", 30));
			lbMsg.setStyle("-fx-text-fill: OLDLACE;");
			Button btStart = new Button("");

			vbNames.getChildren().addAll(lbName1, hbOne, lbName2, hbTwo, lbMsg, btStart);
			Scene sceneFirst = new Scene(vbNames, primaryStage.getWidth(), primaryStage.getHeight());
			sceneFirst.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneFirst);
			primaryStage.setMaximized(true);
			primaryStage.show();
			Image buttonImage = new Image("file:/C:/Users/hp elite 840/Downloads/startbtn (1).png");
			ImageView buttonImageView = new ImageView(buttonImage);
			buttonImageView.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.15));
			buttonImageView.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.11));
			btStart.setStyle("-fx-background-color: transparent;");
			btStart.setGraphic(buttonImageView);
			btStart.setOnAction(e -> {
				if (tfName1.getText().isEmpty()) {
					lbMsg.setText("enter player one Name");

				}
				if (tfName2.getText().isEmpty()) {
					lbMsg.setText("enter player Two Name");

				} else {

					Label lbTurn = new Label();
					lbTurn.setFont(Font.font("Comic Sans MS", 30));
					lbTurn.setStyle("-fx-text-fill: OLDLACE;");

					VBox[] vbCoins = new VBox[arr.length];
					p1Coins = new int[arr.length];
					p2Coins = new int[arr.length];

					Label lbP1 = new Label("Player1 choices: ");
					Label lbP2 = new Label("Player2 choices: ");
					lbP1.setFont(Font.font("Comic Sans MS", 30));
					lbP1.setStyle("-fx-text-fill: OLDLACE;");
					lbP2.setFont(Font.font("Comic Sans MS", 30));
					lbP2.setStyle("-fx-text-fill: OLDLACE;");
					HBox hb1 = new HBox(10);
					HBox hb2 = new HBox(10);
					VBox vbResult = new VBox(10);
					hb1.getChildren().add(lbP1);
					hb2.getChildren().add(lbP2);
					hb1.setAlignment(Pos.CENTER);
					hb2.setAlignment(Pos.CENTER);

					k = arr.length - 1;
					p1Coins = new int[arr.length / 2];
					p2Coins = new int[arr.length / 2];

					vbBoth.setAlignment(Pos.CENTER);

					// Turn label

					lbTurn.setFont(Font.font("Comic Sans MS", 30));
					lbTurn.setStyle("-fx-text-fill: OLDLACE;");

					// HBox for coins display
					HBox hbCoin = new HBox(10);
					hbCoin.setAlignment(Pos.CENTER);

					// Display the current coin values
					for (int value : arr) {
						Label lbCoin = new Label(String.valueOf(value));
						lbCoin.setFont(Font.font("Comic Sans MS", 30));
						lbCoin.setStyle("-fx-text-fill: GOLDENROD;");
						hbCoin.getChildren().add(lbCoin);
					}

					// Buttons for "First" and "Last"
					Button btFirst = new Button("First");
					Button btLast = new Button("Last");

					// Action for the "First" button
					// Define global labels to show player choices
					Label lbP1Choices = new Label("Player 1 choices: ");
					Label lbP2Choices = new Label("Player 2 choices: ");

					// Configure label styles
					lbP1Choices.setFont(Font.font("Comic Sans MS", 30));
					lbP1Choices.setStyle("-fx-text-fill: OLDLACE;");
					lbP2Choices.setFont(Font.font("Comic Sans MS", 30));
					lbP2Choices.setStyle("-fx-text-fill: OLDLACE;");

					if (p1) {
						lbTurn.setText("Player 1's Turn");
					} else {
						lbTurn.setText("Player 2's Turn");
					}
					btFirst.setOnAction(event -> {
						if (arr.length > 0) {
							// Update Player 1 or Player 2's coins
							if (p1) {
								p1Coins[p1Index++] = arr[0]; // Add the first element to Player 1's coins
								player1 += arr[0];
								// Update Player 1 choices label
								StringBuilder p1Choices = new StringBuilder("Player 1 choices: ");
								for (int i = 0; i < p1Index; i++) {
									p1Choices.append(p1Coins[i]).append(" ");
								}
								lbP1Choices.setText(p1Choices.toString());
							} else {
								p2Coins[p2Index++] = arr[0]; // Add the first element to Player 2's coins
								player2 += arr[0];
								// Update Player 2 choices label
								StringBuilder p2Choices = new StringBuilder("Player 2 choices: ");
								for (int i = 0; i < p2Index; i++) {
									p2Choices.append(p2Coins[i]).append(" ");
								}
								lbP2Choices.setText(p2Choices.toString());
							}

							// Remove the first element from arr
							arr = Arrays.copyOfRange(arr, 1, arr.length);
							hbCoin.getChildren().remove(0);
							// Switch the turn
							p1 = !p1; // Toggle between Player 1 and Player 2
							if (p1) {
								lbTurn.setText("Player 1's Turn");
							} else {
								lbTurn.setText("Player 2's Turn");
							}
						}
						if (arr.length <= 0) {
							System.out.println("yess");
							Label lbWinner = new Label();
							Label lbDone = new Label("Done");
							vbBoth.getChildren().add(lbDone);
							lbWinner.setFont(Font.font("Comic Sans MS", 30));
							lbWinner.setStyle("-fx-text-fill: GOLDENROD;");
							lbDone.setFont(Font.font("Comic Sans MS", 30));
							lbDone.setStyle("-fx-text-fill: OLDLACE;");
							if (player1 > player2) {
								lbWinner.setText("Player One is the WINNER!!");
							} else if (player2 > player1) {
								lbWinner.setText("Player Two is the WINNER!!");
							} else if (player1 == player2) {
								lbWinner.setText("Player Two is the WINNER!!");
							}
							Label playerO = new Label("player one: " + player1);
							Label playerT = new Label("player two: " + player2 + "");
							playerO.setFont(Font.font("Comic Sans MS", 30));
							playerO.setStyle("-fx-text-fill: OLDLACE;");
							playerT.setFont(Font.font("Comic Sans MS", 30));
							playerT.setStyle("-fx-text-fill: OLDLACE;");
							vbResult.getChildren().addAll(lbDone, lbWinner, playerO, playerT);
							vbResult.setAlignment(Pos.CENTER);
							btFirst.setVisible(false);
							btLast.setVisible(false);
							lbP1Choices.setVisible(false);
							lbP2Choices.setVisible(false);
							lbTurn.setVisible(false);

						}
					});

					btLast.setOnAction(event -> {
						if (arr.length > 0) {
							// Update Player 1 or Player 2's coins
							if (p1) {
								p1Coins[p1Index++] = arr[arr.length - 1]; // Add the last element to Player 1's coins
								player1 += arr[0];
								// Update Player 1 choices label
								StringBuilder p1Choices = new StringBuilder("Player 1 choices: ");
								for (int i = 0; i < p1Index; i++) {
									p1Choices.append(p1Coins[i]).append(" ");
								}
								lbP1Choices.setText(p1Choices.toString());
							} else {
								p2Coins[p2Index++] = arr[arr.length - 1]; // Add the last element to Player 2's coins
								player2 += arr[0];
								// Update Player 2 choices label
								StringBuilder p2Choices = new StringBuilder("Player 2 choices: ");
								for (int i = 0; i < p2Index; i++) {
									p2Choices.append(p2Coins[i]).append(" ");
								}
								lbP2Choices.setText(p2Choices.toString());
							}

							// Remove the last element from arr
							arr = Arrays.copyOfRange(arr, 0, arr.length - 1);
							hbCoin.getChildren().remove(hbCoin.getChildren().size() - 1);
							// Switch the turn
							p1 = !p1; // Toggle between Player 1 and Player 2
							if (p1) {
								lbTurn.setText("Player 1's Turn");
							} else {
								lbTurn.setText("Player 2's Turn");
							}
						}
						if (arr.length <= 0) {
							System.out.println("yess");
							Label lbWinner = new Label();
							Label lbDone = new Label("Done");
							vbBoth.getChildren().add(lbDone);
							lbWinner.setFont(Font.font("Comic Sans MS", 30));
							lbWinner.setStyle("-fx-text-fill: GOLDENROD;");
							lbDone.setFont(Font.font("Comic Sans MS", 30));
							lbDone.setStyle("-fx-text-fill: OLDLACE;");
							if (player1 > player2) {
								lbWinner.setText("Player One is the WINNER!!");
							} else if (player2 > player1) {
								lbWinner.setText("Player Two is the WINNER!!");
							} else if (player1 == player2) {
								lbWinner.setText("Player Two is the WINNER!!");
							}
							Label playerO = new Label("player one: " + player1);
							Label playerT = new Label("player two: " + player2 + "");
							playerO.setFont(Font.font("Comic Sans MS", 30));
							playerO.setStyle("-fx-text-fill: OLDLACE;");
							playerT.setFont(Font.font("Comic Sans MS", 30));
							playerT.setStyle("-fx-text-fill: OLDLACE;");
							vbResult.getChildren().addAll(lbDone, lbWinner, playerO, playerT);
							vbResult.setAlignment(Pos.CENTER);
							btFirst.setVisible(false);
							btLast.setVisible(false);
							lbP1Choices.setVisible(false);
							lbP2Choices.setVisible(false);
							lbTurn.setVisible(false);

						}
					});
					VBox vbReqsult = new VBox(10);
					vbReqsult.getChildren().addAll(lbP1Choices, lbP2Choices);
					vbReqsult.setAlignment(Pos.CENTER);

					// Add everything to the VBox
					HBox hbButtons = new HBox(20, btFirst, btLast);
					hbButtons.setAlignment(Pos.CENTER);
					btBack.setAlignment(Pos.CENTER);
					vbBoth.getChildren().addAll(lbTurn, hbCoin, hbButtons, vbReqsult, vbResult, btBack);
					vbBoth.setStyle("-fx-background-color: MIDNIGHTBLUE;");
					Scene scene4 = new Scene(vbBoth, primaryStage.getWidth(), primaryStage.getHeight());
					scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene4);
					primaryStage.setMaximized(true);
					primaryStage.show();

				}

			});
		});

		Image bgImage = new Image("file:/C:/Users/hp elite 840/Downloads/backGr.png");
		ImageView bgImageView = new ImageView(bgImage);

		// bgImageView.setPreserveRatio(false);
		StackPane spane = new StackPane(bgImageView);
		// Choose layout as needed
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(lbChooseWay, hbChoose, vMode);
		spane.getChildren().add(layout);
//		int i = 0;
//		int j = arr.length - 1;
//		int[][] dp = new int[arr.length][arr.length];
//		System.out.println(optAns(arr, dp));
//		System.out.println("DP Table:");
//		//printDP(dp);
		Scene scene = new Scene(spane, primaryStage.getWidth(), primaryStage.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		bgImageView.fitWidthProperty().bind(scene.widthProperty());
		bgImageView.fitHeightProperty().bind(scene.heightProperty());

		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();

		btFile.setOnAction(e -> {
			Image Next = new Image("file:/C:/Users/hp elite 840/Downloads/Nextbtn.png");
			ImageView buttonImageView4 = new ImageView(Next);
			buttonImageView4.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.09));
			buttonImageView4.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
			Button btNext = new Button();
			btNext.setGraphic(buttonImageView4);
			btNext.setStyle("-fx-background-color: transparent;");
			btNext.setDisable(true);
			Label lbText = new Label("Choose group");
			lbText.setFont(Font.font("Comic Sans MS", 30));
			lbText.setStyle("-fx-text-fill: OLDLACE;");
			lbText.setAlignment(Pos.CENTER);

			Label lbResult = new Label();
			lbResult.setFont(Font.font("Comic Sans MS", 30));
			lbResult.setStyle("-fx-text-fill: OLDLACE;");
			lbResult.setAlignment(Pos.CENTER);

			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new File("C:\\Users\\hp elite 840\\Documents\\Algo"));
			fileChooser.setTitle("Open Coin File");
			VBox vbGroup = new VBox(10);

			vbGroup.setAlignment(Pos.CENTER);
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			if (selectedFile != null) {
				try (Scanner scanner = new Scanner(selectedFile)) {
					int j = 0;
					while (scanner.hasNextLine()) {
						j++;
						String line = scanner.nextLine();
						System.out.println(line);
						String[] tokens = line.split("\\s+");
						String values = "";
						for (int f = 1; f < tokens.length; f++) {
							values += tokens[f] + " ";
						}
						int numCoins = Integer.parseInt(tokens[0]);
						int[] coins = new int[numCoins];
						for (int i = 0; i < numCoins; i++) {
							coins[i] = Integer.parseInt(tokens[i + 1]);
						}
						HBox hbV = new HBox(10);
						hbV.setAlignment(Pos.CENTER);
						Label lbValues = new Label("cat." + j + ": size= " + tokens[0] + " Values: " + values);

						lbValues.setFont(Font.font("Comic Sans MS", 30));
						lbValues.setStyle("-fx-text-fill: GOLDENROD;");
						Button btChoose = new Button("");
						Image imageChoose = new Image("file:/C:/Users/hp elite 840/Downloads/choose.png");
						ImageView imageChooseView = new ImageView(imageChoose);
						imageChooseView.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.09));
						imageChooseView.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
						btChoose.setStyle("-fx-background-color: transparent;");
						btChoose.setGraphic(imageChooseView);
						hbV.getChildren().addAll(lbValues, btChoose);
						vbGroup.getChildren().add(hbV);
						int c = j;
						btChoose.setOnAction(e5 -> {
							arr = new int[Integer.parseInt(tokens[0])];
							arr = coins;
							String result = "Number of coins: " + arr.length + "\nCoin values: ";
							for (int i = 0; i < arr.length; i++) {
								result += arr[i] + " ";
								btNext.setDisable(false);
							}
							System.out.println(result + "hereeeeee");
							lbResult.setText("cat. " + c + " is Chosen");
							btNext.setDisable(false);
						});

					}

				} catch (FileNotFoundException e2) {
					lbResult.setText("File not found: " + selectedFile.getPath());
				} catch (IllegalArgumentException e3) {
					lbResult.setText(e3.getMessage());
				}
			}

			btNext.setOnAction(e1 -> {

				btRandom.setDisable(true);
				btManually.setDisable(true);
				btFile.setDisable(true);

				lbMode.setText("Choose MODE");
				hbmode.getChildren().addAll(btOne, btTwo);
				dp = new int[arr.length][arr.length];
				primaryStage.setMaximized(true);
				primaryStage.setScene(scene);
				primaryStage.show();
			});
			VBox vF = new VBox(20);
			vF.setStyle("-fx-background-color: 	MIDNIGHTBLUE;");
			vF.setAlignment(Pos.CENTER);
			lbResult.setAlignment(Pos.CENTER);
			btNext.setAlignment(Pos.CENTER);
			vF.getChildren().addAll(lbText, vbGroup, lbResult, btNext);
			vF.setAlignment(Pos.CENTER);
			Scene sceneF = new Scene(vF, primaryStage.getWidth(), primaryStage.getHeight());
			sceneF.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setMaximized(true);
			primaryStage.setScene(sceneF);
			primaryStage.show();

		});

		btManually.setOnAction(e -> {

			StackPane spane2 = new StackPane();

			mediaPlayer.stop();
			mediaPlayer.play();

			Label lbNumber = new Label("enter the number of coins");
			lbNumber.setFont(Font.font("Comic Sans MS", 30));
			lbNumber.setStyle("-fx-text-fill: OLDLACE;");

			Label lbEnter = new Label("enter the coin value");
			lbEnter.setFont(Font.font("Comic Sans MS", 30));
			lbEnter.setStyle("-fx-text-fill: OLDLACE;");

			Label lbIn = new Label();
			lbIn.setFont(Font.font("Comic Sans MS", 30));
			lbIn.setStyle("-fx-text-fill: GOLDENROD;");

			TextField tfEnter = new TextField();
			TextField tfNumber = new TextField();
			tfEnter.setPrefWidth(200);
			HBox hbox = new HBox();
			hbox.getChildren().addAll(tfEnter);
			hbox.setAlignment(Pos.CENTER);
			Label lbMsg = new Label();
			lbMsg.setFont(Font.font("Comic Sans MS", 30));
			lbMsg.setStyle("-fx-text-fill: GOLDENROD;");

			HBox hbox1 = new HBox(tfNumber);
			hbox1.setAlignment(Pos.CENTER);

			Button btSelect = new Button();
			Button btAdd = new Button();
			Button btDone = new Button();

			Image Next = new Image("file:/C:/Users/hp elite 840/Downloads/Nextbtn.png");
			ImageView buttonImageView4 = new ImageView(Next);
			buttonImageView4.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
			buttonImageView4.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
			btSelect.setGraphic(buttonImageView4);
			btSelect.setStyle("-fx-background-color: transparent;");

			Image add = new Image("file:/C:/Users/hp elite 840/Downloads/addbtn.png");
			ImageView buttonImageView5 = new ImageView(add);
			buttonImageView5.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
			buttonImageView5.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
			btAdd.setGraphic(buttonImageView5);
			btAdd.setStyle("-fx-background-color: transparent;");

			Image done = new Image("file:/C:/Users/hp elite 840/Downloads/Donebtn.png");
			ImageView buttonImageView6 = new ImageView(done);
			buttonImageView6.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
			buttonImageView6.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
			btDone.setGraphic(buttonImageView6);
			btDone.setStyle("-fx-background-color: transparent;");

			lbIn.setAlignment(Pos.CENTER);
			lbMsg.setAlignment(Pos.CENTER);

			VBox vbAddMan = new VBox(20);
			vbAddMan.setAlignment(Pos.CENTER);
			vbAddMan.getChildren().addAll(lbNumber, hbox1, lbMsg, btSelect, lbEnter, hbox, lbIn, btAdd, btDone);
			tfEnter.setDisable(true);
			btAdd.setDisable(true);
			spane2.getChildren().addAll(vbAddMan);
			spane2.setStyle("-fx-background-color: 	MIDNIGHTBLUE;");
			Scene newScene = new Scene(spane2, primaryStage.getWidth(), primaryStage.getHeight());
			// Stage newStage = new Stage();
			newScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setMaximized(true);
			primaryStage.setScene(newScene);
			primaryStage.show();

			btDone.setDisable(true);

			btSelect.setOnAction(e0 -> {
				mediaPlayer.stop();
				mediaPlayer.play();

				try {
					int number = Integer.parseInt(tfNumber.getText());

					lbMsg.setText("Input is a valid number: " + number);

					arr = new int[Integer.parseInt(tfNumber.getText())];
					tfEnter.setDisable(false);
					btAdd.setDisable(false);

				} catch (NumberFormatException err) {
					lbMsg.setText("Input is not a valid number");

				}
				if (Integer.parseInt(tfNumber.getText()) % 2 != 0) {
					lbMsg.setText("number of coins must be even");
					tfEnter.setDisable(true);
					btAdd.setDisable(true);
				}
				if (tfNumber.getText().equals(null) || tfNumber.getText().equals("")) {
					lbMsg.setText("add number of coins");
					tfEnter.setDisable(true);
					btAdd.setDisable(true);

				}
				if (Integer.parseInt(tfNumber.getText()) < 2) {
					lbMsg.setText("number of coins must be 2 or larger");
					tfEnter.setDisable(true);
					btAdd.setDisable(true);

				}

			});

			btAdd.setOnAction(e1 -> {

				mediaPlayer.stop();
				mediaPlayer.play();
				lbIn.setText(lbIn.getText() + " " + tfEnter.getText());

				if (c < arr.length) {

					arr[c] = Integer.parseInt(tfEnter.getText());
					System.out.println("c=" + c + "arr=" + arr.length);
					c++;
					if (c == arr.length) {
						tfEnter.setText("Completed!");
						tfEnter.setText("Completed!");
						tfEnter.setDisable(true);
						btAdd.setDisable(true);
						btDone.setDisable(false);
					} else
						tfEnter.setText("");
				} else if (c == arr.length) {

					tfEnter.setText("Completed!");
					tfEnter.setDisable(true);
					btAdd.setDisable(true);
					btDone.setDisable(false);
				}
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}

			});

			btDone.setOnAction(e2 -> {
				mediaPlayer.stop();
				mediaPlayer.play();

				btRandom.setDisable(true);
				btManually.setDisable(true);
				btFile.setDisable(true);

				lbMode.setText("Choose MODE");
				hbmode.getChildren().addAll(btOne, btTwo);
				dp = new int[arr.length][arr.length];
				primaryStage.setMaximized(true);
				primaryStage.setScene(scene);
				primaryStage.show();

			});

		});

		btRandom.setOnAction(d ->

		{
			mediaPlayer.stop();
			mediaPlayer.play();

			Label lbNumber = new Label("enter the number of coins");
			lbNumber.setFont(Font.font("Comic Sans MS", 30));
			lbNumber.setStyle("-fx-text-fill: OLDLACE;");
			TextField tfNumber = new TextField();

			Label lbMin = new Label("Min Value:");
			lbMin.setFont(Font.font("Comic Sans MS", 30));
			lbMin.setStyle("-fx-text-fill: OLDLACE;");
			TextField tfMin = new TextField();

			Label lbMax = new Label("Max Value:");
			lbMax.setFont(Font.font("Comic Sans MS", 30));
			lbMax.setStyle("-fx-text-fill: OLDLACE;");
			TextField tfMax = new TextField();

			Label lbWarning1 = new Label();
			lbWarning1.setFont(Font.font("Comic Sans MS", 30));
			lbWarning1.setStyle("-fx-text-fill: GOLDENROD;");

			Label lbResult = new Label();
			lbResult.setFont(Font.font("Comic Sans MS", 30));
			lbResult.setStyle("-fx-text-fill: GOLDENROD;");

			HBox hb = new HBox(tfNumber, lbWarning1);
			HBox hb1 = new HBox(tfMin);
			HBox hb2 = new HBox(tfMax);

			Button generateButton = new Button("Generate Coins");

			Image Next = new Image("file:/C:/Users/hp elite 840/Downloads/Nextbtn.png");
			ImageView buttonImageView4 = new ImageView(Next);
			buttonImageView4.fitWidthProperty().bind(primaryStage.widthProperty().multiply(0.1));
			buttonImageView4.fitHeightProperty().bind(primaryStage.heightProperty().multiply(0.09));
			Button btNext = new Button();
			btNext.setGraphic(buttonImageView4);
			btNext.setStyle("-fx-background-color: transparent;");
			btNext.setDisable(true);

			generateButton.setOnAction(event -> {
				try {

					mediaPlayer.stop();
					mediaPlayer.play();
					int min = Integer.parseInt(tfMin.getText());
					int max = Integer.parseInt(tfMax.getText());
					Random random = new Random();

					int numCoins = Integer.parseInt(tfNumber.getText());

					// rangeStage.close(); // Close the range window

					int number = Integer.parseInt(tfNumber.getText());

					lbWarning1.setText("Input is a valid number: " + number);

					arr = new int[Integer.parseInt(tfNumber.getText())];
					for (int i = 0; i < numCoins; i++) {
						arr[i] = random.nextInt(max - min + 1) + min;
					}

					lbResult.setText("Generated Coins: " + Arrays.toString(arr));
					btNext.setDisable(false);

				} catch (NumberFormatException err) {
					lbWarning1.setText("Input is not a valid number");
					lbResult.setText("enter another valid number");
					btNext.setDisable(true);

				}
				if (Integer.parseInt(tfNumber.getText()) % 2 != 0) {
					lbWarning1.setText("number of coins must be even");
					lbResult.setText("enter an even number");
					btNext.setDisable(true);

				}
				if (tfNumber.getText().equals(null) || tfNumber.getText().equals("")) {
					lbWarning1.setText("");
					lbResult.setText("add number of coins");
					btNext.setDisable(true);

				}
				if (Integer.parseInt(tfNumber.getText()) < 2) {
					lbWarning1.setText("number of coins must be 2 or larger");
					lbResult.setText("enter another number");
					btNext.setDisable(true);

				}

			});

			btNext.setOnAction(e1 -> {

				btRandom.setDisable(true);
				btManually.setDisable(true);
				btFile.setDisable(true);

				lbMode.setText("Choose MODE");
				hbmode.getChildren().addAll(btOne, btTwo);
				dp = new int[arr.length][arr.length];
				primaryStage.setMaximized(true);
				primaryStage.setScene(scene);
				primaryStage.show();
			});

			lbNumber.setAlignment(Pos.CENTER);
			hb.setAlignment(Pos.CENTER);
			lbMax.setAlignment(Pos.CENTER);
			lbMin.setAlignment(Pos.CENTER);
			hb1.setAlignment(Pos.CENTER);
			hb2.setAlignment(Pos.CENTER);
			generateButton.setAlignment(Pos.CENTER);
			tfMin.setAlignment(Pos.CENTER);
			tfNumber.setAlignment(Pos.CENTER);
			tfMax.setAlignment(Pos.CENTER);
			lbResult.setAlignment(Pos.CENTER);
			btNext.setAlignment(Pos.CENTER);

			VBox vbRand = new VBox(10, lbNumber, hb, lbMin, hb1, lbMax, hb2, lbResult, generateButton, btNext);
			vbRand.setAlignment(Pos.CENTER);
			Scene scene3 = new Scene(vbRand, primaryStage.getWidth(), primaryStage.getHeight());
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			vbRand.setStyle("-fx-background-color: 	MIDNIGHTBLUE;");
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene3);
			primaryStage.show();

		});
		btBack.setOnAction(event -> {
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		});
	}

	private String getDpTableString(int[][] dp) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : dp) {
			for (int value : row) {
				sb.append((value == -1 ? "X" : value)).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static int optAns(int arr[], int[][] dp) {
	    int n = arr.length;
	    p1Coins = new int[n];
	    p2Coins = new int[n];
	    int p1C = 0, p2C = 0;

	    // Initialize diagonal of DP table
	    for (int i = 0; i < n; i++) {
	        dp[i][i] = arr[i];
	    }

	    // Fill the DP table
	    for (int l = 2; l <= n; l++) {
	        for (int i = 0; i <= n - l; i++) {
	            int j = i + l - 1;

	            int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
	            int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
	            int z = (i <= j - 2) ? dp[i][j - 2] : 0;

	            int op1 = arr[i] + Math.min(x, y);
	            int op2 = arr[j] + Math.min(y, z);

	            dp[i][j] = Math.max(op1, op2);
	        }
	    }

	    // Simulate the actual game based on DP table
	    int i = 0, j = n - 1;
	    boolean p1Turn = true;
	    while (i <= j) {
	        int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
	        int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
	        int z = (i <= j - 2) ? dp[i][j - 2] : 0;

	        int op1 = arr[i] + Math.min(x, y);
	        int op2 = arr[j] + Math.min(y, z);

	        if (op1 >= op2) {
	            if (p1Turn) {
	                player1 += arr[i];
	                p1Coins[p1C++] = arr[i];
	                System.out.println("Player 1 takes " + arr[i]);
	                System.out.println("Player1 = " + player1);
	            } else {
	                player2 += arr[i];
	                p2Coins[p2C++] = arr[i];
	                System.out.println("Player 2 takes " + arr[i]);
	                System.out.println("Player2 = " + player2);
	            }
	            i++;
	        } else {
	            if (p1Turn) {
	                player1 += arr[j];
	                p1Coins[p1C++] = arr[j];
	                System.out.println("Player 1 takes " + arr[j]);
	                System.out.println("Player1 = " + player1);
	            } else {
	                player2 += arr[j];
	                p2Coins[p2C++] = arr[j];
	                System.out.println("Player 2 takes " + arr[j]);
	                System.out.println("Player2 = " + player2);
	            }
	            j--;
	        }

	        p1Turn = !p1Turn;
	    }

	    return dp[0][n - 1];
	}

	public static void main(String[] args) {
		launch(args);

	}
	


}