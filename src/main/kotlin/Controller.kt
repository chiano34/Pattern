import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.util.Callback

class Controller {
    //фильтрация
    @FXML
    private lateinit var Email_list: ComboBox<Any>

    @FXML
    private lateinit var Email_text: TextField

    @FXML
    private lateinit var Git_list: ComboBox<Any>

    @FXML
    private lateinit var Git_text: TextField

    @FXML
    private lateinit var Phone_list: ComboBox<Any>

    @FXML
    private lateinit var Phone_text: TextField

    @FXML
    private lateinit var Tg_list: ComboBox<Any>

    @FXML
    private lateinit var Tg_text: TextField

    //Таблица
    @FXML
    private lateinit var email_table: TableColumn<Any, Any>

    @FXML
    private lateinit var firstname_table: TableColumn<Any, Any>

    @FXML
    private lateinit var git_table: TableColumn<Any, Any>

    @FXML
    private lateinit var id_table: TableColumn<Any, Any>

    @FXML
    private lateinit var lastname_table: TableColumn<Any, Any>

    @FXML
    private lateinit var phone_table: TableColumn<Any, Any>

    @FXML
    private lateinit var surname_table: TableColumn<Any, Any>

    @FXML
    private lateinit var table: TableView<Student>

    @FXML
    private lateinit var tg_table: TableColumn<Any, Any>
    // пагинация
    private val rowsPerPage = 15
    private lateinit var pagination: Pagination
    @FXML
    private lateinit var button_next: Button

    @FXML
    private lateinit var button_prev: Button

    @FXML
    private lateinit var page_all: Label

    @FXML
    private lateinit var page_text: TextField

    private val students_list: ObservableList<Student> = FXCollections.observableArrayList(
        Student("Abba Bob Cevin phone=+71891214092 telegram=@csdasd email=bsmth@get.ru git=chino34/git"),
        Student("Babba Ann Bobby phone=+72891214092 telegram=@bsdasd email=csmth@get.ru git=achino34/git"),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git "),
        Student("Cabba Casey Andrew phone=+73891214092 telegram=@asdasd email=asmth@get.ru git=bchino34/git ")
    )
    @FXML
    fun initialize() {
        initialize_table()
        initiazile_filter()
        update_pages()
        button_prev.setOnAction {
            if(page_text.text.toInt()-1>=1){
                page_text.text=(page_text.text.toInt()-1).toString()
            }
            update_pages()
        }
        button_next.setOnAction {
            if(page_text.text.toInt()+1<=page_all.text.toInt()){
                page_text.text=(page_text.text.toInt()+1).toString()
            }
            update_pages()
        }
    }

    fun initialize_table(){
        id_table.cellValueFactory =PropertyValueFactory("id")
        lastname_table.cellValueFactory = PropertyValueFactory("lastName")
        firstname_table.cellValueFactory = PropertyValueFactory("firstName")
        surname_table.cellValueFactory = PropertyValueFactory("surname")
        git_table.cellValueFactory = PropertyValueFactory("git")
        tg_table.cellValueFactory = PropertyValueFactory("telegram")
        phone_table.cellValueFactory = PropertyValueFactory("phone")
        email_table.cellValueFactory = PropertyValueFactory("email")
    }
    private fun update_pages(){
        var pagecount=Math.ceil(students_list.size.toDouble() / 15).toInt()
        page_all.text=pagecount.toString()
        createPage(page_text.text.toInt())
    }
    private fun createPage(pageIndex: Int): Node? {
        val fromIndex = (pageIndex-1) * rowsPerPage
        val toIndex = Math.min(fromIndex + rowsPerPage, students_list.size)
        table.items = FXCollections.observableArrayList(students_list.subList(fromIndex, toIndex))
        return table
    }
    fun initiazile_filter(){
        val git_list:ObservableList<Any> = FXCollections.observableArrayList("Да", "Нет", "Не важно")
        val phone_list:ObservableList<Any> = FXCollections.observableArrayList("Да", "Нет", "Не важно")
        val email_list:ObservableList<Any> = FXCollections.observableArrayList("Да", "Нет", "Не важно")
        val tg_list:ObservableList<Any> = FXCollections.observableArrayList("Да", "Нет", "Не важно")
        Git_list.items = git_list
        Phone_list.items = phone_list
        Email_list.items = email_list
        Tg_list.items = tg_list
        Git_list.setOnAction {
            handleChoice()
        }
        Phone_list.setOnAction {
            handleChoice()
        }
        Email_list.setOnAction {
            handleChoice()
        }
        Tg_list.setOnAction {
            handleChoice()
        }
    }

    private fun handleChoice() {
        when (Git_list.value) {
            "Да" -> Git_text.isDisable = false
            "Нет", "Не важно" -> {Git_text.isDisable = true
            Git_text.clear()}
        }
        when (Tg_list.value) {
            "Да" -> Tg_text.isDisable = false
            "Нет", "Не важно" -> {Tg_text.isDisable = true
                Tg_text.clear()}
        }
        when (Email_list.value) {
            "Да" -> Email_text.isDisable = false
            "Нет", "Не важно" -> {Email_text.isDisable = true
                Email_text.clear()}
        }
        when (Phone_list.value) {
            "Да" -> Phone_text.isDisable = false
            "Нет", "Не важно" -> {Phone_text.isDisable = true
                Phone_text.clear()}
        }
        
    }

}
