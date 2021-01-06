package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SampleController  implements Initializable{
    @FXML
    public TextField tfId;
    @FXML
    public TextField tfFname;
    @FXML
    public TextField tfLname;
    @FXML
    public TextField tfNumber;
    @FXML
    public TableView<Gestion> tvhome;
    @FXML
    public TableColumn<Gestion, Integer> colId;
    @FXML
    public TableColumn<Gestion, String> colFname;
    @FXML
    public TableColumn<Gestion, String> colLname;
    @FXML
    public TableColumn<Gestion, Integer> colNumber;
    @FXML
    public Button btnInsert;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDelete;
    @FXML
    public Button btnBack;




    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource() == btnInsert){
            insertRecord();
        }
          else if(event.getSource() == btnUpdate){
              updateRecord();
          }
          else if(event.getSource() == btnDelete){
              deleteRecord();
          }
        else if(event.getSource() == btnDelete){
            deleteRecord();
        }
        else if(event.getSource() == btnBack){
            new FXMLLoader(getClass().getResource("dash.fxml"));
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showGestion();  }




    public Connection getConnection(){
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root" , "");
            return con;

        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Gestion> getGestionList(){
        ObservableList<Gestion> gestionList = FXCollections.observableArrayList();
        Connection con = getConnection();
        String query = "SELECT * FROM maisons";
        Statement st;
        ResultSet rs;

        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Gestion home;
            while (rs.next()){
                home = new Gestion(rs.getInt("id"), rs.getString("Fname"), rs.getString("Lname"), rs.getInt("Number"));
                gestionList.add(home);
            }

        }catch (Exception ex){
            ex.printStackTrace();

        }
        return gestionList;
    }

    public void showGestion(){

        ObservableList<Gestion> list = getGestionList();
        colId.setCellValueFactory(new PropertyValueFactory<Gestion, Integer>("id"));
        colFname.setCellValueFactory(new PropertyValueFactory<Gestion, String>("Fname"));
        colLname.setCellValueFactory(new PropertyValueFactory<Gestion, String>("Lname"));
        colNumber.setCellValueFactory(new PropertyValueFactory<Gestion, Integer>("numver"));

        tvhome.setItems(list);

    }

    private void insertRecord(){
        String query = "INSERT INTO maisons(id, Fname, Lname, Number)  VALUES (" + tfId.getText() + ",'" + tfFname.getText() +
                "','" + tfLname.getText() + "'," + tfNumber.getText() + ")";
        executeQuery(query);
        showGestion();
    }

    private void updateRecord(){
        String query = "UPDATE maisons SET Fname = '" + tfFname.getText() + "', Lname = '" + tfLname.getText() + "', Number = " + tfNumber.getText() + " WHERE id= " + tfId.getText() + "";
        executeQuery(query);
        showGestion();
    }

    private void deleteRecord(){
        String query = "DELETE FROM maisons WHERE id=" + tfId.getText() + "";
        executeQuery(query);
        showGestion();

    }

    private void executeQuery(String query) {
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();

        }
    }

}

