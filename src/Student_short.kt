import Student
class Student_short: Student_super {
    private var FIO: String=""
        get(){
            return field
        }
    private var git: String?=null
        get(){
            return field
        }
    private var contact: String?=null
        get(){
            return field
        }
    constructor(student: Student){
        this.id=student.id
        this.FIO=student.getFIO()
        this.git=student.git
        this.contact=student.getContact()
    }


}