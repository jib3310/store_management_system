import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

public class GUI extends Application{
	int tempquant, max, currentpro, id = -1, index;
//	public static String tempID;
	AdminInfo tempAdmin = new AdminInfo(); //create object
    Welcome welcome = new Welcome();
    ObservableList productsList = FXCollections.observableArrayList();
    ObservableList lap = FXCollections.observableArrayList();
    ObservableList desk = FXCollections.observableArrayList();
    ObservableList mice = FXCollections.observableArrayList();
    ObservableList lap1 = FXCollections.observableArrayList();
    ObservableList desk1 = FXCollections.observableArrayList();
    ObservableList mice1 = FXCollections.observableArrayList();
    ObservableList lap2 = FXCollections.observableArrayList();
    ObservableList desk2 = FXCollections.observableArrayList();
    ObservableList mice2 = FXCollections.observableArrayList();
    ObservableList lap3 = FXCollections.observableArrayList();
    ObservableList desk3 = FXCollections.observableArrayList();
    ObservableList mice3 = FXCollections.observableArrayList();
    ListView listviewlap = new ListView();
    ListView listviewdesk = new ListView();
    ListView listviewmice = new ListView();
	Scene scene0, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, scene11, scene12, scene13, scene14, scene15, scene16, scene17, scene18, scene19, scene20, scene21, scene22, scene23, scene24, scene25, scene26, scene27, scene28, scene29, scene30, scene31, scene32, scene33, scene34, scene35, scene36, scene37, scene38, scene39, scene40, scene41, scene42, scene43, scene44;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Text text25 = new Text(50,50,null);///*
		//scene0, login page
		VBox pane1 = new VBox();
		HBox bottompane = new HBox();
		BorderPane pane2 = new BorderPane();
		HBox toppane = new HBox();
		
		pane1.setStyle("-fx-border-color: black;");
		
		Text text1 = new Text(welcome.display());//display welcome message
		toppane.getChildren().add(text1);
		pane2.setTop(toppane);
		
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		
		pane1.getChildren().addAll(new Label("First Name:"), tf1, new Label("Last Name:"), tf2);
		pane2.setCenter(pane1);
		scene0 = new Scene(pane2,300,250);
		
		Button btconfirm = new Button("Confirm");
		btconfirm.setOnAction(e -> {
		tempAdmin.setName(tf1.getText()+tf2.getText()); //delete
			
		//add if tf1.gettxt() = "" then re input
		if(tf1.getText().trim() == "")
		{
			primaryStage.setScene(scene24); //change to error display scene
		}
			String lastName = tf2.getText().trim();
			 if (lastName == "") { // if lastname no input
				tempAdmin.setName(tf1.getText());

	        } else { // if lastname got input
	        	tempAdmin.setName(tf1.getText()+" "+tf2.getText());
	        }
			
		if (tempAdmin.checkValid()) {
			tempAdmin.setId(); 
			text25.setText(tempAdmin.getId()); //if name is valid get id to the exit page
			primaryStage.setScene(scene1);
			}// correct
		else
		{
			//return back to login page
			primaryStage.setScene(scene24); //if name not valid change to error scene
		}
		});
		bottompane.getChildren().add(btconfirm);
		bottompane.setAlignment(Pos.CENTER);
		pane2.setBottom(bottompane);
		
		//scene1, set maximum product page
		VBox maxpane = new VBox();
		HBox confirm = new HBox();
		BorderPane maxborder = new BorderPane();
		
		TextField maxtf = new TextField();
		maxpane.getChildren().addAll(new Label("Enter the number of maximum product can be added in store:"), maxtf);
		maxborder.setCenter(maxpane);
		
		Button btcon = new Button("Confirm");
		btcon.setOnAction(e -> {
			if(checkInput(maxtf.getText())) //check user input integer or not
			{
			max = Integer.parseInt(maxtf.getText());
			if(max > 0)
			{
				currentpro = max;
				primaryStage.setScene(scene2); //if number valid, save number to currentpro
			}
			else
				primaryStage.setScene(scene26); //if invalid number, change to error scene
			}
			else
				primaryStage.setScene(scene39); //if not integer, change to error display scene
		});
		
		confirm.getChildren().add(btcon);
		confirm.setAlignment(Pos.CENTER);
		maxborder.setBottom(confirm);
		scene1 = new Scene(maxborder,400,150);
		
		//scene2, menu page
		VBox pane3 = new VBox();
		BorderPane pane4 = new BorderPane();
		
		Button btview = new Button("View stock");
		btview.setOnAction(e -> {
		if (lap.isEmpty() && desk.isEmpty() && mice.isEmpty())
			primaryStage.setScene(scene25);// if list is empty, change to display stock empty scene
		else
			primaryStage.setScene(scene3);//else change to view stock page
		});
		
		Button btadd = new Button("Add stock");
		btadd.setOnAction(e -> {
			if (lap.isEmpty() && desk.isEmpty() && mice.isEmpty())
				primaryStage.setScene(scene25);// if list is empty, change to display stock empty scene
			else
				primaryStage.setScene(scene4);//else change to add stock page
		});
		
		Button btdeduct = new Button("Deduct stock");
		btdeduct.setOnAction(e -> {
			if (lap.isEmpty() && desk.isEmpty() && mice.isEmpty())
				primaryStage.setScene(scene25);// if list is empty, change to display stock empty scene
			else
				primaryStage.setScene(scene5);//else change to deduct stock page
		});
		
		Button btdiscon = new Button("Discontinue a product");
		btdiscon.setOnAction(e -> {
			if (lap.isEmpty() && desk.isEmpty() && mice.isEmpty())
				primaryStage.setScene(scene25);// if list is empty, change to display stock empty scene
			else
				primaryStage.setScene(scene6);//else change to discontinue product scene
		});
		
		Button btcreate = new Button("Create a product");
		btcreate.setOnAction(e -> {
		if(currentpro == 0)
			primaryStage.setScene(scene27);//check maximum product, if reach maximum change to display stock fulled page
		else
			primaryStage.setScene(scene7);//else change to create product page
		});
		
		Button btexit = new Button("Exit");
		btexit.setOnAction(e -> 
		primaryStage.setScene(scene38));//change to display user id page
		
		pane3.getChildren().addAll(btview, btadd, btdeduct, btdiscon, btcreate, btexit);
		pane3.setAlignment(Pos.CENTER);
		pane4.setCenter(pane3);
		scene2 = new Scene(pane4,300,150);
		
		//scene3, view stock page
		HBox pane5 = new HBox();
		BorderPane pane6 = new BorderPane();
		VBox pane7 = new VBox();
		
		Button btlaptop0 = new Button("Laptop");
		btlaptop0.setOnAction(e -> {
		primaryStage.setScene(scene31);//if choose laptop, change to laptop display page
		});
		
		Button btdesktop0 = new Button("Desktop");
		btdesktop0.setOnAction(e -> {
		primaryStage.setScene(scene32);//if choose desktop, change to desktop display page
		});
		
		Button btmice0 = new Button("Mice");
		btmice0.setOnAction(e -> {
		primaryStage.setScene(scene33);//if choose mice, change to mice display scene
		});
		
