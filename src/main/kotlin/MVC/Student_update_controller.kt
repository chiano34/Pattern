
package MVC
import Data_list_student_short
import MVC.View
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

public class Student_update_controller {

    var student_list = Student_list("database")
    var id=0
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
    fun openNewWindow(id: Int) {
        try {
            val loader = FXMLLoader(javaClass.getResource("/update.fxml"))
            val root: Parent = loader.load()
            val newController = loader.getController<Student_update_controller>()
            newController.SetId(id)
            val newStage = Stage()
            newStage.initModality(Modality.APPLICATION_MODAL)
            newStage.title = "Новое окно"
            newStage.scene = Scene(root)
            newStage.showAndWait()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun SetId(Id: Int) {
        this.id = Id

    }
    @FXML
    fun initialize() {
        button_add_add.setOnAction {
            update_student()
        }
    }
//    fun get_student() {
//        student_list.get_by_id(2)
//        if (update_stud!=null){
//            firstname_text_add.text=update_stud.firstName
//            lastname_text_add.text=update_stud.lastName
//            surname_text_add.text=update_stud.surname
//            if(update_stud.git!=null)
//            git_text_add.text=update_stud.git
//            if(update_stud.phone!=null)
//            phone_text_add.text=update_stud.phone
//            if(update_stud.telegram!=null)
//            tg_text_add.text=update_stud.telegram
//            if(update_stud.email!=null)
//            email_text_add.text=update_stud.email
//        }
//    }
    fun update_student() {
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
        val update_stud=Student(string)
        student_list.update_student(update_stud,id)

    }
}