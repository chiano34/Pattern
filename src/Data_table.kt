class Data_table(private val data: Array<Array<Any>>) {
    fun getElem(row: Int, col: Int): Any? {
        return data.getOrNull(row)?.getOrNull(col)
    }
    fun getRows():Int {
        return data.size
    }
    fun getCols():Int {
        return data[0].size
    }
}