		pane7.getChildren().addAll(btlaptop0, btdesktop0, btmice0);
		pane7.setAlignment(Pos.CENTER);
		pane6.setCenter(pane7);
		
		Button btback0 = new Button("Back");
		btback0.setOnAction(e -> 
		primaryStage.setScene(scene2));//back to menu page
		pane5.getChildren().add(btback0);
		pane5.setAlignment(Pos.CENTER);
		pane6.setBottom(pane5);
		scene3 = new Scene(pane6,300,150);
		
		//scene4, add stock page
		HBox pane8 = new HBox();
		BorderPane pane9 = new BorderPane();
		VBox pane10 = new VBox();
		HBox pane11 = new HBox();
		
		Text text3 = new Text("Which product would you like to add?");
		pane11.getChildren().add(text3);
		pane9.setTop(pane11);
				
		Button btlaptop = new Button("Laptop");
		btlaptop.setOnAction(e -> {
			primaryStage.setScene(scene8);//if choose laptop, change to laptop list page for add stock
		});
		
		Button btdesktop = new Button("Desktop");
		btdesktop.setOnAction(e -> {
			primaryStage.setScene(scene9);//if choose desktop, change to desktop list page for add stock
		});
		
		Button btmice = new Button("Mice");
		btmice.setOnAction(e -> {
			primaryStage.setScene(scene10);//if choose mice, change to mice list page for add stock
		});
		
		pane10.getChildren().addAll(btlaptop, btdesktop, btmice);
		pane10.setAlignment(Pos.CENTER);
		pane9.setCenter(pane10);
				
		Button btback1 = new Button("Back");
		btback1.setOnAction(e -> 
		primaryStage.setScene(scene2));//back to menu page
		pane8.getChildren().add(btback1);
		pane8.setAlignment(Pos.CENTER);
		pane9.setBottom(pane8);
		scene4 = new Scene(pane9,300,150);
		
		//scene5, deduct stock page
		HBox pane12 = new HBox();
		BorderPane pane13 = new BorderPane();
		VBox pane14 = new VBox();
		HBox pane15 = new HBox();
		
		Text text4 = new Text("Which product would you like to deduct?");
		pane15.getChildren().add(text4);
		pane13.setTop(pane15);
						
		Button btlaptop1 = new Button("Laptop");
		btlaptop1.setOnAction(e -> 
		primaryStage.setScene(scene11));//if choose laptop, change to laptop list page for deduct stock
				
		Button btdesktop1 = new Button("Desktop");
		btdesktop1.setOnAction(e -> 
		primaryStage.setScene(scene12));//if choose desktop, change to desktop list page for deduct stock
				
		Button btmice1 = new Button("Mice");
		btmice1.setOnAction(e -> 
		primaryStage.setScene(scene13));//if choose mice, change to mice list page for deduct stock
				
		pane14.getChildren().addAll(btlaptop1, btdesktop1, btmice1);
		pane14.setAlignment(Pos.CENTER);
		pane13.setCenter(pane14);
						
		Button btback2 = new Button("Back");
		btback2.setOnAction(e -> 
		primaryStage.setScene(scene2));//back to menu page
		pane12.getChildren().add(btback2);
		pane12.setAlignment(Pos.CENTER);
		pane13.setBottom(pane12);
		scene5 = new Scene(pane13,300,150);
		
		//scene6, discontinue product page
		HBox pane16 = new HBox();
		BorderPane pane17 = new BorderPane();
		VBox pane18 = new VBox();
		HBox pane19 = new HBox();
				
		Text text5 = new Text("Which product would you like to discontinue?");
		pane16.getChildren().add(text5);
		pane17.setTop(pane16);
								
		Button btlaptopdiscon = new Button("Laptop");
		btlaptopdiscon.setOnAction(e -> 
		primaryStage.setScene(scene34));//if choose laptop, change to laptop list page for discontinue product
						
		Button btdesktopdiscon = new Button("Desktop");
		btdesktopdiscon.setOnAction(e -> 
		primaryStage.setScene(scene35));//if choose desktop, change to desktop list page for discontinue product
						
		Button btmicediscon = new Button("Mice");
		btmicediscon.setOnAction(e -> 
		primaryStage.setScene(scene36));//if choose mice, change to mice list page for discontinue product
						
		pane18.getChildren().addAll(btlaptopdiscon, btdesktopdiscon, btmicediscon);
		pane18.setAlignment(Pos.CENTER);
		pane17.setCenter(pane18);
								
		Button btback3 = new Button("Back");
		btback3.setOnAction(e -> 
		primaryStage.setScene(scene2));//back to menu page
		pane19.getChildren().add(btback3);
		pane19.setAlignment(Pos.CENTER);
		pane17.setBottom(pane19);
		scene6 = new Scene(pane17,300,150);
				
		
		//scene7, create product page
		HBox pane20 = new HBox();
		BorderPane pane21 = new BorderPane();
		VBox pane22 = new VBox();
						
		TextField tf4 = new TextField();
				
		pane22.getChildren().addAll(new Label("Enter the ammount of product you want to create:"), tf4);//ask user quantity of product they want to create
		pane21.setCenter(pane22);
						
		Button btback4 = new Button("Back");
		btback4.setOnAction(e -> 
		primaryStage.setScene(scene2));//back to menu page
		
		Button btconfirm2 = new Button("Confirm");
		btconfirm2.setOnAction(e -> {
			if(checkInput(tf4.getText())) //check input is integer or not
			{
				tempquant = Integer.parseInt(tf4.getText());//if input is integer, get value and store in tempquant
				if(tempquant == 0)
					primaryStage.setScene(scene2);//if input is 0, back to menu page and the product is not created
				else
					primaryStage.setScene(scene20);//else change to create product page 2
			}

			else
				primaryStage.setScene(scene41);//if input is not integer, change to error display scene
		});
		
		pane20.getChildren().addAll(btconfirm2, btback4);
		pane20.setAlignment(Pos.CENTER);
		pane21.setBottom(pane20);
		scene7 = new Scene(pane21,300,100);
		
		//scene8, laptop selection page for add stock
		BorderPane pane24 = new BorderPane();
		HBox pane25 = new HBox();
		HBox pane26 = new HBox();
		VBox panedis = new VBox();
		
		ListView listview1 = new ListView();
		listview1.setItems(lap1);//get laptop list and display it in list view
		panedis.getChildren().add(listview1);
		pane24.setCenter(panedis);
				
		listview1.setOnMouseClicked(e -> {
		index = listview1.getSelectionModel().getSelectedIndex();//get index of mouse clicked
		if(((Laptop) lap.get(index)).getStatusProduct() == "Inactive")//check choosed laptop status
		{
			primaryStage.setScene(scene37);//if inactive, change to error display scene
		}
		else
			primaryStage.setScene(scene14);//if active, change to add laptop amount page
		});
		
		Text textdis = new Text("Click on the Laptop name you would like to add.");
		pane25.getChildren().add(textdis);
		pane25.setAlignment(Pos.CENTER);
		pane24.setTop(pane25);
						
