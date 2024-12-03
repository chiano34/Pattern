import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class Student_list_YAML:Student_list_super() {
    fun read_from_yaml(address:String):MutableList<Student>{
        val mapper = ObjectMapper(YAMLFactory()).registerKotlinModule()
       try{
           list_data = mapper.readValue(File(address), mapper.typeFactory.constructCollectionType(MutableList::class.java, Student::class.java))

       }
        catch(e: FileNotFoundException){
            println("could not find file")
        }
        catch(e: IOException){
            println("could not read file")
        }
        return list_data
    }
    fun write_to_yaml(address:String)
    {
        val file = File(address)
        val yamlMapper = ObjectMapper(YAMLFactory())
        yamlMapper.writeValue(file, list_data)
    }
}