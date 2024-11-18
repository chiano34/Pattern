class Student: Student_super{
    var lastName: String=""
        get() {
            return field
        }
        set(value){
            if(checkFio(value))
                field=value
        }
    var firstName: String=""
        get() {
            return field
        }
        set(value){
            if(checkFio(value))
                field=value
        }
    var surname: String=""
        get() {
            return field
        }
        set(value){
            if(checkFio(value))
                field=value
        }
    var phone: String?=null
        get() {
            return field
        }
        set(value){
            if(checkPhone(value))
                field=value
        }
    var telegram: String?=null
        get() {
            return field
        }
        set(value){
            if(checkTg(value))
                field=value
        }
    var email: String?=null
        get() {
            return field
        }
        set(value){
            if(checkEmail(value))
                field=value
        }
    var git: String?=null
        get() {
            return field
        }
        set(value){
            if(checkGit(value))
                field=value
        }

    fun validate():Boolean{
        if(checkGit(this.git)&&(getContact()!=null)){
            return true
        }
        else
            println("Валидация не пройдена")
            return false
    }
    fun set_contact(_email: String?=null,_phone: String?=null,_telegram: String?=null){
            this.email=_email
            this.phone=_phone
            this.telegram=_telegram
    }
    constructor(_lastName:String,_firstName:String,_surname:String){
        id= counter
        lastName=_lastName
        firstName=_firstName
        surname=_surname
    }
    constructor(_info:String){
        var args: List<String>
        args=_info.split(" ")
        id=counter
        lastName=args[0]
        firstName=args[1]
        surname=args[2]
        for(arg in args){
            if(arg.split("=")[0]=="phone"){
                phone=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="telegram"){
                telegram=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="email"){
                email=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="git"){
                git=arg.split("=")[1]
            }
        }

    }
    constructor(_lastName:String,_firstName:String,_surname:String,
                _phone:String?=null,_telegram:String?=null,_email:String?=null,_git:String?=null){
        id = counter
        lastName=_lastName
        firstName=_firstName
        surname=_surname
        phone=_phone
        telegram=_telegram
        email=_email
        git=_git
    }
    constructor(infoHash: HashMap<String,Any?>)
    {
        id= counter
        lastName=infoHash["lastName"].toString()
        firstName=infoHash["firstName"].toString()
        surname=infoHash["surname"].toString()
        phone=infoHash.getOrDefault("phone",null).toString()
        telegram=infoHash.getOrDefault("telegram",null).toString()
        email=infoHash.getOrDefault("email",null).toString()
        git=infoHash.getOrDefault("git",null).toString()
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
    fun getInfo()
    {
        print("ID: $id, Фамилия: $lastName, Имя: $firstName, Отчество: $surname")
        if(git!=null)
            print(", Git: $git")
        val contact = getContact()
        if(contact!=null){
            print(", Контакт: $contact")
        }
    }
    fun getFIO():String{
        val fio=lastName+" "+firstName[0]+"."+surname[0]+"."
        return fio
    }
    fun getContact():String?{
        if(telegram!=null)
            return telegram
        else if(phone!=null)
            return phone
        else if(email!=null)
            return email
        return null
    }


}