		Button btback6 = new Button("Back");
		btback6.setOnAction(e -> 
		primaryStage.setScene(scene4));
		
		pane26.getChildren().add(btback6);
		pane26.setAlignment(Pos.CENTER);
		pane24.setBottom(pane26);
		scene8 = new Scene(pane24,400,550);
		
		
		//scene9, desktop selection page for add stock
		VBox pane27 = new VBox();
		BorderPane pane28 = new BorderPane();
		HBox pane29 = new HBox();
		HBox pane30 = new HBox();
		
		ListView listview2 = new ListView();
		listview2.setItems(desk1);//get desktop list and display it in list view
		pane27.getChildren().add(listview2);
		pane28.setCenter(pane27);
						
		listview2.setOnMouseClicked(e -> {
		index = listview2.getSelectionModel().getSelectedIndex();//get index of mouse clicked
		if(((Desktop) desk.get(index)).getStatusProduct() == "Inactive")//check choosed desktop status
		{
			primaryStage.setScene(scene37);//if inactive, change to error display scene
		}
		else
			primaryStage.setScene(scene15);//if active, change to add desktop amount page
		});
		
		Text textdis1 = new Text("Click on the Desktop name you would like to add.");
		pane29.getChildren().add(textdis1);
		pane29.setAlignment(Pos.CENTER);
		pane28.setTop(pane29);
				
		Button btback7 = new Button("Back");
		btback7.setOnAction(e -> 
		primaryStage.setScene(scene4));
				
		pane30.getChildren().add(btback7);
		pane30.setAlignment(Pos.CENTER);
		pane28.setBottom(pane30);
		scene9 = new Scene(pane28,400,550);
		
		//scene10, mice selection page for add stock
		VBox pane31 = new VBox();
		BorderPane pane32 = new BorderPane();
		HBox pane33 = new HBox();
		HBox pane34 = new HBox();
										
		ListView listview3 = new ListView();
		listview3.setItems(mice1);//get mice list and display it in list view
		pane31.getChildren().add(listview3);
		pane32.setCenter(pane31);				
		
		listview3.setOnMouseClicked(e -> {
			index = listview3.getSelectionModel().getSelectedIndex();//get index of mouse clicked
			if(((Mice) mice.get(index)).getStatusProduct() == "Inactive")//check choosed mice status
			{
				primaryStage.setScene(scene37);//if inactive, change to error display scene
			}
			else
			primaryStage.setScene(scene16);//if active, change to add mice amount page
		});
		
		Text textdis3 = new Text("Click on the Mice name you would like to add.");
		pane33.getChildren().add(textdis3);
		pane33.setAlignment(Pos.CENTER);
		pane32.setTop(pane33);
						
		Button btback8 = new Button("Back");
		btback8.setOnAction(e -> 
		primaryStage.setScene(scene4));
						
		pane34.getChildren().add(btback8);
		pane34.setAlignment(Pos.CENTER);
		pane32.setBottom(pane34);
		scene10 = new Scene(pane32,400,550);
				
		//scene11, laptop selection page for deduct stock
		HBox pane35 = new HBox();
		BorderPane pane36 = new BorderPane();
		VBox pane37 = new VBox();
		HBox pane38 = new HBox();
												
		ListView listview4 = new ListView();
		listview4.setItems(lap2);
		pane37.getChildren().add(listview4);//get laptop list and display it in list view
		pane36.setCenter(pane37);
				
		listview4.setOnMouseClicked(e -> {
		index = listview4.getSelectionModel().getSelectedIndex();//get index of mouse clicked
			primaryStage.setScene(scene17);//change to deduct laptop amount page
		});
		
		Text textdis4 = new Text("Click on the Laptop name you would like to deduct.");
		pane35.getChildren().add(textdis4);
		pane35.setAlignment(Pos.CENTER);
		pane36.setTop(pane35);
												
		Button btback9 = new Button("Back");
		btback9.setOnAction(e -> 
		primaryStage.setScene(scene5));
								
		pane38.getChildren().add(btback9);
		pane38.setAlignment(Pos.CENTER);
		pane36.setBottom(pane38);
		scene11 = new Scene(pane36,400,150);
				
		//scene12, desktop selection page for deduct stock
		HBox pane39 = new HBox();
		BorderPane pane40 = new BorderPane();
		VBox pane41 = new VBox();
		HBox pane42 = new HBox();
		
		ListView listview5 = new ListView();
		listview5.setItems(desk2);//get desktop list and display it in list view
		pane41.getChildren().add(listview5);
		pane40.setCenter(pane41);

		listview5.setOnMouseClicked(e -> {
			index = listview5.getSelectionModel().getSelectedIndex();//get index of mouse clicked
			primaryStage.setScene(scene18);//change to deduct dekstop amount page
		});

		Text textdis5 = new Text("Click on the Desktop name you would like to deduct.");
		pane39.getChildren().add(textdis5);
		pane39.setAlignment(Pos.CENTER);
		pane40.setTop(pane39);
										
		Button btback10 = new Button("Back");
		btback10.setOnAction(e -> 
		primaryStage.setScene(scene5));
										
		pane42.getChildren().add(btback10);
		pane42.setAlignment(Pos.CENTER);
		pane40.setBottom(pane42);
		scene12 = new Scene(pane40,400,150);
		
		//scene13, mice selection page for deduct stock
		HBox pane43 = new HBox();
		BorderPane pane44 = new BorderPane();
		VBox pane45 = new VBox();
		HBox pane46 = new HBox();
																
		ListView listview6 = new ListView();
		listview6.setItems(mice2);//get mice list and display it in list view
		pane45.getChildren().add(listview6);
		pane44.setCenter(pane45);

		listview6.setOnMouseClicked(e -> {
			index = listview6.getSelectionModel().getSelectedIndex();//get index of mouse clicked
			primaryStage.setScene(scene19);//change to deduct mice amount page
		});

		Text textdis6 = new Text("Click on the Mice name you would like to deduct.");
		pane43.getChildren().add(textdis6);
		pane43.setAlignment(Pos.CENTER);
		pane44.setTop(pane43);
												
		Button btback11 = new Button("Back");
		btback11.setOnAction(e -> 
		primaryStage.setScene(scene5));
												
		pane46.getChildren().add(btback11);
		pane46.setAlignment(Pos.CENTER);
		pane44.setBottom(pane46);
		scene13 = new Scene(pane44,400,150);
		
		//scene14, add laptop amount page
		HBox pane47 = new HBox();
		BorderPane pane48 = new BorderPane();
		VBox pane49 = new VBox();
						
		TextField tf11 = new TextField();
						
		pane49.getChildren().addAll(new Label("How many Laptop do you want to add?:"), tf11);//ask user to enter the amount of choosed laptop they want to add
		pane48.setCenter(pane49);
								
