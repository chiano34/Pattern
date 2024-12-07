class Student_short: Student_super {
    internal var FIO: String=""
        get(){
            return field
        }
    internal var git: String?=null
        get(){
            return field
        }
    internal var contact: String?=null
        get(){
            return field
        }
    constructor(student: Student){
        this.id=student.id
        this.FIO=student.GetFIO()
        this.git=student.git
        this.contact=student.GetContact()
    }


}