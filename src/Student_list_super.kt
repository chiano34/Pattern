open class Student_list_super {
    var list_data:MutableList<Student> = mutableListOf<Student>()
    fun get_by_id(id:Int):Student?
    {
        for(student in list_data)
        {
            if(student.id==id)
            {
                return student
            }
        }
        return null
    }
    fun add_student(student: Student){
        if(list_data.size>0)
            student.id=list_data.maxOf{it.id}+1
        list_data.add(student)
    }
    fun change_id(id:Int,student: Student){
        var st=get_by_id(id)
        if(st!=null){
            var i=list_data.indexOf(st)
            student.id=id
            list_data[i]=student}
        else{
            println("could not find student with id")
        }
    }
    fun delete_id(id:Int){
        var st=get_by_id(id)
        if(st!=null){
            var i=list_data.indexOf(st)
            list_data.removeAt(i)
        }
        else{
            println("could not find student with id")
        }

    }
    fun get_student_short_count():Int{
        return list_data.size
    }
    fun get_k_n_student_short_list(k:Int,n:Int):Data_list<Student_short>{
        require(n*k-1 in list_data.indices)
        val list_student=list_data.drop((k-1)*n).take(n)
        val short_list=list_student.map{Student_short(it)}
        return Data_list(short_list)
    }
    fun sort_by_name(){
        list_data.sortBy { it.getFIO() }
    }
}