		Button btconfirm9 = new Button("Confirm");
		btconfirm9.setOnAction(e -> {
		if(checkInput(tf11.getText())) //check input integer or not
		{
			int add = Integer.parseInt(tf11.getText());//if input is integer, get user input value and store to add
			((Laptop) lap.get(index)).setQuantProduct(((Laptop) lap.get(index)).getQuantProduct()+ add);//get choosed laptop quantity and add it with user input value
			listviewlap.setItems(null);
			listviewlap.setItems(lap);//refresh the list view in view list page
			primaryStage.setScene(scene2);//back to main page
		}
		else
			primaryStage.setScene(scene40);//if input is not integer, change to error display scene
		});
				
		Button btback12 = new Button("Back");
		btback12.setOnAction(e -> 
		primaryStage.setScene(scene8));
				
		pane47.getChildren().addAll(btconfirm9, btback12);
		pane47.setAlignment(Pos.CENTER);
		pane48.setBottom(pane47);
		scene14 = new Scene(pane48,400,150);
		
		//scene15, add desktop amount page
		HBox pane50 = new HBox();
		BorderPane pane51 = new BorderPane();
		VBox pane52 = new VBox();
								
		TextField tf12 = new TextField();
								
		pane52.getChildren().addAll(new Label("How many Desktop do you want to add?:"), tf12);//ask user to enter the amount of choosed desktop they want to add
		pane51.setCenter(pane52);
										
		Button btconfirm10 = new Button("Confirm");
		btconfirm10.setOnAction(e -> {
			if(checkInput(tf12.getText())) //check input integer or not
			{
				int add1 = Integer.parseInt(tf12.getText());//if input is integer, get user input value and store to add1
				((Desktop) desk.get(index)).setQuantProduct(((Desktop) desk.get(index)).getQuantProduct()+ add1);//get choosed desktop quantity and add it with user input value
				listviewdesk.setItems(null);
				listviewdesk.setItems(desk);//refresh the list view in view list page
				primaryStage.setScene(scene2);//back to main page
			}
			else
				primaryStage.setScene(scene40);//if input is not integer, change to error display scene
		});
						
		Button btback13 = new Button("Back");
		btback13.setOnAction(e -> 
		primaryStage.setScene(scene8));
						
		pane50.getChildren().addAll(btconfirm10, btback13);
		pane50.setAlignment(Pos.CENTER);
		pane51.setBottom(pane50);
		scene15 = new Scene(pane51,400,150);
		
		//scene16, add mice amount page
		HBox pane53 = new HBox();
		BorderPane pane54 = new BorderPane();
		VBox pane55 = new VBox();
										
		TextField tf13 = new TextField();
										
		pane55.getChildren().addAll(new Label("How many Mice do you want to add?:"), tf13);//ask user to enter the amount of choosed mice they want to add
		pane54.setCenter(pane55);
												
		Button btconfirm11 = new Button("Confirm");
		btconfirm11.setOnAction(e -> {
			if(checkInput(tf12.getText())) //check input integer or not
		{
				int add2 = Integer.parseInt(tf13.getText());//if input is integer, get user input value and store to add2
				((Mice) mice.get(index)).setQuantProduct(((Mice) mice.get(index)).getQuantProduct()+ add2);//get choosed mice quantity and add it with user input value
				listviewmice.setItems(null);
				listviewmice.setItems(mice);///refresh the list view in view list page
				primaryStage.setScene(scene2);//back to main page
		}
			else
				primaryStage.setScene(scene40);//if input is not integer, change to error display scene
		});
								
		Button btback14 = new Button("Back");
		btback14.setOnAction(e -> 
		primaryStage.setScene(scene8));
								
		pane53.getChildren().addAll(btconfirm11, btback14);
		pane53.setAlignment(Pos.CENTER);
		pane54.setBottom(pane53);
		scene16 = new Scene(pane54,400,150);
		
		//scene17, deduct laptop amount page
		HBox pane56 = new HBox();
		BorderPane pane57 = new BorderPane();
		VBox pane58 = new VBox();
										
		TextField tf14 = new TextField();
												
		pane58.getChildren().addAll(new Label("How many Laptop do you want to deduct?:"), tf14);//ask user to enter the amount of choosed laptop they want to deduct
		pane57.setCenter(pane58);
														
		Button btconfirm12 = new Button("Confirm");
		btconfirm12.setOnAction(e -> {
			if(checkInput(tf14.getText()))//check input integer or not
			{
				int deduct = Integer.parseInt(tf14.getText());//if input is integer, get user input value and store to deduct
				if (deduct <= (((Laptop) lap.get(index)).getQuantProduct())) //get choosed laptop quantity in stock and check the deduct value enter by user smaller than or not
			{
					((Laptop) lap.get(index)).setQuantProduct(((Laptop) lap.get(index)).getQuantProduct() - deduct);//if smaller than, get choosed laptop quantity and get deducted by user input value
					listviewlap.setItems(null);
					listviewlap.setItems(lap);//refresh the list view in view list page
					primaryStage.setScene(scene2);//back to main page
			}
				else
					primaryStage.setScene(scene28);//if input is not integer, change to error display scene
			}
			else
				primaryStage.setScene(scene43);//if larger than, change to error display scene
		});
										
		Button btback15 = new Button("Back");
		btback15.setOnAction(e -> 
		primaryStage.setScene(scene11));
							
		pane56.getChildren().addAll(btconfirm12, btback15);
		pane56.setAlignment(Pos.CENTER);
		pane57.setBottom(pane56);
		scene17 = new Scene(pane57,400,150);
		
		//scene18, deduct desktop amount page
		HBox pane59 = new HBox();
		BorderPane pane60 = new BorderPane();
		VBox pane61 = new VBox();
												
		TextField tf15 = new TextField();
														
		pane61.getChildren().addAll(new Label("How many Desktop do you want to deduct?:"), tf15);//ask user to enter the amount of choosed desktop they want to deduct
		pane60.setCenter(pane61);
																
		Button btconfirm13 = new Button("Confirm");
		btconfirm13.setOnAction(e -> {
			if(checkInput(tf15.getText()))//check input integer or not
			{
				int deduct1 = Integer.parseInt(tf15.getText());//if input is integer, get user input value and store to deduct1
				if (deduct1 <= (((Desktop) desk.get(index)).getQuantProduct())) //get choosed desktop quantity in stock and check the deduct value enter by user smaller than or not
				{
					((Desktop) desk.get(index)).setQuantProduct(((Desktop) desk.get(index)).getQuantProduct() - deduct1);//if smaller than, get choosed desktop quantity and get deducted by user input value
					listviewdesk.setItems(null);
					listviewdesk.setItems(desk);//refresh the list view in view list page
					primaryStage.setScene(scene2);//back to main page
				}
				else
					primaryStage.setScene(scene29);//if input is not integer, change to error display scene
			}
			else
				primaryStage.setScene(scene43);//if larger than, change to error display scene
		});
												
		Button btback16 = new Button("Back");
		btback16.setOnAction(e -> 
		primaryStage.setScene(scene12));
									
		pane59.getChildren().addAll(btconfirm13, btback16);
		pane59.setAlignment(Pos.CENTER);
		pane60.setBottom(pane59);
		scene18 = new Scene(pane60,400,150);
		
