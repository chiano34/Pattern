import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class Student_list_txt:Student_list_super(),Strategy_interface {
    override fun read_from_file(address:String):MutableList<Student>{

        val file= File(address)
        val list= mutableListOf<Student>()
        try{
            val lines=file.readLines()
            for (line in lines){
                val (firstPart, secondPart) = line.split(" ", limit = 2)
                list.add(Student(firstPart.toInt(),secondPart))
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
    override fun write_to_file(address:String){
        File(address).printWriter().use { out ->
            list_data.forEach { message ->
                out.println(message.id.toString()+" "+message.toString())
            }
        }
    }

}