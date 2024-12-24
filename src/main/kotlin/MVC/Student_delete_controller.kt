
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

public class Student_delete_controller {

    var student_list = Student_list("src/main/kotlin/output/json.json")

    fun delete_student(id:Int) {
        println("Удалён студент "+id)
        student_list.delete_student(id)

    }
}