		//scene19, deduct mice amount page
		HBox pane62 = new HBox();
		BorderPane pane63 = new BorderPane();
		VBox pane64 = new VBox();
														
		TextField tf16 = new TextField();
																
		pane64.getChildren().addAll(new Label("How many Mice do you want to deduct?:"), tf16);//ask user to enter the amount of choosed mice they want to deduct
		pane63.setCenter(pane64);
																		
		Button btconfirm14 = new Button("Confirm");
		btconfirm14.setOnAction(e -> {
			if(checkInput(tf16.getText()))//check input integer or not
			{
				int deduct2 = Integer.parseInt(tf16.getText());//if input is integer, get user input value and store to deduct2
				if (deduct2 <= (((Mice) mice.get(index)).getQuantProduct())) //get choosed mice quantity in stock and check the deduct value enter by user smaller than or not
				{
					((Mice) mice.get(index)).setQuantProduct(((Mice) mice.get(index)).getQuantProduct() - deduct2);//if smaller than, get choosed mice quantity and get deducted by user input value
					listviewmice.setItems(null);
					listviewmice.setItems(mice);//refresh the list view in view list page
					primaryStage.setScene(scene2);//back to main page
				}
				else
					primaryStage.setScene(scene30);//if input is not integer, change to error display scene
			}
			else
				primaryStage.setScene(scene43);//if larger than, change to error display scene
		});
														
		Button btback17 = new Button("Back");
		btback17.setOnAction(e -> 
		primaryStage.setScene(scene13));
											
		pane62.getChildren().addAll(btconfirm14, btback17);
		pane62.setAlignment(Pos.CENTER);
		pane63.setBottom(pane62);
		scene19 = new Scene(pane63,400,150);
		
		//scene20, choose create product page
		HBox pane65 = new HBox();
		BorderPane pane66 = new BorderPane();
		VBox pane67 = new VBox();
				
		Text text12 = new Text("Which product would you like to create?");
		pane65.getChildren().add(text12);
		pane66.setCenter(pane65);
						
		Button btlaptop2 = new Button("Laptop");
		btlaptop2.setOnAction(e -> 
		primaryStage.setScene(scene21));//change to laptop creation page
				
		Button btdesktop2 = new Button("Desktop");
		btdesktop2.setOnAction(e -> 
		primaryStage.setScene(scene22));//change to desktop creation scene
				
		Button btmice2 = new Button("Mice");
		btmice2.setOnAction(e -> 
		primaryStage.setScene(scene23));//change to mice creation scene
				
		pane67.getChildren().addAll(btlaptop2, btdesktop2, btmice2);
		pane67.setAlignment(Pos.CENTER);
		pane66.setBottom(pane67);
		scene20 = new Scene(pane66,300,100);
				
		//scene21, laptop creation page
		VBox pane68 = new VBox();
		HBox pane69 = new HBox();
		BorderPane pane70 = new BorderPane();
		
		TextField tf17 = new TextField();
		TextField tf18 = new TextField();
		TextField tf19 = new TextField();
		TextField tf20 = new TextField();
		TextField tf21 = new TextField();
		TextField tf22 = new TextField();
		TextField tf23 = new TextField();
		TextField tf24 = new TextField();
		TextField tf25 = new TextField();
		
		//let user enter details of new laptop product
		pane68.getChildren().addAll(new Label("Product Name:"), tf17, new Label("Manufacturer:"), tf18, new Label("Color:"), tf19, new Label("Screen size:"), tf20, new Label("Processor:"), tf21, new Label("Memory (RAM):"), tf22, new Label("Storage size:"), tf23, new Label("Price:"), tf24, new Label("Item number:"), tf25);
		pane70.setCenter(pane68);
		
		Button btconfirm15 = new Button("Confirm");
		btconfirm15.setOnAction(e -> {
			//check input of double and integer
			if(checkInput(tf20.getText()) && checkInput(tf22.getText()) && checkInput(tf23.getText()) && checkInput(tf24.getText()) && checkInput(tf25.getText()))
		{
				String tempNameLap = tf17.getText();
				String tempManuLap = tf18.getText();
				String tempColorLap = tf19.getText();
				double tempScrLap = Double.parseDouble(tf20.getText());
				String tempProcLap = tf21.getText();
				int tempRAMLap = Integer.parseInt(tf22.getText());
				int tempStoLap = Integer.parseInt(tf23.getText());
				double tempPriLap = Double.parseDouble(tf24.getText());
				tempPriLap = tempPriLap * 1.1;
				int tempNumLap = Integer.parseInt(tf25.getText());
				//if true, call constructor of laptop to create a new laptop product
				Product tempLaptop = new Laptop(tempNumLap, tempNameLap, tempManuLap, tempquant, tempPriLap, tempColorLap, tempScrLap, tempProcLap, tempRAMLap, tempStoLap);
				//add new laptop to list
				productsList.add(tempLaptop);
				lap.add(tempLaptop);
				lap1.add(tempLaptop.getNameProduct());
				lap2.add(tempLaptop.getNameProduct());
				lap3.add(tempLaptop.getNameProduct());
				currentpro = currentpro - 1 ;
				primaryStage.setScene(scene2);//back to menu page
		}
			else
				primaryStage.setScene(scene42);//if user enter wrong data type, change to error display scene
		});
		
		pane69.getChildren().add(btconfirm15);
		pane69.setAlignment(Pos.CENTER);
		pane70.setBottom(pane69);
		scene21 = new Scene(pane70,300,500);
		
		//scene22, desktop creation page
		VBox pane71 = new VBox();
		HBox pane72 = new HBox();
		BorderPane pane73 = new BorderPane();
		
		TextField tf26 = new TextField();
		TextField tf27 = new TextField();
		TextField tf28 = new TextField();
		TextField tf29 = new TextField();
		TextField tf30 = new TextField();
		TextField tf31 = new TextField();
		TextField tf32 = new TextField();
		TextField tf33 = new TextField();
		TextField tf34 = new TextField();
		TextField tf35 = new TextField();
		TextField tf36 = new TextField();
		
		//let user enter details of new desktop product
		pane71.getChildren().addAll(new Label("Product Name:"), tf26, new Label("Manufacturer:"), tf27, new Label("Form factor:"), tf28, new Label("Usage category:"), tf29, new Label("Processor:"), tf30, new Label("Memory (RAM):"), tf31, new Label("Storage size:"), tf32, new Label("Storage type:"), tf33, new Label("Screen size:"), tf34, new Label("Price:"), tf35, new Label("Item number:"), tf36);
		pane73.setCenter(pane71);
				
