class Data_list_student_short(studentsList: List<Student_short>):Data_list<Student_short>(studentsList) {
    override fun get_names(): List<String> {
        return listOf("N","FIO","git","contact")
    }
    override fun get_data(): MutableList<MutableList<Any?>> {
        var args= mutableListOf<MutableList<Any?>>()
        args.add(mutableListOf())
        var count =1
        for(row in data)
        {
            args.add(mutableListOf(count,row.FIO,row.git,row.contact))
            count++
        }
        return args
    }
}