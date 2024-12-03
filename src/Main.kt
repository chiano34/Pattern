import Student
import Student_short
import Data_list_student_short
import java.text.NumberFormat.Style
import Student_list_txt

fun main() {
    val ba=Student("Smith Bob Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git")
    val bob=Student("Smith","Bob","John", _phone = "+79891214092" )
    val anna=Student("Smith","Anna","Helen",_phone = "89891214092", _git = "chiano34/pattern")
    val tom=Student("Johnson","Tom","William",_phone = "9891214092")
    val tom2=Student("Jason","Tomm","William",_phone = "9891214092")
    val list: MutableList<Student> = mutableListOf(ba,bob,anna,tom,tom2)
//    var list2= mutableListOf<Student>()
//    Student.write_to_txt("src/","out.txt",list)
//    list2=Student.read_from_txt("src/out.txt")
//    print(bob.toString())
//    for(student in list2){
//        student.printObj()
//    }
//    val newbob=Student_short(bob)
//    val newanna=Student_short(anna)
//    val newtom=Student_short(tom)
//    val newba=Student_short(ba)
//    var short_list=Data_list_student_short(mutableListOf(
//        newbob,newanna,newba,newtom
//    ))
//    var short_table=short_list.get_table()
//    for (i in 0..short_table.getRows()-1)
//    {
//        for(j in 0..short_table.getCols()-1)
//        {
//            print(short_table.getElem(i,j))
//            print(" ")
//        }
//        println()
//    }
//    var a=Student_list_txt()
//    Student_list_txt().read_from_txt("src/out.txt")
//    a.add_student(tom2)
//    a.add_student(bob)
//    a.change_id(6,anna)
//    a.delete_id(11)
//    println(a.get_student_short_count())
//    a.get_k_n_student_short_list(1,5)
    var a=Student_list_JSON()
    a.add_student(ba)
    a.add_student(anna)
    println(a.get_student_short_count())
    a.write_to_json("src/json.txt")
    var c=Student_list_YAML()
    c.add_student(anna)
    c.add_student(tom)
    println(c.get_student_short_count())
    c.write_to_yaml("src/yaml.txt")
}