		Button btconfirm16 = new Button("Confirm");
		btconfirm16.setOnAction(e -> {
			//check input of double and integer
			if(checkInput(tf31.getText()) && checkInput(tf32.getText()) && checkInput(tf34.getText()) && checkInput(tf35.getText()) && checkInput(tf36.getText()))
		{
				String tempNameDesk = tf26.getText();
				String tempManuDesk = tf27.getText();
				String tempFormDesk = tf28.getText();
				String tempUsageDesk = tf29.getText();
				String tempProcDesk = tf30.getText();
				int tempRAMDesk = Integer.parseInt(tf31.getText());
				int tempStoDesk = Integer.parseInt(tf32.getText());
				String tempTypeDesk = tf33.getText();
				double tempScrDesk = Double.parseDouble(tf34.getText());
				double tempPriDesk = Double.parseDouble(tf35.getText());
				tempPriDesk = tempPriDesk * 1.1;
				int tempNumDesk = Integer.parseInt(tf36.getText());
				//if true, call constructor of desktop to create a new desktop product
				Product tempDesktop = new Desktop(tempNumDesk, tempNameDesk, tempManuDesk, tempquant, tempPriDesk, tempUsageDesk, tempProcDesk, tempRAMDesk, tempStoDesk, tempTypeDesk, tempScrDesk, tempFormDesk);
				//add new desktop to list
				productsList.add(tempDesktop);
				desk.add(tempDesktop);
				desk1.add(tempDesktop.getNameProduct());
				desk2.add(tempDesktop.getNameProduct());
				desk3.add(tempDesktop.getNameProduct());
				currentpro = currentpro - 1 ;
				primaryStage.setScene(scene2);//back to menu page
		}
			else
				primaryStage.setScene(scene42);	//if user enter wrong data type, change to error display scene
		});
				
		pane72.getChildren().add(btconfirm16);
		pane72.setAlignment(Pos.CENTER);
		pane73.setBottom(pane72);
		scene22 = new Scene(pane73,300,550);
		
		//scene23, mice creation page
		VBox pane74 = new VBox();
		HBox pane75 = new HBox();
		BorderPane pane76 = new BorderPane();
								
		TextField tf39 = new TextField();
		TextField tf40 = new TextField();
		TextField tf41 = new TextField();
		TextField tf42 = new TextField();
		TextField tf43 = new TextField();
		TextField tf44 = new TextField();
		TextField tf45 = new TextField();
				
		//let user enter details of new mice product
		pane74.getChildren().addAll(new Label("Product Name:"), tf39, new Label("Manufacturer:"), tf40, new Label("Connectivity:"), tf41, new Label("Scroll type:"), tf42, new Label("Size:"), tf43, new Label("Price:"), tf44, new Label("Item number:"), tf45);
		pane76.setCenter(pane74);
		
		Button btconfirm17 = new Button("Confirm");
		btconfirm17.setOnAction(e -> {
			//check input of double and integer
			if(checkInput(tf44.getText()) && checkInput(tf45.getText()))
			{
				String tempNameMice = tf39.getText();
				String tempManuMice = tf40.getText();
				String tempConMice = tf41.getText();
				String tempScrlMice = tf42.getText();
				String tempSizeMice = tf43.getText();
				double tempPriMice = Double.parseDouble(tf44.getText());
				int tempNumMice = Integer.parseInt(tf45.getText());
				//if true, call constructor of mice to create a new mice product
				Product tempMice = new Mice(tempNumMice, tempNameMice, tempManuMice, tempquant, tempPriMice, tempConMice, tempSizeMice, tempScrlMice);
				//add new mice to list
				productsList.add(tempMice);	
				mice.add(tempMice);
				mice1.add(tempMice.getNameProduct());
				mice2.add(tempMice.getNameProduct());
				mice3.add(tempMice.getNameProduct());
				currentpro = currentpro - 1 ;
				primaryStage.setScene(scene2);//back to menu page
			}
			else
				primaryStage.setScene(scene42);//if user enter wrong data type, change to error display scene
		});
						
		pane75.getChildren().add(btconfirm17);
		pane75.setAlignment(Pos.CENTER);
		pane76.setBottom(pane75);
		scene23 = new Scene(pane76,300,400);
		
		//scene24, error display page
		VBox pane77 = new VBox();
		BorderPane pane78 = new BorderPane();
		HBox pane79 = new HBox();
				
