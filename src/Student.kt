class Student{
    var id: String=""
        get(){
            return field
        }
        set(value){
            id=value
        }
    var lastName: String=""
        get() {
            return field
        }
        set(value){
            field=value
        }
    var firstName: String=""
        get() {
            return field
        }
        set(value){
            field=value
        }
    var surname: String=""
        get() {
            return field
        }
        set(value){
            field=value
        }
    var phone: String?=null
        get() {
            return field
        }
        set(value){
            field=value
        }
    var telegram: String?=null
        get() {
            return field
        }
        set(value){
            field=value
        }
    var email: String?=null
        get() {
            return field
        }
        set(value){
            field=value
        }
    var git: String?=null
        get() {
            return field
        }
        set(value){
            field=value
        }
    constructor(_lastName:String,_firstName:String,_surname:String){
        lastName=_lastName
        firstName=_firstName
        surname=_surname
    }
    fun printObj()
    {
        print("ID: $id, Фамилия: $lastName, Имя: $firstName, Отчество: $surname")
        if(phone!=null)
            print(", Телефон: $phone")
        if(telegram!=null)
            print(", Телеграм: $telegram")
        if(email!=null)
            print(", Почта: $email")
        if(git!=null)
            print(", Git: $git")
        println()
    }


}