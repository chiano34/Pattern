import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class Student_list_txt:Student_list_super() {
    fun read_from_txt(address:String):MutableList<Student>{
        val file= File(address)
        var list= mutableListOf<Student>()
        try{
            var lines=file.readLines()
            for (line in lines){
                list.add(Student(line))
            }
        }
        catch(e: FileNotFoundException){
            println("could not find file")
        }
        catch(e: IOException){
            println("could not read file")
        }
        list_data=list
        return list
    }
    fun write_to_txt(adress:String,name:String, students:MutableList<Student>){
        val file= File(adress+name)
        for(student in students) {
            file.writeText(student.toString())
        }
    }

}