import Student
fun main() {
    val bob=Student(1,"Smith","Bob","John","798989898","@bobSmith",email="bobSmith@gmail.com");
    val anna=Student(2,"Smith","Anna","Helen","798989897","@annaSmith",email="annaSmith@gmail.com");
    val tom=Student(3,"Johnson","Tom","William","792823424","@tomWilliam",git="github.com/tomWilliam");
    val list: MutableList<Student> = mutableListOf(bob,anna,tom)
    for (student in list) {
        student.printObj()
    }
}