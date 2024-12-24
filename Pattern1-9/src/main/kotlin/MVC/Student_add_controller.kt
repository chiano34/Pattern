package MVC

import Data_list_student_short
import Student
import Student_list
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.stage.Modality
import javafx.stage.Stage
import kotlin.math.ceil

public class Student_add_controller{
    @FXML
    private lateinit var button_add_add: Button
    @FXML
    private lateinit var email_text_add: TextField

    @FXML
    private lateinit var firstname_text_add: TextField

    @FXML
    private lateinit var git_text_add: TextField

    @FXML
    private lateinit var lastname_text_add: TextField

    @FXML
    private lateinit var phone_text_add: TextField

    @FXML
    private lateinit var surname_text_add: TextField

    @FXML
    private lateinit var tg_text_add: TextField
    @FXML
    fun openNewWindow(){
        try {
            val loader = FXMLLoader(javaClass.getResource("/create.fxml"))
            val root: Parent = loader.load()
            val newStage = Stage()
            newStage.initModality(Modality.APPLICATION_MODAL) // Модальное окно
            newStage.title = "Новое окно"
            newStage.scene = Scene(root)
            newStage.showAndWait() // Отображаем новое окно и ждем его закрытия
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    @FXML
    fun initialize() {
        button_add_add.setOnAction {
            add_student()
        }
    }
    private var student_list=Student_list("src/main/kotlin/output/json.json")

    public fun add_student(){
        var string=""
        string+=firstname_text_add.text+" "
        string+=lastname_text_add.text+" "
        string+=surname_text_add.text+" "
        println(string)
        if(git_text_add.text!=""){
            string+="git="+git_text_add.text+" "
        }
        if(phone_text_add.text!=""){
            string+="phone="+phone_text_add.text+" "
        }
        if(tg_text_add.text!=""){
            string+="telegram="+tg_text_add.text+" "
        }
        if(email_text_add.text!=""){
            string+="email="+email_text_add.text
        }
        var a=Student(string)
        if(a.firstName!=""&&a.lastName!=""&&a.surname!="")
            student_list.add_student(a)
        val currentStage = button_add_add.scene.window as Stage
        currentStage.close()
    }
}