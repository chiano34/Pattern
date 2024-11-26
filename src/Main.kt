import Student
import Student_short
import Data_list_student_short
import java.text.NumberFormat.Style

fun main() {
    val ba=Student("Smith Bob Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git")
    val bob=Student("Smith","Bob","John", _phone = "+79891214092" )
    val anna=Student("Smith","Anna","Helen",_phone = "89891214092", _git = "chiano34/pattern")
    val tom=Student("Johnson","Tom","William",_phone = "9891214092")
//    val list: MutableList<Student> = mutableListOf(bob,anna,tom,ba)
//    var list2= mutableListOf<Student>()
//    Student.write_to_txt("src/","out.txt",list)
//    list2=Student.read_from_txt("src/out.txt")
//    print(bob.toString())
//    for(student in list2){
//        student.printObj()
//    }
    val newbob=Student_short(bob)
    val newanna=Student_short(anna)
    val newtom=Student_short(tom)
    val newba=Student_short(ba)
    var short_list=Data_list_student_short(mutableListOf(
        newbob,newanna,newba,newtom
    ))
    var short_table=short_list.get_table()
    for (i in 0..short_table.getRows()-1)
    {
        for(j in 0..short_table.getCols()-1)
        {
            print(short_table.getElem(i,j))
            print(" ")
        }
        println()
    }
}