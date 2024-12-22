package MVC

import Student_short
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
class View {
    private var controller: Student_list_controller? = null
    constructor(){
        this.controller=Student_list_controller(this)
        println("Контроллер задан")
    }
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
    private lateinit var contact_table: TableColumn<Any, Any>

    @FXML
    private lateinit var git_table: TableColumn<Any, Any>

    @FXML
    private lateinit var id_table: TableColumn<Any, Any>

    @FXML
    private lateinit var fio_table: TableColumn<Any, Any>


    @FXML
    private lateinit var table: TableView<Student_short>

    @FXML
    private lateinit var button_next: Button

    @FXML
    private lateinit var button_prev: Button

    @FXML
    private lateinit var page_all: Label

    @FXML
    public lateinit var page_text: TextField
    // Активные кнопки
    @FXML
    private lateinit var button_add: Button

    @FXML
    private lateinit var button_change: Button

    @FXML
    private lateinit var button_delete: Button

    @FXML
    private lateinit var button_refresh: Button
    // Дополнительные кнопки
    @FXML
    private lateinit var button_clear: Button
    @FXML
    private lateinit var FIO_text: TextField

    @FXML
    fun initialize() {
        initiazile_filter()
        controller?.refresh_data()
        initialize_table()
        initilize_buttons()
        initialize_actions()
    }
    fun setTableParams(cur:Int,all:Int){
        page_text.text = cur.toString()
        page_all.text=all.toString()
    }
    fun setTableData(args: List<Student_short>){
        table.items.setAll(args)
    }

     fun initilize_buttons(){
         page_text.isDisable=true
        button_change.isDisable=true
        button_delete.isDisable=true
        table.selectionModel.selectionMode = SelectionMode.MULTIPLE
        table.selectionModel.selectedItemProperty().addListener { _, _, _ ->
            val selectedCount = table.selectionModel.selectedItems.size
            if(selectedCount==1){
                button_change.isDisable = false
                button_delete.isDisable = false
            }
            else if(selectedCount>1){
                button_change.isDisable = true
                button_delete.isDisable = false
            }
            if(selectedCount==0){
                button_change.isDisable = true
                button_delete.isDisable = true
            }
        }
    }
    fun initialize_actions(){
        button_prev.setOnAction {
            if(page_text.text.toInt()-1>=1){
                controller?.curPage = controller?.curPage!! - 1
            }
            controller?.refresh_data()
        }
        button_next.setOnAction {
            if(page_text.text.toInt()+1<=page_all.text.toInt()){
                controller?.curPage = controller?.curPage!! + 1
            }
            controller?.refresh_data()
        }
        button_clear.setOnAction {
            Git_list.value="Не важно"
            Phone_list.value="Не важно"
            Tg_list.value="Не важно"
            Email_list.value="Не важно"
            FIO_text.clear()
            Git_text.clear()
            Phone_text.clear()
            Tg_text.clear()
            Email_text.clear()
            Git_text.isDisable=true
            Phone_text.isDisable=true
            Email_text.isDisable=true
            Tg_text.isDisable=true

        }
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

    fun initialize_table(){
        id_table.cellValueFactory =PropertyValueFactory("id")
        fio_table.cellValueFactory = PropertyValueFactory("FIO")
        git_table.cellValueFactory = PropertyValueFactory("git")
        contact_table.cellValueFactory = PropertyValueFactory("contact")
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
