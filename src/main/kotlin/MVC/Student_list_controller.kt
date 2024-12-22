package MVC

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

public class Student_list_controller{

    // пагинация
    private val rowsPerPage = 15

    private var view: View? = null
    private var student_list:Student_list?=null

    constructor(view: View){
        this.student_list=Student_list("database")
        this.view = view
        println("Контроллер получил view")
    }

    private val students_list: ObservableList<Student_short> = FXCollections.observableArrayList(
        Student_short(Student(1,"Abba Bob Cevin phone=+71891214092 telegram=@csdasd email=bsmth@get.ru git=chino34/git")),
        Student_short(Student(2,"Babba Ann Bobby phone=+72891214092 telegram=@bsdasd email=csmth@get.ru git=achino34/git")),
        Student_short(Student(3,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(4,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(5,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(6,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(7,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(8,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(9,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(10,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(11,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(12,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(13,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(14,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(15,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(16,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(17,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(18,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(19,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")),
        Student_short(Student(20,"Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")))

    public fun update_pages():String{
        var pagecount=Math.ceil(students_list.size.toDouble() / 15).toInt()
        return pagecount.toString()
    }
    public fun createPage(pageIndex: Int,tableView: TableView<Student_short>): TableView<Student_short>{
        val fromIndex = (pageIndex-1) * rowsPerPage
        val toIndex = Math.min(fromIndex + rowsPerPage, students_list.size)
        tableView.items = FXCollections.observableArrayList(students_list.subList(fromIndex, toIndex))
        return tableView
    }

}