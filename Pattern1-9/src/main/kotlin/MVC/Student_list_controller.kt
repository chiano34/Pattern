package MVC

import Data_list
import Data_list_student_short
import Student
import Student_list
import Student_short
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.SelectionMode
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import kotlin.math.ceil

public class Student_list_controller{

    // пагинация
    private val rowsPerPage = 15
    public var curPage=1
    public var allPages=1
    private lateinit var data_list: Data_list_student_short
    private var view: View? = null
    private var student_list:Student_list?=null

    constructor(view: View){
        this.student_list=Student_list("src/main/kotlin/output/json.json")
        this.view = view
    }
    fun refresh_data(){
        this.student_list=Student_list("src/main/kotlin/output/json.json")
        allPages=ceil(student_list!!.get_count().toDouble()/15.0).toInt()
        view?.setTableParams(curPage,allPages)
        view?.filters
        data_list= student_list?.get_k_n_student_short_list(curPage,rowsPerPage,view?.filters!!)!!
        data_list.setObserver(view!!)
        data_list.notify_view()
    }

}