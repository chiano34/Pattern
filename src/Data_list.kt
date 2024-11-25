import java.lang.reflect.Field
open class Data_list<T>(val data:List<T>) {
    private var selected:MutableList<Int> = mutableListOf()
    fun select(index:Int){
            if(index<=data.size) {
                selected.add(index)
            }
    }
    fun get_selected(): List<Int>{
        return selected
    }
    open fun get_names(): List<String>{
        return listOf("")
    }
    open fun get_data(): MutableList<MutableList<Any?>>{
        var names = mutableListOf<Any?>("")
        var args= mutableListOf(names)
        return (args)
    }
}