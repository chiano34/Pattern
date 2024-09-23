import Student
fun main() {
    val bob=Student("Smith","Bob","John");
    val anna=Student("Smith","Anna","Helen");
    val tom=Student("Johnson","Tom","William");
    val list: MutableList<Student> = mutableListOf(bob,anna,tom)
    for (student in list) {
        student.printObj()
    }
}