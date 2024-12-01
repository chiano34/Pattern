import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class Student_list_txt {
    fun read_from_txt(address:String):MutableList<Student>{
        val file= File(address)
        var list= mutableListOf<Student>()
        print(file.absolutePath)
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
        return list
    }
    fun write_to_txt(adress:String,name:String, students:MutableList<Student>){
        val file= File(adress+name)
        for(student in students) {
            file.writeText(student.toString())
        }
    }
    fun get_by_id(id:Int, path: String):Student?
    {
        val list = read_from_txt(path)
        for(student in list)
        {
            if(student.id==id)
            {
                return student
            }
        }
        return null
    }
}