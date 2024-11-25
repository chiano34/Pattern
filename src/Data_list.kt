import java.lang.reflect.Field
class Data_list(val data:List<Any?>) {
    private var selected:MutableList<Int> = mutableListOf()
    fun select(index:Int){
            if(index<=data.size) {
                selected.add(index)
            }
    }
    fun get_selected(): List<Int>{
        return selected

    }
    fun get_names(): List<String>{
        return data.map { it.toString() }
    }
    fun get_data(): Data_table{
        var table=mutableListOf<List<Any?>>()
        for(i in selected){
            var row = mutableListOf<Any?>(i)
            row.removeFirst()
            row.add(data[i]!!::class.java.declaredFields.map{it}.toList())
            table.add(row)
        }
        return Data_table(table)
    }
}