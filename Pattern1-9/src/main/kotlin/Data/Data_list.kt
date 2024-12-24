open class Data_list<T>(var data:List<T>) {
    private var selected:MutableList<Int> = mutableListOf()
    fun select(index:Int){
            if(index<=data.size) {
                if(index>=1)
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
        val args= get_args()
        return (args)
    }
    open fun get_args(): MutableList<MutableList<Any?>> {
        return mutableListOf(mutableListOf())
    }
}