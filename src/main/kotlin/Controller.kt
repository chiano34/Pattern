import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField

class Controller {

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


    @FXML
    fun initialize() {
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
