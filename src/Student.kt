class Student{
    var id: Int=0
        get(){
            return field
        }
        set(value){
            if(value>0)
                field=value
        }
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
        if(checkGit(this.git)&&(checkTg(this.telegram)|| checkEmail(this.email)|| checkPhone(this.phone))){
            println("Валидация пройдена")
            return true
        }
        else
            println("Валидация не пройдена")
            return false
    }
    companion object{
        var counter=0
        val phoneReg = Regex("^\\+7\\d{10}\$|^8\\d{10}\$")
        val fioReg=Regex("^[A-ZА-ЯЁ][a-zа-яё]{1,}$")
        val mailReg=Regex("^[a-zA-Z0-9_]{2,30}+@[a-zA-Z0-9.-]{2,}+\\.[a-zA-Z]{2,}\$")
        val telegramReg=Regex("^@+[a-zA-Z0-9_]{5,64}$")
        val gitReg=Regex("^[a-zA-Z0-9]+/[a-zA-Z0-9-_]+\$")
        fun checkGit(value: String?):Boolean{
            if(gitReg.matches(value.toString()))
                return true
            else
                return false
        }
        fun checkTg(value: String?):Boolean{
            if(telegramReg.matches(value.toString()))
                return true
            else
                return false
        }
        fun checkEmail(value: String?):Boolean{
            if(mailReg.matches(value.toString()))
                return true
            else
                return false
        }
        fun checkFio(value: String?):Boolean{
            if(fioReg.matches(value.toString()))
                return true
            else
                return false
        }
        fun checkPhone(value: String?):Boolean{
            if(phoneReg.matches(value.toString()))
                return true
            else
                return false
        }
    }
    init {
        counter++
    }
    constructor(_lastName:String,_firstName:String,_surname:String){
        id= counter
        lastName=_lastName
        firstName=_firstName
        surname=_surname
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


}