		Text text13 = new Text(50,50,"Invalid input!");
		text13.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
						FontPosture.REGULAR, 20) );
		text13.setFill(Color.RED);
		pane77.getChildren().add(text13);
		pane77.setAlignment(Pos.CENTER);
		pane78.setCenter(pane77);
				
		Button btback18 = new Button("Back");
		btback18.setOnAction(e -> 
		primaryStage.setScene(scene0));
													
		pane79.getChildren().add(btback18);
		pane79.setAlignment(Pos.CENTER);
		pane78.setBottom(pane79);
		scene24 = new Scene(pane78,300,400);
		
		//scene25, error display page
		VBox pane80 = new VBox();
		BorderPane pane81 = new BorderPane();
		HBox pane82 = new HBox();
		
		Text text14 = new Text(50,50,"No product found!");
		text14.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
				FontPosture.REGULAR, 20) );
		text14.setFill(Color.RED);
		pane80.getChildren().add(text14);
		pane80.setAlignment(Pos.CENTER);
		pane81.setCenter(pane80);
		
		Button btback19 = new Button("Back");
		btback19.setOnAction(e -> 
		primaryStage.setScene(scene2));
											
		pane82.getChildren().add(btback19);
		pane82.setAlignment(Pos.CENTER);
		pane81.setBottom(pane82);
		scene25 = new Scene(pane81,300,400);
		
		//scene26, error display page
		VBox pane83 = new VBox();
		BorderPane pane84 = new BorderPane();
		HBox pane85 = new HBox();
				
		Text text15 = new Text(50,50,"Invalid Input!");
		text15.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
						FontPosture.REGULAR, 20) );
		text15.setFill(Color.RED);
		pane83.getChildren().add(text15);
		pane83.setAlignment(Pos.CENTER);
		pane84.setCenter(pane83);
				
		Button btback20 = new Button("Back");
		btback20.setOnAction(e -> 
		primaryStage.setScene(scene1));
													
		pane85.getChildren().add(btback20);
		pane85.setAlignment(Pos.CENTER);
		pane84.setBottom(pane85);
		scene26 = new Scene(pane84,300,400);
		
		//scene27, error display page
		VBox pane86 = new VBox();
		BorderPane pane87 = new BorderPane();
		HBox pane88 = new HBox();
						
		Text text16 = new Text(50,50,"Maximum product added reached!");
		text16.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
								FontPosture.REGULAR, 20) );
		text16.setFill(Color.RED);
		pane86.getChildren().add(text16);
		pane86.setAlignment(Pos.CENTER);
		pane87.setCenter(pane86);
						
		Button btback21 = new Button("Back");
		btback21.setOnAction(e -> 
		primaryStage.setScene(scene2));
		
		pane88.getChildren().add(btback21);
		pane88.setAlignment(Pos.CENTER);
		pane87.setBottom(pane88);
		scene27 = new Scene(pane87,500,400);
										
		//scene28, error display page
		VBox pane89 = new VBox();
		BorderPane pane90 = new BorderPane();
		HBox pane91 = new HBox();
								
		Text text17 = new Text(50,50,"Number enter larger than Laptop in stock!");
		text17.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
										FontPosture.REGULAR, 20) );
		text17.setFill(Color.RED);
		pane89.getChildren().add(text17);
		pane89.setAlignment(Pos.CENTER);
		pane90.setCenter(pane89);
								
		Button btback22 = new Button("Back");
		btback22.setOnAction(e -> 
		primaryStage.setScene(scene5));
				
		pane91.getChildren().add(btback22);
		pane91.setAlignment(Pos.CENTER);
		pane90.setBottom(pane91);
		scene28 = new Scene(pane90,400,400);
		
		//scene29, error display page
		VBox pane92 = new VBox();
		BorderPane pane93 = new BorderPane();
		HBox pane94 = new HBox();
										
		Text text18 = new Text(50,50,"Number enter larger than Desktop in stock!");
		text18.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
												FontPosture.REGULAR, 20) );
		text18.setFill(Color.RED);
		pane92.getChildren().add(text18);
		pane92.setAlignment(Pos.CENTER);
		pane93.setCenter(pane92);
										
		Button btback23 = new Button("Back");
		btback23.setOnAction(e -> 
		primaryStage.setScene(scene5));
						
		pane94.getChildren().add(btback23);
		pane94.setAlignment(Pos.CENTER);
		pane93.setBottom(pane94);
		scene29 = new Scene(pane93,400,400);
		
		//scene30, error display page
		VBox pane95 = new VBox();
		BorderPane pane96 = new BorderPane();
		HBox pane97 = new HBox();
												
		Text text19 = new Text(50,50,"Number enter larger than Mice in stock!");
		text19.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
														FontPosture.REGULAR, 20) );
		text19.setFill(Color.RED);
		pane95.getChildren().add(text19);
		pane95.setAlignment(Pos.CENTER);
		pane96.setCenter(pane95);
												
		Button btback24 = new Button("Back");
		btback24.setOnAction(e -> 
		primaryStage.setScene(scene5));
								
		pane97.getChildren().add(btback24);
		pane97.setAlignment(Pos.CENTER);
		pane96.setBottom(pane97);
		scene30 = new Scene(pane96,400,400);
		
		//scene31, laptop display page
		HBox pane98 = new HBox();
		BorderPane pane99 = new BorderPane();
		VBox pane100 = new VBox();
		
		listviewlap.setItems(lap);//add list into list view to display list of laptop
		pane100.getChildren().add(listviewlap);
		pane99.setCenter(pane100);
		
		Button btback25 = new Button("Back");
		btback25.setOnAction(e -> 
		primaryStage.setScene(scene3));//back to view stock page
		pane98.getChildren().add(btback25);
		pane98.setAlignment(Pos.CENTER);
		pane99.setBottom(pane98);
		scene31 = new Scene(pane99,500,400);
		
		//scene32, desktop display page
		HBox pane101 = new HBox();
		BorderPane pane102 = new BorderPane();
		VBox pane103 = new VBox();
				
		listviewdesk.setItems(desk);//add list into list view to display list of desktop
		pane103.getChildren().add(listviewdesk);
		pane102.setCenter(pane103);
					
		Button btback26 = new Button("Back");
		btback26.setOnAction(e -> 
		primaryStage.setScene(scene3));//back to view stock page
		pane101.getChildren().add(btback26);
		pane101.setAlignment(Pos.CENTER);
		pane102.setBottom(pane101);
		scene32 = new Scene(pane102,500,400);
		
		//scene33, mice display page
		HBox pane104 = new HBox();
		BorderPane pane105 = new BorderPane();
		VBox pane106 = new VBox();
						
		listviewmice.setItems(mice);//add list into list view to display list of mice
		pane106.getChildren().add(listviewmice);
		pane105.setCenter(pane106);
							
		Button btback27 = new Button("Back");
		btback27.setOnAction(e -> 
		primaryStage.setScene(scene3));//back to view stock page
		pane104.getChildren().add(btback27);
		pane104.setAlignment(Pos.CENTER);
		pane105.setBottom(pane104);
		scene33 = new Scene(pane105,500,400);
		
		//scene34, laptop list page for discontinue product
		BorderPane pane107 = new BorderPane();
		HBox pane108 = new HBox();
		HBox pane109 = new HBox();
		VBox pane110 = new VBox();
				
		ListView listview7 = new ListView();
		listview7.setItems(lap3);//get laptop list and added into list view to display
		pane110.getChildren().add(listview7);
		pane107.setCenter(pane110);
						
		listview7.setOnMouseClicked(e -> {
			index = listview7.getSelectionModel().getSelectedIndex();//get index of mouse clicked
			((Laptop) lap.get(index)).setStatusProduct("Inactive");//set status of chosen laptop to inactive
			listviewlap.setItems(null);
			listviewlap.setItems(lap);//refresh the list view
			primaryStage.setScene(scene2);//back to menu page
		});
				
		Text text20 = new Text("Click on the Laptop name you would like discontinue.");
		pane108.getChildren().add(text20);
		pane108.setAlignment(Pos.CENTER);
		pane107.setTop(pane108);
								
		Button btback28 = new Button("Back");
		btback28.setOnAction(e -> 
		primaryStage.setScene(scene2));
				
		pane109.getChildren().add(btback28);
		pane109.setAlignment(Pos.CENTER);
		pane107.setBottom(pane109);
		scene34 = new Scene(pane107,400,550);
				
		//scene35, desktop list page for discontinue product
		BorderPane pane111 = new BorderPane();
		HBox pane112 = new HBox();
		HBox pane113 = new HBox();
		VBox pane114 = new VBox();
						
		ListView listview8 = new ListView();
		listview8.setItems(desk3);//get desktop list and added into list view to display
		pane114.getChildren().add(listview8);
		pane111.setCenter(pane114);
								
		listview8.setOnMouseClicked(e -> {
		index = listview8.getSelectionModel().getSelectedIndex();//get index of mouse clicked
		((Desktop) desk.get(index)).setStatusProduct("Inactive");//set status of chosen desktop to inactive
		listviewdesk.setItems(null);
		listviewdesk.setItems(desk);//refresh the list view
		primaryStage.setScene(scene2);//back to menu page
		});
						
		Text text21 = new Text("Click on the Desktop name you would like discontinue.");
		pane112.getChildren().add(text21);
		pane112.setAlignment(Pos.CENTER);
		pane111.setTop(pane112);
										
		Button btback29 = new Button("Back");
		btback29.setOnAction(e -> 
		primaryStage.setScene(scene2));
						
		pane113.getChildren().add(btback29);
		pane113.setAlignment(Pos.CENTER);
		pane111.setBottom(pane113);
		scene35 = new Scene(pane111,400,550);
		
		//scene36, mice list page for discontinue product
		BorderPane pane115 = new BorderPane();
		HBox pane116 = new HBox();
		HBox pane117 = new HBox();
		VBox pane118 = new VBox();
								
		ListView listview9 = new ListView();
		listview9.setItems(mice3);//get mice list and added into list view to display
		pane118.getChildren().add(listview9);
		pane115.setCenter(pane118);
										
		listview9.setOnMouseClicked(e -> {
		index = listview9.getSelectionModel().getSelectedIndex();//get index of mouse clicked
		((Mice) mice.get(index)).setStatusProduct("Inactive");//set status of chosen mice to inactive
		listviewmice.setItems(null);
		listviewmice.setItems(mice);//refresh the list view
		primaryStage.setScene(scene2);//back to menu page
		});
								
		Text text22 = new Text("Click on the Mice name you would like discontinue.");
		pane116.getChildren().add(text22);
		pane116.setAlignment(Pos.CENTER);
		pane115.setTop(pane116);
												
		Button btback30 = new Button("Back");
		btback30.setOnAction(e -> 
		primaryStage.setScene(scene2));
								
		pane117.getChildren().add(btback30);
		pane117.setAlignment(Pos.CENTER);
		pane115.setBottom(pane117);
		scene36 = new Scene(pane115,400,550);
		
		//scene37, error display page
		VBox pane119 = new VBox();
		BorderPane pane120 = new BorderPane();
		HBox pane121 = new HBox();
														
		Text text23 = new Text(50,50,"Product is inactive!");
		text23.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																FontPosture.REGULAR, 20) );
		text23.setFill(Color.RED);
		pane119.getChildren().add(text23);
		pane119.setAlignment(Pos.CENTER);
		pane120.setCenter(pane119);
														
		Button btback31 = new Button("Back");
		btback31.setOnAction(e -> 
		primaryStage.setScene(scene4));
										
		pane121.getChildren().add(btback31);
		pane121.setAlignment(Pos.CENTER);
		pane120.setBottom(pane121);
		scene37 = new Scene(pane120,400,400);
		
		//scene38, exit page
		VBox pane122 = new VBox();
		BorderPane pane123 = new BorderPane();
		HBox pane124 = new HBox();
										
		Text text24 = new Text(50,50,"BYE!");
		text24.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																FontPosture.REGULAR, 20) );
		text24.setFill(Color.RED);
		
		text25.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																FontPosture.REGULAR, 20) );
		text25.setFill(Color.RED);
		pane122.getChildren().addAll(text24,text25);
		pane122.setAlignment(Pos.CENTER);
		pane123.setCenter(pane122);
																
		Button btback32 = new Button("Close");
		btback32.setOnAction(e -> 
		primaryStage.close());//close the program
		
		pane124.getChildren().add(btback32);
		pane124.setAlignment(Pos.CENTER);
		pane123.setBottom(pane124);
		scene38 = new Scene(pane123,400,400);
		
		//scene39, error display page
		VBox pane125 = new VBox();
		BorderPane pane126 = new BorderPane();
		HBox pane127 = new HBox();
																
		Text text26 = new Text(50,50,"Invalid input!");
		text26.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																		FontPosture.REGULAR, 20) );
		text26.setFill(Color.RED);
		pane125.getChildren().add(text26);
		pane125.setAlignment(Pos.CENTER);
		pane126.setCenter(pane125);
																
		Button btback33 = new Button("Back");
		btback33.setOnAction(e -> 
		primaryStage.setScene(scene1));
												
		pane127.getChildren().add(btback33);
		pane127.setAlignment(Pos.CENTER);
		pane126.setBottom(pane127);
		scene39 = new Scene(pane126,400,400);	
		
		//scene40, error display page
		VBox pane128 = new VBox();
		BorderPane pane129 = new BorderPane();
		HBox pane130 = new HBox();
																		
		Text text27 = new Text(50,50,"Invalid input!");
		text27.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																				FontPosture.REGULAR, 20) );
		text27.setFill(Color.RED);
		pane128.getChildren().add(text27);
		pane128.setAlignment(Pos.CENTER);
		pane129.setCenter(pane128);
																		
		Button btback34 = new Button("Back");
		btback34.setOnAction(e -> 
		primaryStage.setScene(scene4));
														
		pane130.getChildren().add(btback34);
		pane130.setAlignment(Pos.CENTER);
		pane129.setBottom(pane130);
		scene40 = new Scene(pane129,400,400);	
				
		//scene41, error display page
		VBox pane131 = new VBox();
		BorderPane pane132 = new BorderPane();
		HBox pane133 = new HBox();
																				
		Text text28 = new Text(50,50,"Invalid input!");
		text28.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																				FontPosture.REGULAR, 20) );
		text28.setFill(Color.RED);
		pane131.getChildren().add(text28);
		pane131.setAlignment(Pos.CENTER);
		pane132.setCenter(pane131);
																				
		Button btback35 = new Button("Back");
		btback35.setOnAction(e -> 
		primaryStage.setScene(scene7));
																
		pane133.getChildren().add(btback35);
		pane133.setAlignment(Pos.CENTER);
		pane132.setBottom(pane133);
		scene41 = new Scene(pane132,400,400);
		
		//scene42, error display page
		VBox pane134 = new VBox();
		BorderPane pane135 = new BorderPane();
		HBox pane136 = new HBox();
																						
		Text text29 = new Text(50,50,"Invalid input!");
		text29.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																				FontPosture.REGULAR, 20) );
		text29.setFill(Color.RED);
		pane134.getChildren().add(text29);
		pane134.setAlignment(Pos.CENTER);
		pane135.setCenter(pane134);
																						
		Button btback36 = new Button("Back");
		btback36.setOnAction(e -> 
		primaryStage.setScene(scene20));
																		
		pane136.getChildren().add(btback36);
		pane136.setAlignment(Pos.CENTER);
		pane135.setBottom(pane136);
		scene42 = new Scene(pane135,400,400);
		
		//scene43, error display page
		VBox pane137 = new VBox();
		BorderPane pane138 = new BorderPane();
		HBox pane139 = new HBox();
																								
		Text text30 = new Text(50,50,"Invalid input!");
		text30.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
																				FontPosture.REGULAR, 20) );
		text30.setFill(Color.RED);
		pane137.getChildren().add(text30);
		pane137.setAlignment(Pos.CENTER);
		pane138.setCenter(pane137);
																								
		Button btback37 = new Button("Back");
		btback37.setOnAction(e -> 
		primaryStage.setScene(scene5));
																				
		pane139.getChildren().add(btback37);
		pane139.setAlignment(Pos.CENTER);
		pane138.setBottom(pane139);
		scene43 = new Scene(pane138,400,400);
			
		primaryStage.setTitle("Store Management System"); // Set the stage title
		primaryStage.setScene(scene0); // Place the scene in the stage
		primaryStage.show();
	}
	
	public static boolean checkInput(String tempValue) //to get the number input only
    {

        String tempSnum;
        boolean error1 = false;
        boolean error2 = false;
        int tempNum = 0;
        char[] charArray; //for check valid name

            tempSnum = tempValue; //takes input
            tempSnum = tempSnum.trim();
            charArray = tempSnum.toCharArray();

            for (char c : charArray)  // check every char is int
                if (!Character.isDigit(c)) { //if a char is not int
                    error1 = true;
                    break;
                }

            if (!error1) // if all char is int ,check every char is nonnegative
            {
                tempNum = Integer.parseInt(tempSnum);
                if (tempNum < 0) error2 = true; //if input is not +ve
                else error2 = false;
            }

		if (error1 == true||error2 == true)return false;

		else return true;
    }
	
}
