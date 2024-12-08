import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class Window : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(Window::class.java.getResource("window.fxml"))
        val scene = Scene(fxmlLoader.load(), 900.0, 600.0)
        stage.title = "Student Management App"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(Window::class.java)
}