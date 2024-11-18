import Student
import Student_short
fun main() {
    val ba=Student("Smith Bob Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git")
    val bob_short=Student_short(ba)
    val bob=Student("Smith","Bob","John", _phone = "+79891214092" )
    val anna=Student("Smith","Anna","Helen",_phone = "89891214092", _git = "chiano34/pattern")
    val tom=Student("Johnson","Tom","William",_phone = "9891214092")
    val list: MutableList<Student> = mutableListOf(bob,anna,tom,ba)
    anna.validate()
    print(anna.getFIO())
    tom.set_contact(_telegram = "@tomtg")
}