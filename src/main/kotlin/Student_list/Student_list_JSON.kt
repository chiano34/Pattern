import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class Student_list_JSON:Student_list_super(),Strategy_interface {
    override fun read_from_file(address:String):MutableList<Student>{
        val listType = object : TypeToken<MutableList<Student>>() {}.type
        var gson = Gson()
        val file = File(address)
        var text:String = ""
        try {
            text = file.readText()
        } catch (e: FileNotFoundException) {
            println("File not found")
        } catch (e: IOException) {
            println("Error reading file")
        }
        list_data = gson.fromJson(text,listType) ?: mutableListOf()
        return list_data
    }

    override fun write_to_file(address:String)
    {
        var gson = Gson()
        var json = gson.toJson(list_data)
        val file = File(address)
        file.writeText(json)
    }

    
}